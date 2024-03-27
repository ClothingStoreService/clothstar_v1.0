package org.store.clothstar.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.store.clothstar.member.domain.Member;
import org.store.clothstar.member.dto.CreateMemberRequest;
import org.store.clothstar.member.dto.CreateMemberResponse;
import org.store.clothstar.member.dto.MemberResponse;
import org.store.clothstar.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	public ResponseEntity<CreateMemberResponse> signup(CreateMemberRequest createMemberDTO) {
		Member member = createMemberDTO.toMember();
		CreateMemberResponse createMemberResponse = null;

		try {
			memberRepository.save(member);
		} catch (Exception e) {
			createMemberResponse = createMemberResponse.builder()
				.success(false)
				.message(e.getMessage())
				.build();

			return ResponseEntity.status(500).body(createMemberResponse);
		}

		createMemberResponse = createMemberResponse.builder()
			.memberId(member.getMemberId())
			.email(member.getEmail())
			.name(member.getName())
			.telNo(member.getTelNo())
			.grade(member.getGrade())
			.totalPaymentPrice(member.getTotalPaymentPrice())
			.success(true)
			.message("회원가입 완료 되었습니다.")
			.build();

		return ResponseEntity.ok(createMemberResponse);
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

	public Member emailCheck(String email) {
		return null;
	}
}