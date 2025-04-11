package com.a5a5lab.module.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a5a5lab.common.util.UtilDateTiem;

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
		
		// UtilDateTime 함수 가져와서 사용
		
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTiem.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTiem.add59TimeString(vo.getShDateEnd()));
		
		return "/xdm/product/productXdmList";
	}
	
	// 등록폼
	@RequestMapping(value="/productXdmForm")
	public String productXdmForm(ProductDto Productdto,Model model) {
		return"/xdm/product/productXdmForm";
	}
	
	
}
