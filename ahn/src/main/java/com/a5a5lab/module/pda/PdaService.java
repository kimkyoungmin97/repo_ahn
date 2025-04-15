package com.a5a5lab.module.pda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a5a5lab.module.code.CodeDto;
import com.a5a5lab.module.order.OrderVo;

@Service
public class PdaService {
	
	
	@Autowired
	PdaDao pdaDao;
	
	
	
	
	
	// 발주 목록ㄹ스트 뿌리기
	public List<PdaDto> FactoryOrderList(PdaVo vo){
		return pdaDao.FactoryOrderList(vo);
	}
	

	// 배송 목록리스트 
	public List<PdaDto> FactoryOrderListDl(PdaVo vo){
		return pdaDao.FactoryOrderListDl(vo);
	}

	
	//트랜잭션으로 발주내용 입고대기->입고완료 , 상품재고증가 함께 처리
	@Transactional
	public void stockCompleted(PdaDto pdaDto) {
		pdaDao.update(pdaDto); //Pda 입고 (발주내역)을 입고대기에서 입고 완료로 업데이트 하기
		pdaDao.updateStoreCount(pdaDto); // 상품재고 증가
		

	}
	@Transactional
	public void deliveryCompleted(PdaDto pdaDto) {
		pdaDao.updateDl(pdaDto); //Pda 입고 (발주내역)을 출고요청에서 출고완료로 업데이트 하기
		pdaDao.updateStoreCount(pdaDto); // 상품재고 증가
		

	}
	
	
	//Pda 입고 발주 내역 데이터 1개씩 뽑기
	public PdaDto selectOne(PdaDto pdaDto) {
		return pdaDao.selectOne(pdaDto);
	}
	
	//Pda 배송 내역 데이트 1개씩 뽑기
	public PdaDto selesctOne1(PdaDto pdaDto) {
		return pdaDao.selectOne1(pdaDto);
	}


	// 주문 배송 목록 리스트 뿌리기
	public List<PdaDto> selectList(){
		return pdaDao.selectList();
	}
	
	














}
