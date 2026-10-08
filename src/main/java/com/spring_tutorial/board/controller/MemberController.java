package com.spring_tutorial.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring_tutorial.board.model.dto.MemberDto;
import com.spring_tutorial.board.service.MemberServiceImpl;
@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	MemberServiceImpl memberService;

	@RequestMapping("login_view.do")
	public String loginView() {
		return "member/login";
	}

	// Modify login method to handle account lock and login attempt count
	@RequestMapping("login.do")
	public ModelAndView login(@ModelAttribute MemberDto dto, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		try {
			memberService.login(dto, session);
			mav.setViewName("main");
			mav.addObject("msg", "loginSuccess");
		} catch (RuntimeException e) {
			mav.setViewName("member/login");
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}

	@RequestMapping("signup_view.do")
	public String signupView() {
		return "member/signup";
	}

	// Modify the signup method to handle password validation and encryption
	@RequestMapping(value="signup.do", method=RequestMethod.POST)
	public ModelAndView signup(@RequestParam String userId, @RequestParam String userPw,
							   @RequestParam String confirmPw, @RequestParam String userName) {
		ModelAndView mav = new ModelAndView();
		try {
			// Confirm password and encrypt
			String encodedPw = memberService.pwConfirmCheck(userPw, confirmPw);
			memberService.signup(new MemberDto(userId, encodedPw, userName));
			mav.setViewName("member/login");
			mav.addObject("msg", "signupSuccess");
		} catch (RuntimeException e) {
			mav.setViewName("member/signup");
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}