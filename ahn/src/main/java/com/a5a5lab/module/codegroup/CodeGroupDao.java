package com.a5a5lab.module.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;



@Repository
public interface CodeGroupDao {
	
	// 전체 보여주기
	public List<CodeGroupDto> selectList(CodeGroupVo vo);
	
	//데이터 1개만 가져오기
	
	public CodeGroupDto selectOne(CodeGroupVo vo);// Dto 함수를 사용하겠다 선언
	
	// 등록 하기
	public int insert(CodeGroupDto codeGroupDto);
	
	//업데이트 삭제
	public int uelete(CodeGroupDto codeGroupDto);
	
	//업데이트
	public int update(CodeGroupDto codeGroupDto);
	
	public int selectOneCount(CodeGroupVo vo);
	
	public int ueleteCk(List<Long> deleteIds);
	
}
