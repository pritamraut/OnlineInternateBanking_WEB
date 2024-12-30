package com.bankofamerica.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankofamerica.entity.User;
import com.bankofamerica.exception.UserAlreadyExistException;
import com.bankofamerica.exception.UserDataException;
import com.bankofamerica.repository.UserRepository;

@Component
public class ValidationUtil {
	
	@Autowired
	private UserRepository userRepository;
	
	public void validateUser(User user) {
		
		Optional<User> userData;
		
		//Field validation
		if(user.getFirstName() != null && user.getFirstName().isEmpty()) {
			throw new UserDataException("User first name is not found");
		}
		
		if(user.getLastName() != null && user.getLastName().isEmpty()) {
			throw new UserDataException("User last name is not found");
		}
		
		if(user.getEmail() != null && user.getEmail().isEmpty()) {
			throw new UserDataException("User email is not found");
		}
		
		if(user.getEmail() != null) {
			userData = userRepository.findByEmail(user.getEmail());
			if(userData.isPresent()) {
				throw new UserAlreadyExistException("User already exists with email");
			}
		}
		
		if(user.getPhoneNumber() != null) {
			userData = userRepository.findByPhoneNumber(user.getPhoneNumber());
			if(userData.isPresent()) {
				throw new UserAlreadyExistException("User already exists with phone number");
			}
		}
		
		if(user.getUserId() != null) {
			userData = userRepository.findByUserId(user.getUserId());
			if(userData.isPresent()) {
				throw new UserAlreadyExistException("User already exists with userId");
			}
		}
		
		if(user.getAddress() != null && user.getAddress().isEmpty()) {
			throw new UserDataException("User address is not found");
		}
		
		if(user.getPhoneNumber() != null && user.getPhoneNumber().isEmpty()) {
			throw new UserDataException("User phone number is not found");
		}
		
		if(user.getSsnNumber() != null && user.getSsnNumber().isEmpty()) {
			throw new UserDataException("User ssn number is not found");
		}
		
		if(user.getUserId() != null && user.getUserId().isEmpty()) {
			throw new UserDataException("User userid is not found");
		}
		
		if(user.getUserPassword() != null && user.getUserPassword().isEmpty()) {
			throw new UserDataException("User password is not found");
		}
		
		
		
		
		
	}

}
