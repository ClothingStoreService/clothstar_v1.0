package org.store.clothstar.member.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.store.clothstar.member.domain.Address;
import org.store.clothstar.member.dto.AddressResponse;
import org.store.clothstar.member.dto.CreateAddressRequest;
import org.store.clothstar.member.repository.AddressRepository;

@ExtendWith(MockitoExtension.class)
class AddressServiceUnitTest {
	@Mock
	AddressRepository addressRepository;

	@InjectMocks
	AddressService addressService;

	private Long memberId = 1L;

	@DisplayName("회원 배송지 저장 단위 테스트")
	@Test
	void saveMemberAddrUnitTest() {
		//given
		BDDMockito.given(addressRepository.save(Mockito.any(Address.class))).willReturn(1);

		//when
		addressService.addrSave(memberId, getCreateAddressRequest());

		//then
		Mockito.verify(addressRepository, Mockito.times(1))
			.save((Mockito.any(Address.class)));
	}

	@DisplayName("회원 배송지 조회 단위 테스트")
	@Test
	void getMemberAddrUnitTest() {
		//given
		BDDMockito.given(addressRepository.findMemberAddress(Mockito.anyLong()))
			.willReturn(getAddressList());

		//when
		List<AddressResponse> memberAddressResponseList = addressService.getAllMemberAddress(memberId);

		//then
		Mockito.verify(addressRepository, Mockito.times(1))
			.findMemberAddress((Mockito.anyLong()));
		Assertions.assertThat(memberAddressResponseList.size()).isEqualTo(2);
	}

	private CreateAddressRequest getCreateAddressRequest() {
		final String receiverName = "receiverName";
		final String zipNo = "zipNo";
		final String addressBasic = "addressBasic";
		final String addressDetail = "addressDetail";
		final String telNo = "telNo";
		final String deliveryRequest = "deliveryRequest";
		final boolean defaultAddress = true;

		CreateAddressRequest createAddressRequest = new CreateAddressRequest(
			receiverName, zipNo, addressBasic, addressDetail, telNo, deliveryRequest, defaultAddress
		);
		return createAddressRequest;
	}

	private List<Address> getAddressList() {
		List<Address> addressList = new ArrayList<>();
		addressList.add(getCreateAddressRequest().toAddress(memberId));
		addressList.add(getCreateAddressRequest().toAddress(memberId));

		return addressList;
	}
}