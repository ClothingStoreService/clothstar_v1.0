package org.store.clothstar.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.clothstar.member.dto.MemberDTO;
import org.store.clothstar.member.repository.MemberRepository;

@Service
public class MemberService {
	private final MemberRepository memberRepository;

	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public MemberDTO save(MemberDTO memberDTO) {
		memberRepository.save(memberDTO.getEmail(), memberDTO.getPassword());
		return memberDTO;
	}

	public MemberDTO findById(Long id) {
		return memberRepository.findById(id);
	}
}
