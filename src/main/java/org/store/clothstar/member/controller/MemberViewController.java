package org.store.clothstar.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberViewController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/admin")
	public String viewAdminPage() {
		return "admin";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
}
