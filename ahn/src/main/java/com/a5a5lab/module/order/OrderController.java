package com.a5a5lab.module.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a5a5lab.common.util.UtilDateTiem;
import com.a5a5lab.module.member.MemberDto;

import jakarta.servlet.http.HttpSession;

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
	
	@PostMapping("/OrderXdmUeleFt")
	@ResponseBody
	public String OrderXdmUeleFt(OrderDto dto) {
	    List<Long> deleteIdsf = dto.getDeleteIdsf();
	    orderService.ueleteFt(deleteIdsf);
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
		
		return "xdm/orderlist/OrderXdmView";
	}
	//주문내역상세페이지에서 배송요청 누를시 처리상태 출고요청으로 변경
	@RequestMapping(value="/deliveryRequest")
	public String deliveryRequest(OrderDto orderDto) {
		orderService.deliveryRequest(orderDto);
		return "redirect:/OrderXdmList";
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
		
		
		
		
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTiem.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTiem.add59TimeString(vo.getShDateEnd()));
		
		if (vo.getShDelNy() == null) {
		    vo.setShDelNy(0);
		}
		vo.setParamsPaging(orderService.selectOneOrderingCount(vo));
		model.addAttribute("list", orderService.FactoryOrderList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/factoryorder/FactoryOrderXdmList";
	}
	
	//발주내역 form 페이지
	@RequestMapping(value = "/FactoryOrderXdmform")
	public String FactoryOrderXdmform(Model model, OrderVo vo, OrderDto orderDto) {
		
	
		model.addAttribute("list", orderService.selectMemberList(orderDto));
		model.addAttribute("shoes", orderService.selectShoesList(orderDto));
		model.addAttribute("vo", vo);
		
		
		return "/xdm/factoryorder/FactoryOrderXdmform";
	}
	
	@RequestMapping(value = "/ReceivingXdmList")
	public String ReceivingXdmList(Model model,OrderVo vo) {
		// 날짜 보정
				vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTiem.add00TimeString(vo.getShDateStart()));
				vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTiem.add59TimeString(vo.getShDateEnd()));
				
				if (vo.getShDelNy() == null) {
				    vo.setShDelNy(0);
				}
				
				//페이지 네이션
				vo.setParamsPaging(orderService.deliveryselectOneCount(vo));
				model.addAttribute("list", orderService.deliveryList(vo));
				model.addAttribute("vo", vo);
		
		return "xdm/receiving/ReceivingXdmList";
	}
	
	//주문등록 페이지
	@RequestMapping(value="/OrderXdmForm")
	public String OrderXdmForm(Model model, OrderDto orderDto) {
		model.addAttribute("list", orderService.selectMemberList(orderDto));
		model.addAttribute("shoes", orderService.selectShoesList(orderDto));
		return "xdm/orderlist/OrderXdmForm";
	}
	//주문등록 페이지(주문등록)
	@RequestMapping(value="/OrderXdmInst")
	public String OrderXdmInst(OrderDto orderDto) {
		orderService.orderRegister(orderDto);
		return"redirect:/OrderXdmList";
	}
	
	//발주등록 페이지(주문등록)
	@RequestMapping(value="/OrderXdmInst1")
	public String OrderXdmInst1(OrderDto orderDto) {
		orderService.orderRegister1(orderDto);
		return"redirect:/FactoryOrderXdmList";
	}
	
	@RequestMapping(value = "/xdm/index/index")
	public String index(Model model, OrderVo vo, OrderDto orderDto) {
		
		
		//회원수
		model.addAttribute("memberCount", orderService.memberCount(orderDto));
		//판매중인 상품
		model.addAttribute("orderCount", orderService.productCount(orderDto));
		//오늘 주문건
		model.addAttribute("todayCount", orderService.todayOrder(orderDto));
		//오늘매출
		model.addAttribute("todaySales", orderService.todaySales(orderDto));
		//배송전
		model.addAttribute("todayDelevery", orderService.todayDelevery(orderDto));
		//배송완료
		model.addAttribute("todayComplete", orderService.todayComplete(orderDto));
		
		
	    // 주문 관리 리스트 보여주기
	    model.addAttribute("orderTable", orderService.selectList(vo));
	    
	    // 배송 관리 리스트 보여주기
	    model.addAttribute("factoryTable", orderService.FactoryOrderList(vo));
	    
	    // 인덱스 리스트
	    model.addAttribute("indexlist", orderService.indexList(vo));

	    model.addAttribute("vo", vo);
	    
	    return "xdm/index/index";
	}
	
	
	
	
	
	
	
	
	
	
	
}
	    
	  
	    
		
		
		    
		
