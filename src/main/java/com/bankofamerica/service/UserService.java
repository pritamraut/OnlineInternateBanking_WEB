package com.bankofamerica.service;

import org.springframework.stereotype.Service;

import com.bankofamerica.entity.User;

@Service
public interface UserService {
	
	public void registerUser(User user);
	
	public User getUsser(Long userId);

}
