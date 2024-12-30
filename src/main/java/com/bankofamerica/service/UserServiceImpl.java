package com.bankofamerica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankofamerica.entity.User;
import com.bankofamerica.repository.UserRepository;
import com.bankofamerica.util.ValidationUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ValidationUtil validationUtil;

	@Override
	public void registerUser(User user) {
		
		validationUtil.validateUser(user);
		User registeredUser = userRepository.save(user);

	}

	@Override
	public User getUsser(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		return user.get();
	}

}
