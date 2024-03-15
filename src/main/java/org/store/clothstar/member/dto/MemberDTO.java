package org.store.clothstar.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
	private Long id;
	private String email;
	private String password;

	public MemberDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}
}
