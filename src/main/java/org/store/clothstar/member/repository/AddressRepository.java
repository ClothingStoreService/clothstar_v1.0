package org.store.clothstar.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.member.domain.Address;

@Mapper
public interface AddressRepository {
	List<Address> findMemberAddress(Long memberId);

	int save(Address address);
}
