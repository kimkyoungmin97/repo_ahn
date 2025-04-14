package com.a5a5lab.module.member;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	
	
	// 관리자 로그인 비교
	public MemberDto selectId(MemberDto memberDto);
	
	//주문자 멤버 정보 가져오기
	public MemberDto selectOne(MemberDto memberDto);
	

	
	
	
}
