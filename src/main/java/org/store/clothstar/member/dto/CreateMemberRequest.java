package org.store.clothstar.member.dto;

import org.store.clothstar.member.domain.Member;

import lombok.Getter;

@Getter
public class CreateMemberRequest {
	private String email;
	private String password;
	private String name;
	private String telNo;

	public CreateMemberRequest(String email, String password, String name, String telNo) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.telNo = telNo;
	}

	public Member toMember() {
		return Member.builder()
			.email(email)
			.password(password)
			.name(name)
			.telNo(telNo)
			.build();
	}
}
