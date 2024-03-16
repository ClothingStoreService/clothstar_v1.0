package org.store.clothstar.member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.member.domain.Member;

@Mapper
public interface MemberRepository {
	public int save(Member member);

	public Member findById(Long id);

	public Member findByEmail(String email);
}
