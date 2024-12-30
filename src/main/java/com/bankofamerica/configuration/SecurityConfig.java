package com.bankofamerica.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.bankofamerica.component.CustomAuthenticationSuccessHandler;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		

        // HTTP request authorization
        .authorizeHttpRequests(authz -> authz
            .requestMatchers("/login", "/register-user","/","/css/**").permitAll()  // Allow access to login/signup without authentication
            .anyRequest().authenticated()  // All other requests require authentication
        )
     // Custom login page handling
        .formLogin(form -> form
            .loginPage("/login")  // Specify the URL for your custom login page
            .defaultSuccessUrl("/home") // Redirect to /home after successful login
            .permitAll()  // Allow everyone to access the login page
       )
	   .logout(logout -> logout.permitAll());

    return http.build(); // Return the Security Filter Chain
            
    }

	// Provide an AuthenticationManager to handle authentication
	// @Bean
	// public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
	// 	AuthenticationManagerBuilder authenticationManagerBuilder = http
	// 			.getSharedObject(AuthenticationManagerBuilder.class);
	// 	authenticationManagerBuilder.inMemoryAuthentication().passwordEncoder(passwordEncoder()) // Use the password
	// 																								// encoder
	// 			.withUser(User.withUsername("pritam").password("pritam").roles("USER"))
	// 			.withUser(User.withUsername("admin").password("admin").roles("ADMIN"));
	// 	return authenticationManagerBuilder.build();
	// }

	// // PasswordEncoder Bean to hash passwords (BCrypt)
	// @Bean
	// public PasswordEncoder passwordEncoder() {
	// 	return new BCryptPasswordEncoder();
	// }

	@Bean
	public UserDetailsService userDetailsService(){
		UserDetails user = User.withDefaultPasswordEncoder()
		.username("user")
		.password("password")
		.roles("USER")
		.build();

		return new InMemoryUserDetailsManager(user);
	}

}
