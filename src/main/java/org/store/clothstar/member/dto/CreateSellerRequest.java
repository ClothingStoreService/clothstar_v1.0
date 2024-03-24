package org.store.clothstar.member.dto;

import java.time.LocalDateTime;

import org.store.clothstar.member.domain.Seller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSellerRequest {
	private String brandName;
	private String bizNo;

	public Seller toSeller(Long memberId) {
		return Seller.builder()
			.memberId(memberId)
			.brandName(brandName)
			.bizNo(bizNo)
			.totalSellPrice(0)
			.createdAt(LocalDateTime.now())
			.build();
	}
}
