package com.a5a5lab.module.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a5a5lab.common.util.UtilDateTiem;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	// 주문내역 목록 리스트 보여주기
	@RequestMapping(value ="/OrderXdmList")
	public String OrderXdmList(Model model,OrderVo vo) {
		// 날짜 보정
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTiem.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTiem.add59TimeString(vo.getShDateEnd()));
		
		if (vo.getShDelNy() == null) {
		    vo.setShDelNy(0);
		}
		
		//페이지 네이션
		vo.setParamsPaging(orderService.selectOneCount(vo));
		model.addAttribute("list", orderService.selectList(vo));
		model.addAttribute("vo", vo);
		return "xdm/orderlist/OrderXdmList";
	}
	// 주문 목록 리스트 업데이트 삭제
	@PostMapping("/OrderXdmUele")
	@ResponseBody
	public String OrderXdmUele(OrderDto dto) {
	    List<Long> deleteIds = dto.getDeleteIds();
	    orderService.uelete(deleteIds);
	    return "success";
	}
	
	
	
	// 주문내역 상세 보여주기 (임시)
	@RequestMapping(value ="/OrderXdmView")
	public String OrderXdmView(Model model,OrderDto orderDto, OrderVo vo) {
		//주문번호로 주문내용가져오기
		model.addAttribute("item", orderService.selectOne(orderDto));
		//주문번호에 맞는 상품상세목록 가져오기
		List<OrderDto> list = orderService.orderDetailList(orderDto);
		vo.setParamsPaging(orderService.selectOneOrderDetailCount(vo));
	    model.addAttribute("list", list);
		model.addAttribute("vo", vo);
	    //상품상세목록 총 합계금액 구하기
	    int totalSumPrice = list.stream()
	        .mapToInt(OrderDto::getSumPrice)
	        .sum();
	    model.addAttribute("totalSumPrice", totalSumPrice); 
	    System.out.println(vo.getTotalRows());
		
		return "xdm/orderlist/OrderXdmView";
	}
	
	
	
	
	
	//창고재고 조회
	@RequestMapping(value ="/StorageXdmList")
	public String StorageXdmList(Model model,OrderVo vo, OrderDto orderDto) {
		
		
		vo.setParamsPaging(orderService.selectOneProductCount(vo));
		model.addAttribute("list", orderService.storageList(vo));
		model.addAttribute("vo", vo);
		System.out.println("전체데이터갯수: "+vo.getTotalRows());
		System.out.println("화면에보여줄데이터갯수: "+vo.getRowNumToShow());
		System.out.println("전체 페이지 번호: "+vo.getTotalPages());
			
		return "xdm/storage/StorageXdmList";
	}
	
	
	//발주내역 상세List 페이지
	@RequestMapping(value = "/FactoryOrderXdmList")
	public String FactoryOrderXdmList(Model model,OrderVo vo) {
		
		
		
		vo.setParamsPaging(orderService.selectOneOrderingCount(vo));
		model.addAttribute("list", orderService.FactoryOrderList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/factoryorder/FactoryOrderXdmList";
	}
	
	
	@RequestMapping(value = "/ReceivingXdmList")
	public String ReceivingXdmList(Model model) {
		
		return "xdm/receiving/ReceivingXdmList";
	}
	
	//주문등록 페이지
	@RequestMapping(value="/OrderXdmForm")
	public String OrderXdmForm() {
		return "xdm/orderlist/OrderXdmForm";
	}
	
		
	
	
	
}
