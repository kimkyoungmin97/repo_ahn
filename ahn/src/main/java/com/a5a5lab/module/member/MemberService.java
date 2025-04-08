package com.a5a5lab.module.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	// 관리자 아이디 비교
	public MemberDto selectId(MemberDto memberDto) {
		return memberDao.selectId(memberDto);
	}
	
	
}
