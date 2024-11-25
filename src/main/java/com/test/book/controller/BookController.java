package com.test.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.book.entity.Book;
import com.test.book.exception.BookNotFoundException;
import com.test.book.service.BookService;
import com.test.book.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	@Operation(summary = " Get a book by its id ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the book", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Book not found", content = @Content) }) // @formatter:on

	@PostMapping("/{idUser}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createBook(@Parameter(description = "id of User to be create new Book") @PathVariable("idUser") final Long idUser,
			@NotNull @Valid @RequestBody final Book book) {

		try {

			userService.findByIdUser(idUser).orElseThrow(BookNotFoundException::new);

			Book resp = bookService.createBook(book);
			return new ResponseEntity<Book>(resp, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{idBook}/{idUser}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> updateBook(
			@Parameter(description = "id of Book to be update") @PathVariable("idBook") final Long idBook,
			@Parameter(description = "id of User to be update Book") @PathVariable("idUser") final Long idUser,
			@RequestBody final Book book) {

		try {

			userService.findByIdUser(idUser).orElseThrow(BookNotFoundException::new);

			Book resp = bookService.updateBook(idBook, book);
			return new ResponseEntity<Book>(resp, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{idBook}/{idUser}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> deleteBook(
			@Parameter(description = "id of Book to be delete") @PathVariable("idBook") final Long idBook,
			@Parameter(description = "id of User to be delete Book") @PathVariable("idUser") final Long idUser) {

		try {

			userService.findByIdUser(idUser).orElseThrow(BookNotFoundException::new);

			bookService.deleteBook(idBook);
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{idBook}/{idUser}")
	public ResponseEntity<?> findByIdBook(
			@Parameter(description = "id of Book to be searched") @PathVariable final Long id,
			@Parameter(description = "id of User to be searched Book") @PathVariable("idUser") final Long idUser) {

		try {

			Book resp = bookService.findByIdBook(id).orElseThrow(BookNotFoundException::new);
			return new ResponseEntity<Book>(resp, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
