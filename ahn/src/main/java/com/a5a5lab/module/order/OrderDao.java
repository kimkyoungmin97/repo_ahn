package com.a5a5lab.module.order;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
	
	//주문 목록 리스트 뿌리기
	public List <OrderDto> selectList(OrderVo vo);
	
	//창고 목록 리스트 뿌리기
	public List <OrderDto> storageList(OrderVo vo);
	
	//발주 목록 리스트 뿌리기
	public List <OrderDto> FactoryOrderList(OrderVo vo);
	
	public int insert(OrderDto orderDto);
	
	
	//페이지네이션
	public int selectOneCount(OrderVo vo);
	public int selectOneProductCount(OrderVo vo);
	public int selectOneOrderingCount(OrderVo vo);
	public int selectOneOrderDetailCount(OrderVo vo);
	
	//주문 상세 페이지
	//한개의 주문
	public OrderDto selectOne(OrderDto orderDto);
	//주문에 따른 상품목록
	public List<OrderDto> orderDetailList(OrderDto orderDto);
	//주문금액 총 합계
	public OrderDto totalSumPrice(OrderDto orderDto);
	//배송요청 누를시 처리상태 출고요청으로 변환
	public int deliveryRequest(OrderDto orderDto);
		
	
	// 주문내역 목록 업데이트 삭제
	public int uelete(List<Long> deleteIds);
	
	public int ueleteFt(List<Long> deleteIdsf);
	
	
	
// 주문등록폼
	//멤버 불러오기
	public List<OrderDto> selectMemberList(OrderDto orderDto);
	//신발 불러오기(중복없이)
	public List<OrderDto> selectShoesList(OrderDto orderDto);
	//주문테이블생성
	public int orderInst(OrderDto orderDto);
	//주문테이블에 맞는 주문상세목록생성
	public int orderDetailInst(OrderDto orderDto);
	
}
