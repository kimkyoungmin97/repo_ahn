package com.a5a5lab.module.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {
	
	// 리스트 보여주기
	public List<CodeDto> selectList(CodeVo vo);
	
	// 등록하기
	public int insert(CodeDto codeDto);
	
	
	//업데이트 삭제
	public int uelete(CodeDto codeDto);
	
	// 페이지 네이션
	public int selectOneCount(CodeVo vo);
	
	// 업데이트
	public int update(CodeDto codeDto);
	
	//데이터 하나씩 뽑기
	public CodeDto selectOne( CodeVo vo);
	
	//코드 그룹 에있는 이름 Seq 리스트 뿌리기
	public List<CodeDto> codeGroupNameSeq(CodeDto codeDto);
	
	
	
	public List<CodeDto> selectListCachedCodeArrayList();
	
}
