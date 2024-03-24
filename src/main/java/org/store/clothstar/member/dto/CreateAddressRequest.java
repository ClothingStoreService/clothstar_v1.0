package org.store.clothstar.member.dto;

import org.store.clothstar.member.domain.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {
	private String receiverName;
	private String zipNo;
	private String addressBasic;
	private String addressDetail;
	private String telNo;
	private String deliveryRequest;
	private boolean defaultAddress;

	public Address toAddress(Long memberId) {
		return Address.builder()
			.memberId(memberId)
			.receiverName(receiverName)
			.zipNo(zipNo)
			.addressBasic(addressBasic)
			.addressDetail(addressDetail)
			.telNo(telNo)
			.deliveryRequest(deliveryRequest)
			.defaultAddress(defaultAddress)
			.build();
	}
}
