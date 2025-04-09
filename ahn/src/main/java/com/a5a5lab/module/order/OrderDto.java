package com.a5a5lab.module.order;

import java.sql.Date;


public class OrderDto {
	
	// order 테이블 컬럼
	private String orderSeq; //오더테이블 Seq
	private Integer deliveryStatus; // 배송상태
	private Integer paymentStatus; //결제 상태
	private Integer orderTypeCd; //오더타입 (배송, 창고, 공장)
	private Integer orderDelNy; //업데이트 삭제
	private Date regDateTime; //등록일(주문일, 입고일, 발주일)
	private Date modDateTime; //수정일
	private String momber_memSeq; //멤버 Seq 키
	
	// member 테이블 컬럼
	private String memSeq; //멤버 Seq
	private String memName; //멤버 이름
	private String memId; //아이디
	private String memPw; //비밀번호
	private String memAddress; //주소
	private String memDelNy; // 멤버업데이트 삭제
	// shoes 테이블 컬럼
	private String shSeq; //신발 Seq
	private String shName; //신발 이름
	private Integer shSizeCd; //사이즈 코드 (230~280)
	private Integer shBrandCd; //브랜드 코드 (나이키,아디다스,퓨마)
	private Integer shTypeCd; //신발 타입코드 (운동화 슬리퍼 등등)
	private Integer salesStatus; //판매상태 (판매중 , 판매중지)
	private Integer shCount; // 신발의 갯수
	private Integer shPrice; //신발 가격
//	-----
	// 코드 에있는  코드 이름  코드 Seq 땡겨오기
	private Integer  codeGroup_cdgSeq; // 코드 그룹 Seq
	private String cdSeq; //코드 Seq
	private String ifcdName;//코드 이름
//	-----
	// 주문 세부 사항
	private String orderDetailSeq; //주문 세부사항 Seq
	private Integer order_orderSeq; // 오더 Seq 키
	private String shoes_shSeq; //신발 Seq 키
	private Integer shOrderCount; // 신발 주문 갯수
//	----
	

	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}
	public String getOrderSeq() {
		return orderSeq;
	}
	public void setOrderSeq(String orderSeq) {
		this.orderSeq = orderSeq;
	}
	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Integer getOrderTypeCd() {
		return orderTypeCd;
	}
	public void setOrderTypeCd(Integer orderTypeCd) {
		this.orderTypeCd = orderTypeCd;
	}
	public Integer getShOrderCount() {
		return shOrderCount;
	}
	public void setShOrderCount(Integer shOrderCount) {
		this.shOrderCount = shOrderCount;
	}
	public Integer getOrderDelNy() {
		return orderDelNy;
	}
	public void setOrderDelNy(Integer orderDelNy) {
		this.orderDelNy = orderDelNy;
	}
	public Date getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(Date regDateTime) {
		this.regDateTime = regDateTime;
	}
	public Date getModDateTime() {
		return modDateTime;
	}
	public void setModDateTime(Date modDateTime) {
		this.modDateTime = modDateTime;
	}
	public String getMomber_memSeq() {
		return momber_memSeq;
	}
	public void setMomber_memSeq(String momber_memSeq) {
		this.momber_memSeq = momber_memSeq;
	}
	public String getShoes_shSeq() {
		return shoes_shSeq;
	}
	public void setShoes_shSeq(String shoes_shSeq) {
		this.shoes_shSeq = shoes_shSeq;
	}
	public String getMemSeq() {
		return memSeq;
	}
	public void setMemSeq(String memSeq) {
		this.memSeq = memSeq;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemAddress() {
		return memAddress;
	}
	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	public String getMemDelNy() {
		return memDelNy;
	}
	public void setMemDelNy(String memDelNy) {
		this.memDelNy = memDelNy;
	}
	public String getShSeq() {
		return shSeq;
	}
	public void setShSeq(String shSeq) {
		this.shSeq = shSeq;
	}
	public String getShName() {
		return shName;
	}
	public void setShName(String shName) {
		this.shName = shName;
	}
	public Integer getShSizeCd() {
		return shSizeCd;
	}
	public void setShSizeCd(Integer shSizeCd) {
		this.shSizeCd = shSizeCd;
	}
	public Integer getShBrandCd() {
		return shBrandCd;
	}
	public void setShBrandCd(Integer shBrandCd) {
		this.shBrandCd = shBrandCd;
	}
	public Integer getShTypeCd() {
		return shTypeCd;
	}
	public void setShTypeCd(Integer shTypeCd) {
		this.shTypeCd = shTypeCd;
	}
	public Integer getSalesStatus() {
		return salesStatus;
	}
	public void setSalesStatus(Integer salesStatus) {
		this.salesStatus = salesStatus;
	}
	public Integer getShCount() {
		return shCount;
	}
	public void setShCount(Integer shCount) {
		this.shCount = shCount;
	}
	public Integer getCodeGroup_cdgSeq() {
		return codeGroup_cdgSeq;
	}
	public void setCodeGroup_cdgSeq(Integer codeGroup_cdgSeq) {
		this.codeGroup_cdgSeq = codeGroup_cdgSeq;
	}
	public String getCdSeq() {
		return cdSeq;
	}
	public void setCdSeq(String cdSeq) {
		this.cdSeq = cdSeq;
	}
	public String getIfcdName() {
		return ifcdName;
	}
	public void setIfcdName(String ifcdName) {
		this.ifcdName = ifcdName;
	}
	public Integer getShPrice() {
		return shPrice;
	}
	public void setShPrice(Integer shPrice) {
		this.shPrice = shPrice;
	}
	public String getOrderDetailSeq() {
		return orderDetailSeq;
	}
	public void setOrderDetailSeq(String orderDetailSeq) {
		this.orderDetailSeq = orderDetailSeq;
	}
	public Integer getOrder_orderSeq() {
		return order_orderSeq;
	}
	public void setOrder_orderSeq(Integer order_orderSeq) {
		this.order_orderSeq = order_orderSeq;
	}
	
	
	
}
