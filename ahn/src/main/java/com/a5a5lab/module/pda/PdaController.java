package com.a5a5lab.module.pda;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PdaController {
	
	// 입고하기
	@RequestMapping(value="/LnboundPad")
	public String LnboundPad() {
		return"pda/LnboundPad";
	}
	
	//출고하기
	@RequestMapping(value="/DeliveryPda")
	public String  DeliveryPda() {
		return "/pda/DeliveryPda";
	}
	

}
