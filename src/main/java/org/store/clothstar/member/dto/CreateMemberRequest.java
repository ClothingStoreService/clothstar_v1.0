package org.store.clothstar.member.dto;

import java.time.LocalDateTime;

import org.store.clothstar.member.domain.Member;
import org.store.clothstar.member.domain.MemberGrade;
import org.store.clothstar.member.domain.MemberRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMemberRequest {
	private String email;
	private String password;
	private String name;
	private String telNo;

	public Member toMember() {
		return Member.builder()
			.email(email)
			.password(password)
			.name(name)
			.telNo(telNo)
			.totalPaymentPrice(0)
			.point(0)
			.role(MemberRole.USER)
			.grade(MemberGrade.BRONZE)
			.createdAt(LocalDateTime.now())
			.build();
	}
}
