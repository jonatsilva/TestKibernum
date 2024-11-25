package com.test.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.book.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
