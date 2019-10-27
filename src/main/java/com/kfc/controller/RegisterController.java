package com.kfc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kfc.db.IMemberDao;
import com.kfc.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	private IMemberDao dao;
	
	@Autowired
	private RegisterService service;
	
	@RequestMapping("/")
    public String main() {
        return "main";
    }
	
	@RequestMapping("/check")
    public String check() {
        return "member/login";
    }
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", dao.listDao());
		return "admin/list";
	}
	
    @RequestMapping("/loginForm")
    public String loginForm() {
        return "security/loginForm";
    }
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		String sId = request.getParameter("id");
		service.register(sId);
		
		return "redirect:list";
	}
	
	@RequestMapping("/deregister")
	public String deregister(HttpServletRequest request) {
		String sId = request.getParameter("id");
		service.deregister(sId);
		
		return "redirect:list";
	}
}