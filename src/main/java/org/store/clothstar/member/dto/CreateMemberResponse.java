package org.store.clothstar.member.dto;

import org.store.clothstar.member.domain.MemberGrade;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateMemberResponse {
	private Long memberId;
	private String email;
	private String name;
	private String telNo;
	private int totalPaymentPrice;
	private MemberGrade grade;
	private boolean success;
	private String message;
}
