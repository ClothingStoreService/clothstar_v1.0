package org.store.clothstar.member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.member.dto.MemberDTO;

@Mapper
public interface MemberRepository {
	public int save(String email, String password);

	public MemberDTO findById(Long id);
}
