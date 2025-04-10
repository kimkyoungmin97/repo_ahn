package com.a5a5lab.module.product;

import java.sql.Date;

public class ProductDto {

	private String shSeq; //신발 Seq
	private String shName; //신발 이름
	private Integer shSizeCd; //사이즈 코드 (230~280)
	private Integer shBrandCd; //브랜드 코드 (나이키,아디다스,퓨마)
	private Integer shTypeCd; //신발 타입코드 (운동화 슬리퍼 등등)
	private Integer salesStatus; //판매상태 (판매중 , 판매중지)
	private Date regDateTime; //등록날짜
	private Date modDateTime; //수정날짜
	private Integer shDelNy; //삭제상태NY
	private Integer shCount; // 신발의 갯수
	private Integer shPrice; //신발 가격
// -----
	/**
	 * @return the shSeq
	 */
	public String getShSeq() {
		return shSeq;
	}
	/**
	 * @param shSeq the shSeq to set
	 */
	public void setShSeq(String shSeq) {
		this.shSeq = shSeq;
	}
	/**
	 * @return the shName
	 */
	public String getShName() {
		return shName;
	}
	/**
	 * @param shName the shName to set
	 */
	public void setShName(String shName) {
		this.shName = shName;
	}
	/**
	 * @return the shSizeCd
	 */
	public Integer getShSizeCd() {
		return shSizeCd;
	}
	/**
	 * @param shSizeCd the shSizeCd to set
	 */
	public void setShSizeCd(Integer shSizeCd) {
		this.shSizeCd = shSizeCd;
	}
	/**
	 * @return the shBrandCd
	 */
	public Integer getShBrandCd() {
		return shBrandCd;
	}
	/**
	 * @param shBrandCd the shBrandCd to set
	 */
	public void setShBrandCd(Integer shBrandCd) {
		this.shBrandCd = shBrandCd;
	}
	/**
	 * @return the shTypeCd
	 */
	public Integer getShTypeCd() {
		return shTypeCd;
	}
	/**
	 * @param shTypeCd the shTypeCd to set
	 */
	public void setShTypeCd(Integer shTypeCd) {
		this.shTypeCd = shTypeCd;
	}
	/**
	 * @return the salesStatus
	 */
	public Integer getSalesStatus() {
		return salesStatus;
	}
	/**
	 * @param salesStatus the salesStatus to set
	 */
	public void setSalesStatus(Integer salesStatus) {
		this.salesStatus = salesStatus;
	}
	/**
	 * @return the regDateTime
	 */
	public Date getRegDateTime() {
		return regDateTime;
	}
	/**
	 * @param regDateTime the regDateTime to set
	 */
	public void setRegDateTime(Date regDateTime) {
		this.regDateTime = regDateTime;
	}
	/**
	 * @return the modDateTime
	 */
	public Date getModDateTime() {
		return modDateTime;
	}
	/**
	 * @param modDateTime the modDateTime to set
	 */
	public void setModDateTime(Date modDateTime) {
		this.modDateTime = modDateTime;
	}
	/**
	 * @return the shDelNy
	 */
	public Integer getShDelNy() {
		return shDelNy;
	}
	/**
	 * @param shDelNy the shDelNy to set
	 */
	public void setShDelNy(Integer shDelNy) {
		this.shDelNy = shDelNy;
	}
	/**
	 * @return the shCount
	 */
	public Integer getShCount() {
		return shCount;
	}
	/**
	 * @param shCount the shCount to set
	 */
	public void setShCount(Integer shCount) {
		this.shCount = shCount;
	}
	/**
	 * @return the shPrice
	 */
	public Integer getShPrice() {
		return shPrice;
	}
	/**
	 * @param shPrice the shPrice to set
	 */
	public void setShPrice(Integer shPrice) {
		this.shPrice = shPrice;
	}
	
	
}
