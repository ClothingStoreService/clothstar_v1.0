package org.store.clothstar.member.service;

import org.springframework.stereotype.Service;
import org.store.clothstar.member.domain.Member;
import org.store.clothstar.member.dto.CreateMemberRequest;
import org.store.clothstar.member.dto.MemberResponse;
import org.store.clothstar.member.repository.MemberRepository;

@Service
public class MemberService {
	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Member save(CreateMemberRequest createMemberDTO) {
		Member member = createMemberDTO.toMember();
		return member;
	}

	public MemberResponse getMemberById(Long id) {
		Member member = memberRepository.findById(id);
		return new MemberResponse(member);
	}

	public MemberResponse getMemberByEmail(String email) {
		Member member = memberRepository.findByEmail(email);
		return new MemberResponse(member);
	}
}
