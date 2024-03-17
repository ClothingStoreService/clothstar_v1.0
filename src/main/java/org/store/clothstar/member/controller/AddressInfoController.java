package org.store.clothstar.member.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.clothstar.member.domain.AddressInfo;
import org.store.clothstar.member.dto.CreateAddressInfoRequest;
import org.store.clothstar.member.service.AddressInfoService;

@RestController
public class AddressInfoController {
	private final AddressInfoService addressInfoService;

	public AddressInfoController(AddressInfoService addressInfoService) {
		this.addressInfoService = addressInfoService;
	}

	@PostMapping("/v1/members/{id}/address")
	public AddressInfo addrSave(CreateAddressInfoRequest createAddressInfoRequest, @PathVariable String id) {
		return addressInfoService.addrSave(createAddressInfoRequest, id);
	}
}
