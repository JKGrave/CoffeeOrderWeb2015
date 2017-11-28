package kr.kosta.coffeeorder.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import kr.kosta.coffeeorder.domain.DiscountCard;
import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.dto.MemberSearchCond;
import kr.kosta.coffeeorder.dto.PageResult;
import kr.kosta.coffeeorder.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController
{
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("members")
	public ModelAndView showMembers(
			@RequestParam(value = "page", required=false)Integer page,
			MemberSearchCond search,
			HttpSession session
			) {
		ModelAndView mav = new ModelAndView();
		if(page != null){
			search.setPage(page);
		}
		PageResult pageResult =this.memberService.fintMembersBySearchCond(search);
		pageResult.getTotalPage();
		
		mav.addObject("pageResult", pageResult);
		mav.setViewName("/member/members");
		return mav;
	}
}
