package com.a5a5lab.module.pda;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.a5a5lab.module.code.CodeDto;
@Repository
public interface PdaDao {
	
	
	
	//Pda 입고(발주 내역) 관리 리스트 뿌리기
	public List <PdaDto> FactoryOrderList(PdaVo vo);
	

	//Pda 배송(배송 내역) 관리 리스트 뿌리기
	public List <PdaDto> FactoryOrderListDl(PdaVo vo);
	
	//Pda 입고 (발주내역)을 출고대기에서 출고 완료로 업데이트 하기

	//Pda 입고 (발주내역)을 입고대기에서 입고 완료로 업데이트 하기
	public int update(PdaDto pdaDto);
	//pda 입고완료시 발주내용에 따른 신발재고증가 또는감소 (orderTypeCd에따라)
	public int updateStoreCount(PdaDto pdaDto);

	
	public int updateDl(PdaDto pdaDto);
	
	//pda 입고 발주내역 데이터값 1개씩 뽑아 보기
	public PdaDto selectOne(PdaDto pdaDto);
	
	//Pda 배송 관리 리스트 뿌리기
	public List <PdaDto> selectList();
	
}
