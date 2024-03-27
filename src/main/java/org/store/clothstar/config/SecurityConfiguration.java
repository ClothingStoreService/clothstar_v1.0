package org.store.clothstar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.cors().disable()
			.authorizeRequests()
			// .antMatchers("/", "/login", "/signup", "/v1/members").permitAll()
			.anyRequest().permitAll()
			// .antMatchers(HttpMethod.GET, "/admin").hasRole("ADMIN")
			// .antMatchers(HttpMethod.GET, "/seller").hasRole("SELLER")
			// .antMatchers(HttpMethod.GET, "/user").hasRole("USER")
			.and()
			.formLogin()
			.loginPage("/login");

		return http.build();
	}
}