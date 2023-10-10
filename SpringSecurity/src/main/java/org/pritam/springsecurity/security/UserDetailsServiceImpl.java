package org.pritam.springsecurity.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username.equals("pritam"))
			return new User("pritam","pritam",List.of(new SimpleGrantedAuthority("ROLE_USER")));
		else if(username.equals("basudev"))
			return new User("basudev","basudev",List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
		else if(username.equals("saurav"))
			return new User("saurav","saurav",List.of(new SimpleGrantedAuthority("ROLE_SUPERADMIN")));
		else
			throw new UsernameNotFoundException("Username not found");
	}

}
