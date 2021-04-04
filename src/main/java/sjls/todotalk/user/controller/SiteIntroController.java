package sjls.todotalk.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SiteIntroController {
	
	//사이트기능소개 페이지 이동
	@RequestMapping(value="/siteFuncIntro", method=RequestMethod.GET)
	public ModelAndView siteFuncIntro() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/siteintro/siteIntro");
		return mav;
	}
	
	//관리자소개 페이지 이동
	@RequestMapping(value="/adminIntro", method=RequestMethod.GET)
	public ModelAndView adminIntro() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/siteintro/adminIntro");
		return mav;
	}
	
	//CI소개 페이지 이동
	@RequestMapping(value="/ciIntro", method=RequestMethod.GET)
	public ModelAndView ciIntro() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/siteintro/ciIntro");
		return mav;
	}
}
