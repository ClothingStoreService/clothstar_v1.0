package org.store.clothstar.member.dto;

import org.store.clothstar.common.domain.Flag;
import org.store.clothstar.member.domain.Address;

import lombok.Getter;

@Getter
public class AddressResponse {
	private Long memberId;
	private String receiverNm;
	private String zipNo;
	private String address1;
	private String address2;
	private String telNo;
	private String deliveryReq;
	private Flag defaultFg;

	public AddressResponse(Address address) {
		this.memberId = address.getMemberId();
		this.receiverNm = address.getReceiverNm();
		this.zipNo = address.getZipNo();
		this.address1 = address.getAddress1();
		this.address2 = address.getAddress2();
		this.telNo = address.getTelNo();
		this.deliveryReq = address.getDeliveryReq();
		this.defaultFg = address.getDefaultFg();
	}
}
