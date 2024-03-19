package org.store.clothstar.member.dto;

import java.time.LocalDateTime;

import org.store.clothstar.member.domain.Member;
import org.store.clothstar.member.domain.MemberGrade;
import org.store.clothstar.member.domain.MemberRole;

import lombok.Getter;

@Getter
public class MemberResponse {
	private Long memberId;
	private String email;
	private String password;
	private String name;
	private String telNo;
	private int buyAmt;
	private MemberRole role;
	private MemberGrade grade;
	private LocalDateTime createdAt;

	public MemberResponse(Member member) {
		this.memberId = member.getMemberId();
		this.email = member.getEmail();
		this.password = member.getPassword();
		this.name = member.getName();
		this.telNo = member.getTelNo();
		this.buyAmt = member.getBuyAmt();
		this.role = member.getRole();
		this.grade = member.getGrade();
		this.createdAt = member.getCreatedAt();
	}
}
