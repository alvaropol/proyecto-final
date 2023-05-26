package com.salesianostriana.dam.proyectofinal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

		return authBuilder.authenticationProvider(daoAuthenticationProvider()).build();

	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
			.antMatchers("/css/**","/js/**","/webjars/**","/img/**","/fonts/**","/h2-console/**").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/productos/**","/carrito/**","/productoACarrito/**","/borrarProducto/**").authenticated()
			.anyRequest().permitAll()
			.and()
		.formLogin() 
			.loginPage("/login/")
			.defaultSuccessUrl("/")
			.permitAll()
			.and()
				.logout()
				.logoutUrl("/logout/")
				.logoutSuccessUrl("/")
			.permitAll();
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}

}
