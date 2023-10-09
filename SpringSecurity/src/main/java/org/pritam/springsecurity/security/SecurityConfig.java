package org.pritam.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.inMemoryAuthentication().withUser("pritam").password("pritam").roles("USER").and()
		.withUser("basudev").password("basudev").roles("ADMIN").and()
		.withUser("saurav").password("saurav").roles("SUPERADMIN");
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").hasAnyRole("ADMIN","SUPERADMIN")
		.antMatchers("/user/**").hasAnyRole("USER","SUPERADMIN")
		.antMatchers("/user_admin/**").hasAnyRole("USER","ADMIN","SUPERADMIN")
		.anyRequest().permitAll().and().formLogin();
	}



	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
