package com.a5a5lab.module.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a5a5lab.common.util.UtilDateTiem;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	
	
	/*
	 * // 코드 리스트 사용자 회원 가입에 뿌려주기
	 * 
	 * @RequestMapping(value ="/SignupUserForm") public String SignupUserForm(CodeVo
	 * vo, Model model) { model.addAttribute("list", codeService.selectList(vo));
	 * return "user/signup/SignupUserForm"; }
	 */
	 
	 
	
	// 리스트 보여주고 페이지네이션 보여주기
	@RequestMapping(value = "/code/codeXdmList")
	public String codeXdmList(CodeVo vo, Model model) {
		
		vo.setParamsPaging(codeService.selectOneCount(vo));
		model.addAttribute("list", codeService.selectList(vo));
		model.addAttribute("vo",vo);
		
		// UtilDateTiem 함수 가져와서 사용 
		
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTiem.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTiem.add59TimeString(vo.getShDateEnd()));
		
		return "xdm/code/codeXdmList";
	}
	
	
	// 등록폼
	@RequestMapping(value="/code/CodeXdmForm")
	public String CodeXdmForm( CodeDto codeDto, Model model , CodeVo vo) {
		
		
		model.addAttribute("list", codeService.codeGroupNameSeq(codeDto));
		model.addAttribute("vo", vo);
		
		
		if (vo.getCdSeq().equals("0") || vo.getCdSeq().equals("")) {	
			
		} else {
//			update mode			
			model.addAttribute("item", codeService.selectOne(vo));
			
		}
		
		return "xdm/code/codeXdmForm";
	}
	
	// 등록후 리스트 에서 보여주라
	@RequestMapping(value="/code/CodeXdmInst")
	public String CodeXdmInst(CodeDto codeDto) {
		System.out.println(codeDto.getCodeGroup_cdgSeq());
		codeService.insert(codeDto);
		return "redirect:/code/codeXdmList";
	}
	
	//업데이트
	@RequestMapping(value="/code/CodeXdmUpdt")
	public String CodeXdmUpdt(CodeDto codeDto) {
		codeService.update(codeDto);
		return "redirect:/code/codeXdmList";
	}
	
	
	
	
	// 업데이트 삭제
	@RequestMapping(value="/code/CodeXdmUele")
	public String CodeXdmUele(CodeDto codeDto) {
		codeService.uelete(codeDto);
		return "redirect:/code/codeXdmList";
	}
	
	
	/*
	 * //데이터 1개씩 뽑아서 폼 화면 뿌리기
	 * 
	 * @RequestMapping(value="/code/CodeView") public String CodeView(Model
	 * model,CodeDto codeDto,CodeVo vo) {
	 * 
	 * 
	 * model.addAttribute("item", codeService.selectOne(codeDto,vo));
	 * 
	 * return"xdm/code/CodeXdmForm"; }
	 */
	
		
	
	
		
		
		
}
