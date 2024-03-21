package org.store.clothstar.member.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
	private Long memberId;
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
}
