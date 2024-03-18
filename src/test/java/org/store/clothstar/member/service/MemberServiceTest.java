package org.store.clothstar.member.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.store.clothstar.member.dto.MemberDTO;
import org.store.clothstar.member.repository.MemberRepository;

@SpringBootTest
class MemberServiceTest {

	@Autowired
	MemberRepository memberRepository;

	@DisplayName("회원가입 조회 테스트")
	@Test
	void signup_find() {
		//given
		MemberDTO memberDTO = new MemberDTO("email5", "password");

		//when
		int result = memberRepository.save(memberDTO);
		MemberDTO member1 = memberRepository.findById(1L);
		MemberDTO member2 = memberRepository.findByEmail("email5");

		//then
		assertThat(result).isEqualTo(1);
		assertThat(member1).isNotNull();
		assertThat(member2.getEmail()).isEqualTo(memberDTO.getEmail());
	}
}