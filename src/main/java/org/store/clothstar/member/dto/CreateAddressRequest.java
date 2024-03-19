package org.store.clothstar.member.dto;

import org.store.clothstar.common.domain.Flag;
import org.store.clothstar.member.domain.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressRequest {
	private Long memberId;
	private String receiverNm;
	private String zipNo;
	private String address1;
	private String address2;
	private String telNo;
	private String deliveryReq;
	private Flag defaultFg;

	public Address toAddress() {
		return Address.builder()
			.memberId(memberId)
			.receiverNm(receiverNm)
			.zipNo(zipNo)
			.address1(address1)
			.address2(address2)
			.telNo(telNo)
			.deliveryReq(deliveryReq)
			.defaultFg(defaultFg)
			.build();
	}
}
