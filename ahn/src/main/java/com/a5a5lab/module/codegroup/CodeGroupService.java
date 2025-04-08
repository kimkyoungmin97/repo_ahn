package com.a5a5lab.module.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {
	
	@Autowired
	CodeGroupDao codeGroupDao;
	
	//리스트 보여주기
	public List<CodeGroupDto> selectList(CodeGroupVo vo){
		return codeGroupDao.selectList(vo);
	}
	
	//1개만 받아오니깐 
	public CodeGroupDto selectOne(CodeGroupVo vo){ //Dto 를 받겠다선언
		return codeGroupDao.selectOne(vo); //Dto함수를 사용하기 위해
	}
	
	// 등록폼
	public int insert(CodeGroupDto codeGroupDto) {
		return codeGroupDao.insert(codeGroupDto);
	}
	
	// 업데이트 삭제
	public int uelete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.uelete(codeGroupDto);
	}
	
	//업데이트
	public int update(CodeGroupDto codeGroupDto) {
		return codeGroupDao.update(codeGroupDto);
	}
	
	//페이지 네이션
	public int selectOneCount(CodeGroupVo vo) {
		return codeGroupDao.selectOneCount(vo);
	}
	
}
