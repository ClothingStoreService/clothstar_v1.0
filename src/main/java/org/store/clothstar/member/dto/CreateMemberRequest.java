package org.store.clothstar.member.dto;

import org.store.clothstar.member.domain.Member;

import lombok.Getter;

@Getter
public class CreateMemberRequest {
	private String email;
	private String password;

	public CreateMemberRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Member toMember() {
		return Member.builder()
			.email(email)
			.password(password)
			.build();
	}
}
