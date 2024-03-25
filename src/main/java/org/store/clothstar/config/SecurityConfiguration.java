package org.store.clothstar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/login", "/signup").permitAll()
			.antMatchers(HttpMethod.POST, "/v1/members").permitAll()
			.antMatchers(HttpMethod.GET, "/admin").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login");

		return http.build();
	}
}