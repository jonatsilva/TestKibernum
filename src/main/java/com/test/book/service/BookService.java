package com.test.book.service;

import java.util.Optional;

import com.test.book.entity.Book;

public interface BookService {

	Book createBook(Book book);

	Book updateBook(Long id, Book book);

	void deleteBook(Long id);

	Optional<Book> findByIdBook(Long id);

}
