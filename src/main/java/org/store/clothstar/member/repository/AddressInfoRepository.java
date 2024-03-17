package org.store.clothstar.member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.member.domain.AddressInfo;

@Mapper
public interface AddressInfoRepository {
	public int save(AddressInfo addressInfo);
}
