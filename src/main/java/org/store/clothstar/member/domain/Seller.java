package org.store.clothstar.member.domain;

import java.time.LocalDateTime;

import org.store.clothstar.common.domain.Flag;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Seller {
	private Long memberId;
	private String brandNm;
	private String bizNo;
	private int sellAmt;
	private Flag sellFg;
	private LocalDateTime createdAt;
}
