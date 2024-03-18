package org.store.clothstar.member.dto;

import org.store.clothstar.common.domain.Flag;
import org.store.clothstar.member.domain.AddressInfo;

import lombok.Getter;

@Getter
public class AddressInfoResponse {
	private String receiverNm;
	private String zipNo;
	private String address1;
	private String address2;
	private String telNo;
	private String deliveryReq;
	private Flag defaultFg;

	public AddressInfoResponse(AddressInfo addressInfo) {
		this.receiverNm = addressInfo.getReceiverNm();
		this.zipNo = addressInfo.getZipNo();
		this.address1 = addressInfo.getAddress1();
		this.address2 = addressInfo.getAddress2();
		this.telNo = addressInfo.getTelNo();
		this.deliveryReq = addressInfo.getDeliveryReq();
		this.defaultFg = addressInfo.getDefaultFg();
	}
}
