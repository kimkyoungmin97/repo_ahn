package com.a5a5lab.module.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	//주문목록 리스트 뿌리기
	public List<OrderDto> selectList(OrderVo vo){
		return orderDao.selectList(vo);
	}
	//배송관리 리스트 뿌리기
	public List<OrderDto> deliveryList(OrderVo vo){
		return orderDao.deliveryList(vo);
	}
	
	// 발주 목록ㄹ스트 뿌리기
	public List<OrderDto> FactoryOrderList(OrderVo vo){
		return orderDao.FactoryOrderList(vo);
	}
	
	public int insert(OrderDto orderDto){
		return orderDao.insert(orderDto);
	}
	
	
	//페이진이션
	public int selectOneCount(OrderVo vo) {
		return orderDao.selectOneCount(vo);
	}
	public int selectOneProductCount(OrderVo vo) {
		return orderDao.selectOneProductCount(vo);
	}
	public int selectOneOrderingCount(OrderVo vo) {
		return orderDao.selectOneOrderingCount(vo);
	}
	public int selectOneOrderDetailCount(OrderVo vo) {
		return orderDao.selectOneOrderDetailCount(vo);
	}
	public int deliveryselectOneCount(OrderVo vo) {
		return orderDao.deliveryselectOneCount(vo);
	}
	//주문 상세페이지
	//한개의 주문
	public OrderDto selectOne(OrderDto orderDto) {
		return orderDao.selectOne(orderDto);
	}
	//주문에 따른 상품목록
	public List<OrderDto> orderDetailList(OrderDto orderDto){
		return orderDao.orderDetailList(orderDto);
	}
	////주문금액 총 합계
	public OrderDto totalSumPrice(OrderDto orderDto) {
		return orderDao.totalSumPrice(orderDto);
	}
	//주문상세페이지 배송요청누를시 처리상태 출고요청으로 바뀌기
	public int deliveryRequest(OrderDto orderDto) {
		return orderDao.deliveryRequest(orderDto);
	}
	
	//창고목록 리스트 뿌리기
	public List <OrderDto> storageList(OrderVo vo){
		return orderDao.storageList(vo);
	}
	
	//주문 목록 리스트 업데이트 삭제
	public int uelete (List<Long> deleteIds) {
		return orderDao.uelete(deleteIds);
	}
	
	public int ueleteFt (List<Long> deleteIdsf) {
		return orderDao.ueleteFt(deleteIdsf);
	}
//주문등록 폼
	//멤버 불러오기
	public List<OrderDto> selectMemberList(OrderDto orderDto){
		return orderDao.selectMemberList(orderDto);
	}
	//신발 불러오기(중복없이)
	public List<OrderDto> selectShoesList(OrderDto orderDto){
		return orderDao.selectShoesList(orderDto);
	}
	
	//트랜잭션으로 주문등록,주문 상세등록을 묶어줌
	 @Transactional
	 public void orderRegister(OrderDto orderDto) {
	        orderDao.orderInst(orderDto);          // 주문 등록
	        orderDao.orderDetailInst(orderDto);    // 주문 상세 등록
	    }
	 
	//트랜잭션으로 주문등록,주문 상세등록을 묶어줌
	 @Transactional
	 public void orderRegister1(OrderDto orderDto) {
	        orderDao.orderInst1(orderDto);          // 발주 등록
	        orderDao.orderDetailInst(orderDto);    // 주문 상세 등록    
	    }
//	//주문테이블생성
//	public int orderInst(OrderDto orderDto) {
//		return orderDao.orderInst(orderDto);
//	}
//	//주문테이블에 맞는 주문상세목록생성
//	public int orderDetailInst(OrderDto orderDto) {
//		return orderDao.orderDetailInst(orderDto);
//	}

	 
// 인덱스
	 //인덱스 리스트
	 public List<OrderDto> indexList(OrderVo vo){
			return orderDao.indexList(vo);
		}
	 // 회원수
	 public int memberCount(OrderDto orderDto) {
			return orderDao.memberCount(orderDto);
		}
	 //판매중인 상품
	 public int productCount(OrderDto orderDto) {
			return orderDao.productCount(orderDto);
		}
	 //오늘 주문건
	 public int todayOrder(OrderDto orderDto) {
			return orderDao.todayOrder(orderDto);
		}
	 //오늘 매출
	 public int todaySales(OrderDto orderDto) {
			return orderDao.todaySales(orderDto);
		}
	 //배송전
	 public int todayDelevery(OrderDto orderDto) {
			return orderDao.todayDelevery(orderDto);
		}
	 //배송완료
	 public int todayComplete(OrderDto orderDto) {
			return orderDao.todayComplete(orderDto);
		}
	
	
	

}
