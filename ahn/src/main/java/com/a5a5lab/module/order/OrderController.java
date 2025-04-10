package com.a5a5lab.module.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	// 주문내역 목록 리스트 보여주기
	@RequestMapping(value ="/OrderXdmList")
	public String OrderXdmList(Model model,OrderVo vo) {
		
		vo.setParamsPaging(orderService.selectOneCount(vo));
		model.addAttribute("list", orderService.selectList(vo));
		model.addAttribute("vo", vo);
		return "xdm/orderlist/OrderXdmList";
	}
	// 주문내역 상세 보여주기 (임시)
	@RequestMapping(value ="/OrderXdmView")
	public String OrderXdmView(Model model,OrderDto orderDto) {
		//주문번호로 주문내용가져오기
		model.addAttribute("item", orderService.selectOne(orderDto));
		
		//주문번호에 맞는 상품상세목록 가져오기
		List<OrderDto> list = orderService.orderDetailList(orderDto);
	    model.addAttribute("list", list);
	    
	    //상품상세목록 총 합계금액 구하기
	    int totalSumPrice = list.stream()
	        .mapToInt(OrderDto::getSumPrice)
	        .sum();
	    model.addAttribute("totalSumPrice", totalSumPrice); 
		
		return "xdm/orderlist/OrderXdmView";
	}
	
	
	
	
	
	//창고재고 조회
	@RequestMapping(value ="/StorageXdmList")
<<<<<<< HEAD
	public String StorageXdmList(Model model,OrderVo vo) {
		vo.setParamsPaging(orderService.selectOneCount(vo));
=======
	public String StorageXdmList(Model model,OrderVo vo, OrderDto orderDto) {
		
		
		vo.setParamsPaging(orderService.selectOneCount(vo));
		model.addAttribute("list", orderService.storageList(vo));
>>>>>>> branch 'main' of https://github.com/kimkyoungmin97/repo_ahn.git
		model.addAttribute("vo", vo);
			
		return "xdm/storage/StorageXdmList";
	}
	
	
	
	
}
