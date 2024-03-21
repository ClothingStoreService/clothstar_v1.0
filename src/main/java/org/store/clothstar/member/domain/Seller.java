package org.store.clothstar.member.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Seller {
	private Long memberId;
	private String brandNm;
	private String bizNo;
	private int sellAmt;
	private String authority;
	private LocalDateTime createdAt;
}
