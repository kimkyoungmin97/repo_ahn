package com.a5a5lab.module.pda;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PdaController {
	
	@RequestMapping(value="/ReceivingPda")
	public String ReceivingPda() {
		return"pda/ReceivingPda";
	}

}
