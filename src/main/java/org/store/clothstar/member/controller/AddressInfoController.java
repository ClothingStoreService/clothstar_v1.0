package org.store.clothstar.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.clothstar.member.dto.AddressInfoResponse;
import org.store.clothstar.member.dto.CreateAddressInfoRequest;
import org.store.clothstar.member.service.AddressInfoService;

@RestController
public class AddressInfoController {
	private final AddressInfoService addressInfoService;

	public AddressInfoController(AddressInfoService addressInfoService) {
		this.addressInfoService = addressInfoService;
	}

	@GetMapping("/v1/members/{id}/address")
	public List<AddressInfoResponse> getAllMemberAddress(@PathVariable Long id) {
		return addressInfoService.getAllMemberAddress(id);
	}

	@PostMapping("/v1/members/{id}/address")
	public AddressInfoResponse addrSave(CreateAddressInfoRequest createAddressInfoRequest, @PathVariable Long id) {
		return addressInfoService.addrSave(createAddressInfoRequest, id);
	}
}