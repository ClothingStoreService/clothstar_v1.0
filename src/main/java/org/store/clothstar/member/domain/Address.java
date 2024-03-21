package org.store.clothstar.member.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Address {
	private Long addressId;
	private Long memberId;
	private String receiverNm;
	private String zipNo;
	private String address1;
	private String address2;
	private String telNo;
	private String deliveryReq;
	private int isDefault;
}
