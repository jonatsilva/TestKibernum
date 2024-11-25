package com.test.book.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.book.entity.User;
import com.test.book.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {

		return userRepository.save(user);

	}

	@Override
	public User updateUser(Long id, User user) {

		User result = userRepository.findById(id).get();

		if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
			result.setName(user.getName());
		}

		if (Objects.nonNull(user.getSurname()) && !"".equalsIgnoreCase(user.getSurname())) {
			result.setSurname(user.getSurname());
		}

		if (Objects.nonNull(user.getMail()) && !"".equalsIgnoreCase(user.getMail())) {
			result.setMail(user.getMail());
		}

		if (Objects.nonNull(user.getRun())) {
			result.setRun(user.getRun());
		}

		return userRepository.save(result);
	}

	@Override
	public void deleteUser(Long id) {

		userRepository.deleteById(id);
	}

	@Override
	public Optional<User> findByIdUser(Long id) {

		return Optional.ofNullable(userRepository.findById(id).get());
	}

}
