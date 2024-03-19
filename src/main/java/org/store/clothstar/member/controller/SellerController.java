package org.store.clothstar.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.clothstar.member.dto.CreateSellerRequest;
import org.store.clothstar.member.dto.SellerResponse;
import org.store.clothstar.member.service.SellerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SellerController {
	private final SellerService sellerService;

	@GetMapping("/v1/sellers/{id}")
	public SellerResponse getSeller(@PathVariable Long id) {
		return sellerService.getSellerById(id);
	}

	@PostMapping("/v1/sellers")
	public SellerResponse saveSeller(CreateSellerRequest createSellerRequest) {
		return sellerService.save(createSellerRequest);
	}
}