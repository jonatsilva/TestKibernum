package com.test.book.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.book.entity.Book;
import com.test.book.repository.BookRepository;

@Component
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book createBook(Book book) {

		return bookRepository.save(book);

	}

	@Override
	public Book updateBook(Long id, Book book) {

		Book result = bookRepository.findById(id).get();

		if (Objects.nonNull(book.getTitle()) && !"".equalsIgnoreCase(book.getTitle())) {
			result.setTitle(book.getTitle());
		}
		
		if (Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor())) {
			result.setAuthor(book.getAuthor());
		}
		
		if (Objects.nonNull(book.getSku()) && !"".equalsIgnoreCase(book.getSku())) {
			result.setSku(book.getSku());
		}
		
		if (Objects.nonNull(book.getPrice())) {
			result.setPrice(book.getPrice());
		}

		return bookRepository.save(result);
	}

	@Override
	public void deleteBook(Long id) {

		bookRepository.deleteById(id);
	}

	@Override
	public Optional<Book> findByIdBook(Long id) {

		return Optional.ofNullable(bookRepository.findById(id).get());
	}

	
}
