package org.store.clothstar.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.member.domain.Address;

@Mapper
public interface AddressRepository {
	List<Address> findAllMemberAddress(Long memberId);

	public int save(Address address);
}
