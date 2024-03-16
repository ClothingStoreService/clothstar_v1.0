package org.store.clothstar.member.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {
	private Long id;
	private String email;
	private String password;

	@Builder
	public Member(String email, String password) {
		this.email = email;
		this.password = password;
	}
}
