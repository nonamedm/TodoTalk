package sjls.todotalk.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MentorMenteeSchController {
	
	@RequestMapping(value="/mentorMenteeSearch", method=RequestMethod.GET)
	public ModelAndView mentorMenteeSearch(){
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("mentorMenteeSearch/mentorMenteePage");
		return mav;
	}
}
