package org.pritam.springsecurity.controller;

import org.pritam.springsecurity.jwt.JwtUtil;
import org.pritam.springsecurity.model.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping("/generateToken")
	public ResponseEntity<Object> generateJWT(@RequestBody Credentials credentials){
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
		}
		catch(Exception e) {
			org.pritam.springsecurity.model.Error error = new org.pritam.springsecurity.model.Error(401,"Invalid Credentials.");
			return new ResponseEntity<Object>(error,HttpStatus.UNAUTHORIZED);
		}
		String jwtToken = jwtUtil.generateToken(userDetailsService.loadUserByUsername(credentials.getUsername()));
		return new ResponseEntity<Object>(jwtToken,HttpStatus.OK);
	}
}
