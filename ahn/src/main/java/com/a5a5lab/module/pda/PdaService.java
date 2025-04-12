package com.a5a5lab.module.pda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a5a5lab.module.order.OrderVo;

@Service
public class PdaService {
	
	
	@Autowired
	PdaDao pdaDao;
	
	
	
	
	
	// 발주 목록ㄹ스트 뿌리기
	public List<PdaDto> FactoryOrderList(PdaVo vo){
		return pdaDao.FactoryOrderList(vo);
	}
	//Pda 입고 (발주내역)을 출고대기에서 출고 완료로 업데이트 하기
	public int update (Integer orderSeq) {
		return pdaDao.update(orderSeq);
	}
	
	//Pda 입고 발주 내역 데이터 1개씩 뽑기
	public PdaDto selectOne(PdaDto pdaDto) {
		return pdaDao.selectOne(pdaDto);
	}


	// 주문 배송 목록 리스트 뿌리기
	public List<PdaDto> selectList(){
		return pdaDao.selectList();
	}














}
