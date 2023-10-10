package org.pritam.springsecurity.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.pritam.springsecurity.entity.User;
import org.pritam.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User getUserByUsername(String username) {
		Optional<User> optionalUser = userRepository.findById(username);
		if(optionalUser.isPresent())
			return optionalUser.get();
		return null;
	}
}
