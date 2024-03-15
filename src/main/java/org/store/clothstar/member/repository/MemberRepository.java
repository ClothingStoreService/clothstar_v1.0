package org.store.clothstar.member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.member.dto.MemberDTO;

@Mapper
public interface MemberRepository {
	public int save(MemberDTO memberDTO);

	public MemberDTO findById(Long id);

	public MemberDTO findByEmail(String email);
}
