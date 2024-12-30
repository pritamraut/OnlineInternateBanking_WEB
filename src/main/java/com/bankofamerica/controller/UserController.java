package com.bankofamerica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankofamerica.entity.User;
import com.bankofamerica.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/register-user")
	public String getRegisterorm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user) {
		System.out.println(user);
		try {
			userService.registerUser(user);
			return "registration";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}

	}

	@GetMapping("/login")
	public String Login() {
		return "login";
	}

	@GetMapping("/home")
	public String home() {
		return "home"; 
	}

	@GetMapping("/dummy")
	public String dummyPage() {
		return "dummy";
	}

}
