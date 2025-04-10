package com.a5a5lab.module.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	//주문목록 리스트 뿌리기
	public List<OrderDto> selectList(OrderVo vo){
		return orderDao.selectList(vo);
	}
	
	// 발주 목록ㄹ스트 뿌리기
	public List<OrderDto> FactoryOrderList(OrderVo vo){
		return orderDao.FactoryOrderList(vo);
	}
	
	
	//페이진이션
	public int selectOneCount(OrderVo vo) {
		return orderDao.selectOneCount(vo);
	}
	//주문 상세페이지
	//한개의 주문
	public OrderDto selectOne(OrderDto orderDto) {
		return orderDao.selectOne(orderDto);
	}
	//주문에 따른 상품목록
	public List<OrderDto> orderDetailList(OrderDto orderDto){
		return orderDao.orderDetailList(orderDto);
	}
	////주문금액 총 합계
	public OrderDto totalSumPrice(OrderDto orderDto) {
		return orderDao.totalSumPrice(orderDto);
	}
	
	//창고목록 리스트 뿌리기
	public List <OrderDto> storageList(OrderVo vo){
		return orderDao.storageList(vo);
	}
	
	

}
