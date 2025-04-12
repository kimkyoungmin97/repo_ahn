package com.a5a5lab.module.pda;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a5a5lab.module.code.CodeService;

@Controller
public class PdaController {
	
	@Autowired
	PdaService pdaService;
	
	
	
	//Pad 입고목록
	@RequestMapping(value="/LnboundPad")
	public String LnboundPad(Model model) {
		
		model.addAttribute("list", pdaService.FactoryOrderList());
		
		
		
		return"pda/LnboundPad";
	}
	
	//Pad 입고하기 상세
	@RequestMapping("/LnboundPadDetailsPad")
	public String LnboundPadDetailsPad() {
//	    if (orderSeqStr != null && orderSeqStr.matches("\\d+")) {
//	        Integer orderSeq = Integer.valueOf(orderSeqStr);
//	        PdaDto order = pdaService.selectOne(orderSeq);
//	        if (order != null) {
//	            model.addAttribute("list", order);
//	            model.addAttribute("orderSeq", orderSeq);
//	        } else {
//	            model.addAttribute("errorMessage", "조회 결과가 없습니다.");
//	        }
//	    } else {
//	        model.addAttribute("errorMessage", "유효한 발주번호가 아닙니다.");
//	    }
	    return "pda/LnboundPadDetailsPad";
	}



	// Pda 입고하기 출고대기에서 출고 요청으로 변경 업데이트
	@RequestMapping(value="/LnboundPadUdate")
	public String LnboundPadUdate(@RequestParam(value="orderSeq", required=false) Integer orderSeq) {
	    if (orderSeq != null) {
	      
	    }
	    pdaService.update(orderSeq);
	    return "redirect:/pda/LnboundPadList";
	}


	@ResponseBody
	@RequestMapping("/api/getInboundOrder")
	public Map<String, Object> getInboundOrder(PdaDto pdaDto) throws Exception {
	    Map<String, Object> resultMap = new HashMap<>();
	    
	   PdaDto order = pdaService.selectOne(pdaDto);
	   
	   resultMap.put("orderSeq", order.getOrderSeq());
	   resultMap.put("shName", order.getShName());
	   resultMap.put("shSizeCd", CodeService.selectOneCachedCode(order.getShSizeCd()));
	   resultMap.put("shOrderCount", order.getShOrderCount());
	   resultMap.put("orderStatusCd", CodeService.selectOneCachedCode(order.getOrderStatusCd()));
	    
	    

	    return resultMap;
	}
	
	
	
	
	//Pad 배송하기
	@RequestMapping(value="/DeliveryPda")
	public String  DeliveryPda(Model model) {
		
		model.addAttribute("list", pdaService.selectList());
		
		return "/pda/DeliveryPda";
	}
	

}
