package org.store.clothstar.member.domain;

import org.store.clothstar.common.domain.Flag;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AddressInfo {
	private Long addressInfoId;
	private Long memberId;
	private String receiverNm;
	private String zipNo;
	private String address1;
	private String address2;
	private String telNo;
	private String deliveryReq;
	private Flag defaultFg;

	@Builder
	public AddressInfo(Long addressInfoId, Long memberId, String receiverNm, String zipNo, String address1,
		String address2, String telNo, String deliveryReq, Flag defaultFg) {
		this.addressInfoId = getAddressInfoId();
		this.memberId = memberId;
		this.receiverNm = receiverNm;
		this.zipNo = zipNo;
		this.address1 = address1;
		this.address2 = address2;
		this.telNo = telNo;
		this.deliveryReq = deliveryReq;
		this.defaultFg = defaultFg;
	}
}
