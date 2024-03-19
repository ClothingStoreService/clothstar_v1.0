package org.store.clothstar.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.clothstar.member.dto.AddressResponse;
import org.store.clothstar.member.dto.CreateAddressRequest;
import org.store.clothstar.member.service.AddressService;

@RestController
public class AddressController {
	private final AddressService addressService;

	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@GetMapping("/v1/members/{id}/address")
	public List<AddressResponse> getAllMemberAddress(@PathVariable Long id) {
		return addressService.getAllMemberAddress(id);
	}

	@PostMapping("/v1/members/{id}/address")
	public AddressResponse addrSave(CreateAddressRequest createAddressRequest, @PathVariable Long id) {
		return addressService.addrSave(createAddressRequest, id);
	}
}