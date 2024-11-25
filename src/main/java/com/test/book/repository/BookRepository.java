package com.test.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.book.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
