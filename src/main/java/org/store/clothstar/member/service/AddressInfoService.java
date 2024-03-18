package org.store.clothstar.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.store.clothstar.member.domain.AddressInfo;
import org.store.clothstar.member.dto.AddressInfoResponse;
import org.store.clothstar.member.dto.CreateAddressInfoRequest;
import org.store.clothstar.member.repository.AddressInfoRepository;

@Service
public class AddressInfoService {
	private final AddressInfoRepository addressInfoRepository;

	public AddressInfoService(AddressInfoRepository addressInfoRepository) {
		this.addressInfoRepository = addressInfoRepository;
	}

	public List<AddressInfoResponse> getAllMemberAddress(Long memberId) {
		List<AddressInfo> memberAddressList = addressInfoRepository.findAllMemberAddress(memberId);

		List<AddressInfoResponse> memberAddressResponseList = memberAddressList.stream()
			.map(AddressInfoResponse::new)
			.collect(Collectors.toList());

		return memberAddressResponseList;
	}

	public AddressInfoResponse addrSave(CreateAddressInfoRequest createAddressInfoRequest, Long memberId) {
		createAddressInfoRequest.setMemberId(memberId);

		AddressInfo addressInfo = createAddressInfoRequest.toAddressInfo();
		addressInfoRepository.save(addressInfo);
		return new AddressInfoResponse(addressInfo);
	}
}
