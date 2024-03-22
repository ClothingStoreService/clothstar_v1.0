package org.store.clothstar.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.store.clothstar.member.domain.Member;
import org.store.clothstar.member.dto.CreateMemberRequest;
import org.store.clothstar.member.dto.MemberResponse;
import org.store.clothstar.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	public Member signup(CreateMemberRequest createMemberDTO) {
		Member member = createMemberDTO.toMember();
		memberRepository.save(member);
		return member;
	}

	public List<MemberResponse> getAllMember() {
		List<Member> memberList = memberRepository.findAll();

		List<MemberResponse> memberResponseList = memberList.stream()
			.map(MemberResponse::new)
			.collect(Collectors.toList());

		return memberResponseList;
	}

	public MemberResponse getMemberById(Long memberId) {
		Member member = memberRepository.findById(memberId);
		return new MemberResponse(member);
	}

	public MemberResponse getMemberByEmail(String email) {
		Member member = memberRepository.findByEmail(email);
		return new MemberResponse(member);
	}

}
