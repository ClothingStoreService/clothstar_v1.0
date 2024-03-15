package org.store.clothstar.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.clothstar.member.dto.MemberDTO;
import org.store.clothstar.member.service.MemberService;

@RestController
public class MemberController {
	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping("/v1/members")
	public MemberDTO signup(MemberDTO memberDTO) {
		return memberService.save(memberDTO);
	}

	@GetMapping("/v1/members/{id}")
	public MemberDTO getMember(@PathVariable Long id) {
		return memberService.findById(id);
	}
}