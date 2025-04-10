package com.a5a5lab.module.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	// 상품목록조회 리스트 보여주기
	@RequestMapping(value = "/productXdmList")
	public String productXdmList(Model model,ProductVo vo) {
		
		vo.setParamsPaging(productService.selectOneCount(vo));
		model.addAttribute("list", productService.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "/xdm/product/productXdmList";
	}
	
}
