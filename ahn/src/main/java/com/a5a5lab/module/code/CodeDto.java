package com.a5a5lab.module.code;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CodeDto {
	
	private String cdSeq; // 코드Seq
	private String ifcdName; //코드 이름
	private Integer ifcdDelNy; //업데이트 삭제
	private String newsAgencyName; //통신사 이름
	private String codeGroup_cdgSeq; //코드구릅Seq
	private String ifcgName; // 코드 그룹 이름
	private String cdgSeq;// 코드 그룹 Seq;
//	-----
//	for cache
//	검색 날짜
	private Date regDateTime;
	private Date modDateTime;
//	----
	private List<Long> deleteIds;
// -----	
	
	
	
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	
	
	public List<Long> getDeleteIds() {
		return deleteIds;
	}
	public void setDeleteIds(List<Long> deleteIds) {
		this.deleteIds = deleteIds;
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
	public Integer getIfcdDelNy() {
		return ifcdDelNy;
	}
	public void setIfcdDelNy(Integer ifcdDelNy) {
		this.ifcdDelNy = ifcdDelNy;
	}
	public String getNewsAgencyName() {
		return newsAgencyName;
	}
	public void setNewsAgencyName(String newsAgencyName) {
		this.newsAgencyName = newsAgencyName;
	}
	public String getCodeGroup_cdgSeq() {
		return codeGroup_cdgSeq;
	}
	public void setCodeGroup_cdgSeq(String codeGroup_cdgSeq) {
		this.codeGroup_cdgSeq = codeGroup_cdgSeq;
	}
	

//	----
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	public String getCdgSeq() {
		return cdgSeq;
	}
	public void setCdgSeq(String cdgSeq) {
		this.cdgSeq = cdgSeq;
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
	
	
}
