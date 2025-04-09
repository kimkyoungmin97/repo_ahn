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
}
