package org.store.clothstar.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.store.clothstar.member.domain.Address;
import org.store.clothstar.member.dto.AddressResponse;
import org.store.clothstar.member.dto.CreateAddressRequest;
import org.store.clothstar.member.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {
	private final AddressRepository addressInfoRepository;

	public List<AddressResponse> getAllMemberAddress(Long memberId) {
		List<Address> memberAddressList = addressInfoRepository.findMemberAddress(memberId);

		List<AddressResponse> memberAddressResponseList = memberAddressList.stream()
			.map(AddressResponse::new)
			.collect(Collectors.toList());

		return memberAddressResponseList;
	}

	public AddressResponse addrSave(Long memberId, CreateAddressRequest createAddressRequest) {
		Address address = createAddressRequest.toAddress(memberId);
		addressInfoRepository.save(address);

		return new AddressResponse(address);
	}
}