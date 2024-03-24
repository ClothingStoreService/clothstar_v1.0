package org.store.clothstar.member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.member.domain.Seller;

@Mapper
public interface SellerRepository {
	public int save(Seller seller);

	public Seller findById(Long memberId);
}
