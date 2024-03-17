package org.store.clothstar.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.member.domain.Member;

@Mapper
public interface MemberRepository {
	public int save(Member member);

	public List<Member> list();

	public Member findById(Long id);

	public Member findByEmail(String email);
}