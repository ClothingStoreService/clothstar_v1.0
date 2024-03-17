package org.store.clothstar.member.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SellerInfo {
	private Long sellerId;
	private String brandName;
	private String bizNo;

	@Builder
	public SellerInfo(String brandName, String bizNo) {
		this.brandName = brandName;
		this.bizNo = bizNo;
	}
}
