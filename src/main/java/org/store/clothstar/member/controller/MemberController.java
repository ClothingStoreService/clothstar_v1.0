package org.store.clothstar.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.clothstar.member.domain.Member;
import org.store.clothstar.member.dto.CreateMemberRequest;
import org.store.clothstar.member.dto.MemberResponse;
import org.store.clothstar.member.service.MemberService;

@RestController
public class MemberController {
	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/v1/members/{id}")
	public MemberResponse getMember(@PathVariable Long id) {
		return memberService.getMemberById(id);
	}

	@PostMapping("/v1/members")
	public Member signup(CreateMemberRequest createMemberDTO) {
		return memberService.save(createMemberDTO);
	}

}