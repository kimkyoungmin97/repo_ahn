package com.a5a5lab.module.order;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
	
	//주문 목록 리스트 뿌리기
	public List <OrderDto> selectList(OrderVo vo);
	
	//창고 목록 리스트 뿌리기
	public List <OrderDto> storageList(OrderVo vo);
	
	
	//페이지네이션
	public int selectOneCount(OrderVo vo);
}
