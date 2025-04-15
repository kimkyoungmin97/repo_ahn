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
	public String LnboundPad(Model model,PdaVo vo) {
		
		
		
		model.addAttribute("list", pdaService.FactoryOrderList(vo));
		model.addAttribute("vo", vo);
		
		
		return"pda/LnboundPad";
	}
	
	@RequestMapping(value="/DeliveryPda")
	public String DeliveryPda(Model model,PdaVo vo) {
		
		
		model.addAttribute("list", pdaService.FactoryOrderListDl(vo));
		model.addAttribute("vo", vo);
		
		
		return"pda/DeliveryPda";
	}
	
	//Pad 입고하기 상세
	@RequestMapping("/LnboundPadDetailsPad")
	public String LnboundPadDetailsPad() {

	    return "pda/LnboundPadDetailsPad";
	}



	// Pda 입고하기 출고대기에서 출고 요청으로 변경 업데이트
	@RequestMapping(value="/LnboundPadUdate")
	public String LnboundPadUdate(PdaDto pdaDto) {
		pdaService.stockCompleted(pdaDto);
	  
	    return "redirect:/LnboundPad";
	}
	
	

	// 발주 
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
	// 발주 
	@ResponseBody
	@RequestMapping("/api/getInboundOrder1")
	public Map<String, Object> getInboundOrder1(PdaDto pdaDto) throws Exception {
	    Map<String, Object> resultMap = new HashMap<>();
	    
	   PdaDto order = pdaService.selesctOne1(pdaDto);
	   
	   resultMap.put("orderSeq", order.getOrderSeq());
	   resultMap.put("shName", order.getShName());
	   resultMap.put("shSizeCd", CodeService.selectOneCachedCode(order.getShSizeCd()));
	   resultMap.put("shOrderCount", order.getShOrderCount());
	   resultMap.put("deliveryStatus", CodeService.selectOneCachedCode(order.getDeliveryStatus()));
	    
	    

	    return resultMap;
	}
	
	//Pda 배송하기 상세
	@RequestMapping(value="/DeliveryDetailsPda")
	public String DeliveryDetailsPda() {
		
		
		return "/pda/DeliveryDetailsPda";
	}
	//Pda 배송하기 업데이트
	@RequestMapping(value="/DeliveryPadUdate")
	public String DeliveryPadUdate(PdaDto pdaDto) {
		pdaService.updateDl(pdaDto);
		return "redirect:/DeliveryDetailsPda";
	}
	
	
//	//Pad 배송하기
//	@RequestMapping(value="/DeliveryPda")
//	public String  DeliveryPda(Model model) {
//		
//		model.addAttribute("list", pdaService.selectList());
//		
//		return "/pda/DeliveryPda";
//	}
	

}
