package com.a5a5lab.module.oder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a5a5lab.module.codegroup.CodeGroupDto;

@Controller
public class OderController {
	
	@Autowired
	OderService oderService;
	
	// 주문내역 목록 리스트 보여주기
	@RequestMapping(value ="/OrderXdmList")
	public String OrderXdmList() {
		
		
		return "xdm/orderlist/OrderXdmList";
	}
	
	
	
	
	// 주문내역 상세 보여주기 (임시)
	@RequestMapping(value ="/OrderXdmView")
	public String OrderXdmView() {
			
			
		return "xdm/orderlist/OrderXdmView";
	}
	
}
