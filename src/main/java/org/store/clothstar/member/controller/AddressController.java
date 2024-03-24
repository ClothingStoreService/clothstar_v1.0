package org.store.clothstar.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.clothstar.member.dto.AddressResponse;
import org.store.clothstar.member.dto.CreateAddressRequest;
import org.store.clothstar.member.service.AddressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "배송지 주소 관련 Controller")
@RestController
@RequiredArgsConstructor
public class AddressController {
	private final AddressService addressService;

	@Operation(description = "회원 한명에 대한 배송지를 전부 가져오는 api")
	@GetMapping("/v1/members/{id}/address")
	public List<AddressResponse> getAllMemberAddress(@PathVariable("id") Long memberId) {
		return addressService.getAllMemberAddress(memberId);
	}

	@Operation(description = "회원 한명에 대한 배송지를 전부 가져오는 api")
	@PostMapping("/v1/members/{id}/address")
	public AddressResponse addrSave(
		@PathVariable("id") Long memberId,
		@RequestBody CreateAddressRequest createAddressRequest) {

		return addressService.addrSave(memberId, createAddressRequest);
	}
}