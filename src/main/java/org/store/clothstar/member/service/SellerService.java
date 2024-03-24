package org.store.clothstar.member.service;

import org.springframework.stereotype.Service;
import org.store.clothstar.member.domain.Seller;
import org.store.clothstar.member.dto.CreateSellerRequest;
import org.store.clothstar.member.dto.SellerResponse;
import org.store.clothstar.member.repository.SellerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SellerService {
	private final SellerRepository sellerRepository;

	public SellerResponse getSellerById(Long memberId) {
		Seller seller = sellerRepository.findById(memberId);

		return new SellerResponse(seller);
	}

	public SellerResponse sellerSave(Long memberId, CreateSellerRequest createSellerRequest) {
		Seller seller = createSellerRequest.toSeller(memberId);
		sellerRepository.save(seller);

		return new SellerResponse(seller);
	}
}
