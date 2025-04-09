package com.a5a5lab.module.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a5a5lab.module.codegroup.CodeGroupDto;

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
	public String OrderXdmView() {
			
			
		return "xdm/orderlist/OrderXdmView";
	}
	
	
	
	
	
	//창고재고 조회
	@RequestMapping(value ="/StorageXdmList")
	public String StorageXdmList(Model model,OrderVo vo, OrderDto orderDto) {
		
		
		vo.setParamsPaging(orderService.selectOneCount(vo));
		model.addAttribute("list", orderService.storageList(vo));
		model.addAttribute("vo", vo);
			
		return "xdm/storage/StorageXdmList";
	}
	
	
	
	
}
