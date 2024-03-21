package org.store.clothstar.member.dto;

import java.time.LocalDateTime;

import org.store.clothstar.member.domain.Seller;

import lombok.Getter;

@Getter
public class SellerResponse {
	private Long memberId;
	private String brandNm;
	private String bizNo;
	private int sellAmt;
	private LocalDateTime createdAt;

	public SellerResponse(Seller seller) {
		this.memberId = seller.getMemberId();
		this.brandNm = seller.getBrandNm();
		this.bizNo = seller.getBizNo();
		this.sellAmt = seller.getSellAmt();
		this.createdAt = seller.getCreatedAt();
	}
}
