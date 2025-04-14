package com.a5a5lab.module.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a5a5lab.module.order.OrderDto;

import jakarta.servlet.http.HttpSession;
@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	
	
	
	
	
	//관리자 로그인
	@RequestMapping(value="/SigninAdimn") 
	public String SigninAdimn () {
		  
		  
		return "xdm/signinadmin/SigninAdimn"; 
	}
	
	//관리자 로그인 구현 
	@ResponseBody
	@RequestMapping(value = "/SigninAdimn1")
	public Map<String, Object> SigninAdimn(MemberDto memberDto,HttpSession httpSession) throws Exception {
			
		Map<String, Object> returnMap = new HashMap<String, Object>();
			
		MemberDto rtt = memberService.selectId(memberDto);
			
		if (rtt != null) {
			returnMap.put("rt", "success");
			//httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqXdm", rtt.getMemSeq());
			httpSession.setAttribute("sessIdXdm", rtt.getMemId());
			httpSession.setAttribute("sessNameXdm", rtt.getMemName());

		} else {
				
				
		}
		    
			
		    
			
		return returnMap;
	}
		
		
	//관리자 로그아웃
	@ResponseBody
	@RequestMapping(value = "/SignoutAdimn1")
	public Map<String, Object> SignoutAdimn1(MemberDto memberDto,HttpSession httpSession) throws Exception {
			
		Map<String, Object> returnMap = new HashMap<String, Object>();
			
				
			httpSession.setAttribute("sessSeqXdm", null);
			httpSession.setAttribute("sessIdXdm", null);
			httpSession.setAttribute("sessNameXdm", null);
			returnMap.put("rt", "success");
				
				
		return returnMap;
			
	}
	
//-----------pda---------------
	
	//pda 로그인화면
	@RequestMapping(value="/SigninPda")
	public String SigninPda() {
		
		return"pda/SigninPda";
	}
	
	//pda 로그인 아작스
	@ResponseBody
	@RequestMapping(value = "/SigninPdaProc")
	public Map<String, Object> SigninPdaProc(MemberDto memberDto,HttpSession httpSession) throws Exception {
			
		Map<String, Object> returnMap = new HashMap<String, Object>();
			
		MemberDto rtt = memberService.selectId(memberDto);
			
		if (rtt != null) {
			returnMap.put("rt", "success");
			//httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqPda", rtt.getMemSeq());
			httpSession.setAttribute("sessIdPda", rtt.getMemId());
			httpSession.setAttribute("sessNamePda", rtt.getMemName());

		} else {
			returnMap.put("rt", "fail");
				
				
		}
		
		return returnMap;
	}
	
	//pda 로그아웃 아작스
		@ResponseBody
		@RequestMapping(value = "/SignoutPdaProc")
		public Map<String, Object> SignoutPdaProc(MemberDto memberDto,HttpSession httpSession) throws Exception {
				
			Map<String, Object> returnMap = new HashMap<String, Object>();
				
					
				httpSession.setAttribute("sessSeqPda", null);
				httpSession.setAttribute("sessIdPda", null);
				httpSession.setAttribute("sessNamePda", null);
				returnMap.put("rt", "success");
					
					
			return returnMap;
				
		}
		
		//주문등록 페이지에서 선택된 주문자 정보가져오기 
		@ResponseBody
		@RequestMapping(value = "/selectOneMemberProc")
		public Map<String, Object> selectOneMemberProc(Model model,MemberDto memberDto) throws Exception {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			MemberDto member = memberService.selectOne(memberDto);
			returnMap.put("memSeq", member.getMemSeq());
			returnMap.put("memId", member.getMemId());
			returnMap.put("memAddress", member.getMemAddress());
					
			return returnMap;
		}
				

	
	
	
}
