package org.store.clothstar.member.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {
	private Long memberId;
	private Long sellerId;
	private String email;
	private String password;
	private String name;
	private String telNo;
	private int buyAmt;
	private MemberRole role;
	private MemberGrade grade;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private LocalDateTime deletedAt;

	@Builder
	public Member(String email, String password, String name, String telNo) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.telNo = telNo;
	}

}
