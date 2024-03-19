package org.store.clothstar.member.dto;

import org.store.clothstar.member.domain.Seller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSellerRequest {
	private Long memberId;
	private String brandNm;
	private String bizNo;

	public Seller toSeller() {
		return Seller.builder()
			.memberId(memberId)
			.brandNm(brandNm)
			.bizNo(bizNo)
			.build();
	}
}
