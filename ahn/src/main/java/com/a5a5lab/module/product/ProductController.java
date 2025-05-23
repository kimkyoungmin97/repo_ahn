package com.a5a5lab.module.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a5a5lab.common.util.UtilDateTiem;
import com.a5a5lab.module.code.CodeService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	// 상품목록조회 리스트 보여주기
	@RequestMapping(value = "/productXdmList")
	public String productXdmList(ProductVo vo, Model model) {
		
		
		// UtilDateTime 함수 가져와서 사용
		
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTiem.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTiem.add59TimeString(vo.getShDateEnd()));
		
		
		if (vo.getShDelNy() == null) {
		    vo.setShDelNy(0);
		}
		
		vo.setParamsPaging(productService.selectOneCount(vo));
		model.addAttribute("list", productService.selectList(vo));
		model.addAttribute("vo", vo);
		return "xdm/product/productXdmList";
	}
	
	// 등록폼
	@RequestMapping(value="/productXdmForm")
	public String productXdmForm(ProductDto Productdto,Model model) {
		return"/xdm/product/productXdmForm";
	}
	//주문등록 페이지에서 선택된 신발 사이즈가져오기 
	@ResponseBody
	@RequestMapping(value = "/selectOneShoesSizeProc")
	public Map<String, Object> selectOneShoesSizeProc(Model model,ProductDto productDto,ProductVo vo) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		//db에서 선택된 신발이 갖고있는 사이즈리스트가져오가
		 List<ProductDto> sizeList = productService.selectList(vo);
		 
		
		    returnMap.put("sizeList", sizeList);
		
		return returnMap;
	}
	//주문등록 페이지에서 신발이름,사이즈 둘다 선택되면 shSeq가져오기
	@ResponseBody
	@RequestMapping(value = "/selectOneShoesProc")
	public Map<String, Object> selectOneShoesProc(ProductDto productDto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		ProductDto shoes= productService.selectOne(productDto);
		
		returnMap.put("shSeq", shoes.getShSeq());
		
		
		
		return returnMap;
	}
	

	
	@RequestMapping("/productXdmUele")
	@ResponseBody
	public String productXdmUele(ProductDto Productdto) {
		List<Long> deleteIds = Productdto.getDeleteIds();
		productService.uelete(deleteIds);
		return "success";
	}
	
	
}
