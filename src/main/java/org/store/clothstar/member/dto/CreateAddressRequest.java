package org.store.clothstar.member.dto;

import org.store.clothstar.member.domain.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {
	private Long memberId;
	private String receiverNm;
	private String zipNo;
	private String address1;
	private String address2;
	private String telNo;
	private String deliveryReq;
	private int isDefault;

	public Address toAddress(Long memberId) {
		return Address.builder()
			.memberId(memberId)
			.receiverNm(receiverNm)
			.zipNo(zipNo)
			.address1(address1)
			.address2(address2)
			.telNo(telNo)
			.deliveryReq(deliveryReq)
			.isDefault(isDefault)
			.build();
	}
}
