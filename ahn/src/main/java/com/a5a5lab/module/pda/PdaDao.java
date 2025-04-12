package com.a5a5lab.module.pda;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface PdaDao {
	
	
	
	//Pda 입고(발주 내역) 관리 리스트 뿌리기
	public List <PdaDto> FactoryOrderList(PdaVo vo);
	
	//Pda 입고 (발주내역)을 출고대기에서 출고 완료로 업데이트 하기
	public int update(Integer orderSeq);
	
	//pda 입고 발주내역 데이터값 1개씩 뽑아 보기
	public PdaDto selectOne(PdaDto pdaDto);
	
	//Pda 배송 관리 리스트 뿌리기
	public List <PdaDto> selectList();
	
}
