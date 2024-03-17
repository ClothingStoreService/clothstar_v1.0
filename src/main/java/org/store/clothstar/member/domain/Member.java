package org.store.clothstar.member.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {
	private Long memberId;
	private Long sellerId;
	private String email;
	private String password;
	private String name;
	private String telNo;
	private int buyAmount;
	private MemberRole role;
	private MemberGrade grade;
	private LocalDateTime createdDt;
	private LocalDateTime modifiedDt;
	private LocalDateTime deletedDt;

	@Builder
	public Member(String email, String password, String name, String telNo) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.telNo = telNo;
	}
}
