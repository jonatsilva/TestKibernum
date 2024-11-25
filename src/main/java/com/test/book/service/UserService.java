package com.test.book.service;

import java.util.Optional;

import com.test.book.entity.User;

public interface UserService {

	User createUser(User user);

	User updateUser(Long id, User user);

	void deleteUser(Long id);

	Optional <User> findByIdUser(Long id);

}
