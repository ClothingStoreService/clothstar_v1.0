package org.store.clothstar.member.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.store.clothstar.member.domain.Member;
import org.store.clothstar.member.domain.MemberGrade;
import org.store.clothstar.member.domain.MemberRole;
import org.store.clothstar.member.dto.CreateMemberRequest;
import org.store.clothstar.member.dto.MemberResponse;
import org.store.clothstar.member.repository.MemberRepository;

@ExtendWith(MockitoExtension.class)
class MemberServiceUnitTest {
	@Mock
	MemberRepository memberRepository;
	@InjectMocks
	MemberService memberService;

	@DisplayName("회원가입 단위 테스트")
	@Test
	void test() {
		//given
		BDDMockito.given(memberRepository.save(Mockito.any(Member.class))).willReturn(1);

		//when
		memberService.signup(getCreateMemberRequest());

		//then
		Mockito.verify(memberRepository, Mockito.times(1))
			.save(Mockito.any(Member.class));
	}

	@DisplayName("회원아이디로 회원 조회 테스트")
	@Test
	void getMemberTest() {
		//given
		Member member = getMember();
		BDDMockito.given(memberRepository.findById(Mockito.anyLong())).willReturn(member);

		//when
		MemberResponse memberResponse = memberService.getMemberById(1L);

		//then
		Mockito.verify(memberRepository, Mockito.times(1))
			.findById(Mockito.anyLong());

		Assertions.assertThat(memberResponse.getMemberId()).isEqualTo(member.getMemberId());
		Assertions.assertThat(memberResponse.getEmail()).isEqualTo(member.getEmail());
	}

	private CreateMemberRequest getCreateMemberRequest() {
		String email = "test email";
		String password = "test pw";
		String name = "test name";
		String telNo = "tel No";

		CreateMemberRequest createMemberRequest = new CreateMemberRequest(
			email, password, name, telNo
		);

		return createMemberRequest;
	}

	private Member getMember() {
		return Member.builder()
			.memberId(1L)
			.email("test")
			.password("test")
			.telNo("telNo")
			.role(MemberRole.USER)
			.grade(MemberGrade.BRONZE)
			.build();
	}
}