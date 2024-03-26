package org.store.clothstar.member.domain;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member implements UserDetails {
	private Long memberId;
	private String email;
	private String password;
	private String name;
	private String telNo;
	private int totalPaymentPrice;
	private int point;
	private MemberRole role;
	private MemberGrade grade;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private LocalDateTime deletedAt;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(String.valueOf(role)));
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		//true -> 계정 만료되지 않았음
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		//true -> 계정 잠금되지 않음
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//true -> 패스워드 만료 되지 않음
		return true;
	}

	@Override
	public boolean isEnabled() {
		//ture -> 계정 사용 가능
		return true;
	}
}
