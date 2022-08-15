package com.example.sprningboote;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.inMemoryAuthentication()
				.withUser("user")
				.password("{noop}password")
				.roles("USER");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers("/example/*")
				.hasRole("USER")
				.and()
				.authorizeRequests()
				.antMatchers("/actuator/*", "/h2-console/*")
				.permitAll()
				.and()
				.csrf()
				.disable()
				.formLogin()
				.disable();

		http.headers()
				.frameOptions()
				.sameOrigin();
	}

}
