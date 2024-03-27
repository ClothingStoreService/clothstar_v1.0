package org.store.clothstar.member.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.clothstar.member.dto.CreateMemberRequest;
import org.store.clothstar.member.dto.CreateMemberResponse;
import org.store.clothstar.member.dto.MemberResponse;
import org.store.clothstar.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;

	@GetMapping("/v1/members")
	public List<MemberResponse> getAllMember() {
		return memberService.getAllMember();
	}

	@GetMapping("/v1/members/{id}")
	public MemberResponse getMember(@PathVariable("id") Long memberId) {
		return memberService.getMemberById(memberId);
	}

	@PostMapping("/v1/members")
	public ResponseEntity<CreateMemberResponse> signup(@RequestBody CreateMemberRequest createMemberDTO) {
		return memberService.signup(createMemberDTO);
	}
}