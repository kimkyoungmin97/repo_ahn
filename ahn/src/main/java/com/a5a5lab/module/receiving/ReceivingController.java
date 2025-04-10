package com.a5a5lab.module.receiving;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReceivingController {
	
	@RequestMapping(value = "/xdm/receiving/receivingXdmList")
	public String receivingXdmList() {
		
		return "/xdm/receiving/receivingXdmList";
	}
	
}
