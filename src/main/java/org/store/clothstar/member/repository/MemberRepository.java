package org.store.clothstar.member.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.member.domain.Member;

@Mapper
public interface MemberRepository {
	int save(Member member);

	List<Member> findAll();

	Member findById(Long memberId);

	Optional<Member> findByEmail(String email);
}