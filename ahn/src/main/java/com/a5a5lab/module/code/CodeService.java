package com.a5a5lab.module.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CodeService {
	
	@Autowired
	CodeDao codeDao;
	
	// 데이터 1개씩 뽑기
	public CodeDto selectOne(CodeVo vo) {
		return codeDao.selectOne(vo);
	}
	
	//리스트 보여주기
	public List<CodeDto> selectList(CodeVo vo){	
		return codeDao.selectList(vo);
	}
	
	// 등록폼
	public int insert(CodeDto codeDto) {
		return codeDao.insert(codeDto);
	}
	
	//업데이트 삭제
	public int uelete(CodeDto codeDto) {
		return codeDao.uelete(codeDto);
	}
	
	// 페이지 네이션
	public int selectOneCount(CodeVo vo) {
		return codeDao.selectOneCount(vo);
	}
	
	// 업데이트
	public int update(CodeDto codeDto) {
		return codeDao.update(codeDto);
	}
	
	
	//코드 그룹 에있는 이름 Seq 리스트 뿌리기
	public List<CodeDto> codeGroupNameSeq(CodeDto codeDto){
		return codeDao.codeGroupNameSeq(codeDto);
	}
	
	
    @PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) codeDao.selectListCachedCodeArrayList();
		CodeDto.cachedCodeArrayList.clear(); 
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
	}
    
    
	public static void clear() throws Exception {
		CodeDto.cachedCodeArrayList.clear();
	}
	
	
	public static List<CodeDto> selectListCachedCode(String ifcgSeq) throws Exception {
		List<CodeDto> rt = new ArrayList<CodeDto>();
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCodeGroup_cdgSeq().equals(ifcgSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}

	
	public static String selectOneCachedCode(int code) throws Exception {
		String rt = "";
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCdSeq().equals(Integer.toString(code))) {
				rt = codeRow.getIfcdName();
			} else {
				// by pass
			}
		}
		return rt;
	}
	
	
	
	
}
