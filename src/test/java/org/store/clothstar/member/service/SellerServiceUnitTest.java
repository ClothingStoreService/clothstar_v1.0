package org.store.clothstar.member.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.store.clothstar.member.domain.Seller;
import org.store.clothstar.member.dto.CreateSellerRequest;
import org.store.clothstar.member.dto.SellerResponse;
import org.store.clothstar.member.repository.SellerRepository;

@ExtendWith(MockitoExtension.class)
class SellerServiceUnitTest {
	@Mock
	SellerRepository sellerRepository;

	@InjectMocks
	SellerService sellerService;

	@DisplayName("판매회원 등록 단위 테스트")
	@Test
	void registerSellerUnitTest() {
		//given
		Long memberId = 1L;
		BDDMockito.given(sellerRepository.save(Mockito.any(Seller.class))).willReturn(1);

		//when
		sellerService.sellerSave(memberId, getCreateSellerRequest());

		//then
		Mockito.verify(sellerRepository, Mockito.times(1))
			.save(Mockito.any(Seller.class));
	}

	@DisplayName("판매회원 조회 단위 테스트")
	@Test
	void getSellerUnitTest() {
		//given
		Long memberId = 1L;
		Seller seller = getCreateSellerRequest().toSeller(memberId);
		BDDMockito.given(sellerRepository.findById(Mockito.anyLong())).willReturn(seller);

		//when
		SellerResponse sellerResponse = sellerService.getSellerById(memberId);

		//then
		Mockito.verify(sellerRepository, Mockito.times(1))
			.findById(Mockito.anyLong());

		Assertions.assertThat(sellerResponse.getBizNo()).isEqualTo(seller.getBizNo());
	}

	private CreateSellerRequest getCreateSellerRequest() {
		String brandName = "test brand name";
		String bizNo = "test bizNo";

		CreateSellerRequest createSellerRequest = new CreateSellerRequest(
			brandName, bizNo
		);

		return createSellerRequest;
	}

}