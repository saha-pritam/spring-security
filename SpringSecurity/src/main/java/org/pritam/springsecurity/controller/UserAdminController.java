package org.pritam.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user_admin")
public class UserAdminController {
	@GetMapping("/one")
	public String one() {
		return "<h1>Hi I am One from user and admin.</h1>";
	}
	@GetMapping("/two")
	public String two() {
		return "<h1>Hi I am Two from user and admin.</h1>";
	}
	@GetMapping("/three")
	public String three() {
		return "<h1>Hi I am Three from user and admin.</h1>";
	}
}
