package sjls.todotalk.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.user.service.MentorSchService;

@Controller
public class MentorMenteeSchController {
	
	@Autowired
	private MentorSchService mentorSchService;
	
	@RequestMapping(value="/mentorMenteeSearch", method=RequestMethod.GET)
	public ModelAndView mentorMenteeSearch(){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("mentorMenteeSearch/mentorMenteePage");
		return mav;
	}
	
	@RequestMapping(value="/mentorSearchFm", method=RequestMethod.POST)
	public ModelAndView mentorSearchFm(@RequestParam String mentorSearch) {
		ModelAndView mav = new ModelAndView();
		
		List<Map<String, Object>> mentorList = mentorSchService.getMentorList(mentorSearch);
		System.out.println(mentorList);
		
		mav.addObject("mentorList", mentorList);
		mav.setViewName("jsonView");
		return mav;
	}
	
	//멘토정보보기 기능
	@RequestMapping(value="/detailInfo", method=RequestMethod.POST)
	public ModelAndView detailInfo(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		String userid = req.getParameter("userid");
		
		System.out.println(userid);
		
		HashMap<String, Object> mentorInfo = mentorSchService.getMentorInfo(userid);
		mav.addObject("mentorInfo", mentorInfo);
		mav.setViewName("jsonView");
		return mav;
	}
}
