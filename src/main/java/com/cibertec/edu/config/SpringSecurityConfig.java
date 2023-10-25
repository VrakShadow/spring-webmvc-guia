package com.cibertec.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
		
	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests().requestMatchers("/","/css/**","/js/**","/images/**","/home").permitAll()
		.requestMatchers("/home/estudiante/**").hasAnyRole("ADMIN")
		.requestMatchers("/api/**").anonymous()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
		
		return http.build();
	}

	@Bean
	public static BCryptPasswordEncoder encriptador () {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		PasswordEncoder passEncoder = encriptador();
		
		UserBuilder userBuilder = User.builder().passwordEncoder(pass -> {
			return passEncoder.encode(pass);
		});
		
		builder.inMemoryAuthentication()
		.withUser(userBuilder.username("administrador").password("123456").roles("ADMIN","USER"))
		.withUser(userBuilder.username("jose").password("123456").roles("USER"));
	}
}
