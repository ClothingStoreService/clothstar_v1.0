package org.store.clothstar.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.clothstar.member.dto.CreateSellerRequest;
import org.store.clothstar.member.dto.SellerResponse;
import org.store.clothstar.member.service.SellerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SellerController {
	private final SellerService sellerService;

	@GetMapping("/v1/sellers/{id}")
	public SellerResponse getSeller(@PathVariable("id") Long memberId) {
		return sellerService.getSellerById(memberId);
	}

	@PostMapping("/v1/sellers/{id}")
	public SellerResponse saveSeller(@RequestBody CreateSellerRequest createSellerRequest,
		@PathVariable("id") Long memberId) {
		return sellerService.sellerSave(createSellerRequest, memberId);
	}
}