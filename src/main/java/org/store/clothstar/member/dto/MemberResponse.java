package org.store.clothstar.member.dto;

import java.time.LocalDateTime;

import org.store.clothstar.member.domain.Member;
import org.store.clothstar.member.domain.MemberGrade;
import org.store.clothstar.member.domain.MemberRole;

import lombok.Getter;

@Getter
public class MemberResponse {
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

	public MemberResponse(Member member) {
		this.email = member.getEmail();
		this.password = member.getPassword();
		this.name = member.getName();
		this.telNo = member.getTelNo();
		this.buyAmount = member.getBuyAmount();
		this.role = member.getRole();
		this.grade = member.getGrade();
		this.createdDt = member.getCreatedDt();
		this.modifiedDt = member.getModifiedDt();
		this.deletedDt = member.getDeletedDt();
	}
}
