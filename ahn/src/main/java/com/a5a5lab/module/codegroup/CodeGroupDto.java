package com.a5a5lab.module.codegroup;

import java.sql.Date;
import java.util.List;

public class CodeGroupDto {
	
	private String cdgSeq;
	private String ifcgName;
	private Integer ifchDelNy; //지운 여부

	private Integer count; //갯수

//	-----
	private Integer xifcdSeqCount; // 코드 그룹 갯수
//	-----
//	검색 날짜
	private Date regDateTime;
	private Date modDateTime;
//	----
	private List<Long> deleteIds;
// -----
	
	public String getCdgSeq() {
		return cdgSeq;
	}
	public List<Long> getDeleteIds() {
		return deleteIds;
	}
	public void setDeleteIds(List<Long> deleteIds) {
		this.deleteIds = deleteIds;
	}
	public void setCdgSeq(String cdgSeq) {
		this.cdgSeq = cdgSeq;
	}
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	public Integer getIfchDelNy() {
		return ifchDelNy;
	}
	public void setIfchDelNy(Integer ifchDelNy) {
		this.ifchDelNy = ifchDelNy;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getXifcdSeqCount() {
		return xifcdSeqCount;
	}
	public void setXifcdSeqCount(Integer xifcdSeqCount) {
		this.xifcdSeqCount = xifcdSeqCount;
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
