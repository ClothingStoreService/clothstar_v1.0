package org.store.clothstar.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.member.domain.AddressInfo;

@Mapper
public interface AddressInfoRepository {
	List<AddressInfo> findAllMemberAddress(Long memberId);

	public int save(AddressInfo addressInfo);
}
