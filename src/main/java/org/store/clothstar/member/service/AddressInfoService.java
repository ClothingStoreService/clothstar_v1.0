package org.store.clothstar.member.service;

import org.springframework.stereotype.Service;
import org.store.clothstar.member.domain.AddressInfo;
import org.store.clothstar.member.dto.CreateAddressInfoRequest;
import org.store.clothstar.member.repository.AddressInfoRepository;

@Service
public class AddressInfoService {
	private final AddressInfoRepository addressInfoRepository;

	public AddressInfoService(AddressInfoRepository addressInfoRepository) {
		this.addressInfoRepository = addressInfoRepository;
	}

	public AddressInfo addrSave(CreateAddressInfoRequest createAddressInfoRequest, String memberId) {
		createAddressInfoRequest.setMemberId(memberId);

		AddressInfo addressInfo = createAddressInfoRequest.toAddressInfo();
		addressInfoRepository.save(addressInfo);

		return addressInfo;
	}
}
