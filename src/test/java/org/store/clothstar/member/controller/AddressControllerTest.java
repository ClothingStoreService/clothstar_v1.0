package org.store.clothstar.member.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.store.clothstar.member.dto.AddressResponse;
import org.store.clothstar.member.dto.CreateAddressRequest;
import org.store.clothstar.member.service.AddressService;

@ExtendWith(MockitoExtension.class)
class AddressControllerUnitTest {
	@Mock
	AddressService addressService;
	@Mock
	AddressResponse addressResponse;
	@InjectMocks
	AddressController addressController;

	@DisplayName("회원 배송지 저장 단위 테스트")
	@Test
	void testAddrSave() {
		//given
		BDDMockito.given(addressService.addrSave(Mockito.anyLong(), Mockito.any(CreateAddressRequest.class)))
			.willReturn(addressResponse);

		//when
		addressResponse = addressController.addrSave(1L, new CreateAddressRequest());

		//then
		Mockito.verify(addressService, Mockito.times(1))
			.addrSave(Mockito.anyLong(), Mockito.any(CreateAddressRequest.class));
	}
}