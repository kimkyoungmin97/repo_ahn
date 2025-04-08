package com.a5a5lab.module.member;

public class MemberDto {
	
	private String memSeq; //Seq
	private String memName; //이름
	private String memId; //아이디
	private String memPw; // 비밀번호
	private String memAddress; // 주소
	private Integer memDelNy; // 업데이트 삭제
	
//	----	
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
	public Integer getMemDelNy() {
		return memDelNy;
	}
	public void setMemDelNy(Integer memDelNy) {
		this.memDelNy = memDelNy;
	}

}
