package org.store.clothstar.member.dto;

import org.store.clothstar.member.domain.Member;

import lombok.Getter;

@Getter
public class MemberResponse {
	String email;

	public MemberResponse(Member member) {
		this.email = member.getEmail();
	}
}
