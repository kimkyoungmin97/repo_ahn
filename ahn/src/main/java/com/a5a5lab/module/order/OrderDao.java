package com.a5a5lab.module.order;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
	
	//주문 목록 리스트 뿌리기
	public List <OrderDto> selectList(OrderVo vo);
	
	//창고 목록 리스트 뿌리기
	public List <OrderDto> storageList(OrderVo vo);
	
	//발주 목록 리스트 뿌리기
	public List <OrderDto> FactoryOrderList(OrderVo vo);
	
	
	//페이지네이션
	public int selectOneCount(OrderVo vo);
	
	//주문 상세 페이지
	//한개의 주문
	public OrderDto selectOne(OrderDto orderDto);
	//주문에 따른 상품목록
	public List<OrderDto> orderDetailList(OrderDto orderDto);
	//주문금액 총 합계
	public OrderDto totalSumPrice(OrderDto orderDto);
		
	
}
