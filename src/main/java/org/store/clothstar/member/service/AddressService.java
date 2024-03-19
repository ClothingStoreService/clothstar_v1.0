package org.store.clothstar.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.store.clothstar.member.domain.Address;
import org.store.clothstar.member.dto.AddressResponse;
import org.store.clothstar.member.dto.CreateAddressRequest;
import org.store.clothstar.member.repository.AddressRepository;

@Service
public class AddressService {
	private final AddressRepository addressInfoRepository;

	public AddressService(AddressRepository addressInfoRepository) {
		this.addressInfoRepository = addressInfoRepository;
	}

	public List<AddressResponse> getAllMemberAddress(Long memberId) {
		List<Address> memberAddressList = addressInfoRepository.findAllMemberAddress(memberId);

		List<AddressResponse> memberAddressResponseList = memberAddressList.stream()
			.map(AddressResponse::new)
			.collect(Collectors.toList());

		return memberAddressResponseList;
	}

	public AddressResponse addrSave(CreateAddressRequest createAddressRequest, Long memberId) {
		createAddressRequest.setMemberId(memberId);

		Address address = createAddressRequest.toAddress();
		addressInfoRepository.save(address);
		return new AddressResponse(address);
	}
}
