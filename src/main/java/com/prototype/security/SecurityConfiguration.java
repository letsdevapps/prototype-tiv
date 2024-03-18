package com.prototype.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChainPermit(HttpSecurity http) throws Exception {
		log.info("----- Security Configuration | Filter chain permit -----");

		http.httpBasic()
	    	.and()
	    	.authorizeRequests()
			.antMatchers("/login/**").permitAll()
			.anyRequest().authenticated()
			.and().formLogin()
			.and().logout();

		http.csrf().disable();

		return http.build();
	}

	@Bean
	public UserDetailsService users() {
		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();
		UserDetails blank = users.username("7").password("7").roles("USER").build();
		UserDetails user = users.username("user").password("user").roles("USER").build();
		return new InMemoryUserDetailsManager(blank, user);
	}
}