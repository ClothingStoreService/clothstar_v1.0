package org.store.clothstar.member.dto;

import org.store.clothstar.common.domain.Flag;
import org.store.clothstar.member.domain.AddressInfo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAddressInfoRequest {
	private Long memberId;
	private String receiverNm;
	private String zipNo;
	private String address1;
	private String address2;
	private String telNo;
	private String deliveryReq;
	private Flag defaultFg;

	public AddressInfo toAddressInfo() {
		return AddressInfo.builder()
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
