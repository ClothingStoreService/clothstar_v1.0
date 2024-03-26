package org.store.clothstar.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberViewController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/admin")
	@ResponseBody
	public String viewAdminPage() {
		return "admin page";
	}

	@GetMapping("/user")
	@ResponseBody
	public String viewUserPage() {
		return "user page";
	}

	@GetMapping("/seller")
	@ResponseBody
	public String viewSellerPage() {
		return "seller page";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
}
