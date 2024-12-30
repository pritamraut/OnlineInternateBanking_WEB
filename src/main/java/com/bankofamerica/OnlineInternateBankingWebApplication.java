package com.bankofamerica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.bankofamerica.entity.User;
import com.bankofamerica.service.UserServiceImpl;

@SpringBootApplication
public class OnlineInternateBankingWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineInternateBankingWebApplication.class, args);
		/*
		 * UserServiceImpl bean = applicationContext.getBean(UserServiceImpl.class);
		 * 
		 * 
		 * User user = new User(); user.setId(1L); user.setFirstName("John");
		 * user.setLastName("Doe"); user.setEmail("johndoe@example.com");
		 * user.setPhoneNumber("123-456-7890"); user.setAddress("123 Main Street");
		 * user.setSsnNumber("123-45-6789"); user.setUserId("johndoe123");
		 * user.setUserPassword("password123"); bean.registerUser(user);
		 */
		
		
		/* User user = bean.getUsser(1L); System.out.println(user); */
		 
	}

}
