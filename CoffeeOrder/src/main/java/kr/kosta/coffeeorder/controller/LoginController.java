package kr.kosta.coffeeorder.controller;

import javax.servlet.http.HttpSession;

import kr.kosta.coffeeorder.domain.Admin;
import kr.kosta.coffeeorder.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/login");
		
		return mav;
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(
			@RequestParam("id") String account,
			@RequestParam("pw") String password,
			HttpSession session) {
		
		if(adminService.isEqualsPassword(account, password)) {
		
		Admin admin = adminService.findAdminByAccount(account);
		
		session.setAttribute("loginId", admin.getId());
		session.setAttribute("loginAccount", admin.getAccount());   //나중에 헷갈릴수있음!! 
		session.setAttribute("loginName", admin.getName());
		session.setAttribute("loginStoreId", admin.getStore().getId());
		session.setAttribute("loginStoreName", admin.getStore().getName());
		
			return "redirect:/main.do";
		} else {
			return "redirect:/login.do?error_code=1";
	 	} 
	}
}
