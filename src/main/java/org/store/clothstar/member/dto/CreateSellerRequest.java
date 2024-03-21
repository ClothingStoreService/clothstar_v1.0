package org.store.clothstar.member.dto;

import org.store.clothstar.member.domain.Seller;

import lombok.Getter;

@Getter
public class CreateSellerRequest {
	private Long memberId;
	private String brandNm;
	private String bizNo;

	public Seller toSeller(Long memberId) {
		return Seller.builder()
			.memberId(memberId)
			.brandNm(brandNm)
			.bizNo(bizNo)
			.build();
	}
}
