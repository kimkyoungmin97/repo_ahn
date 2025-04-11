package com.a5a5lab.module.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	//주문등록 페이지에서 선택된 신발 사이즈가져오기 
	@ResponseBody
	@RequestMapping(value = "/selectOneShoesProc")
	public Map<String, Object> selectOneMemberProc(Model model,ProductDto productDto,ProductVo vo) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		 List<ProductDto> sizeList = productService.selectList(vo);
		    returnMap.put("sizeList", sizeList);
		
		return returnMap;
	}
	
	
}
