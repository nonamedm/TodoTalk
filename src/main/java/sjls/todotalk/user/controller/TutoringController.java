package sjls.todotalk.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TutoringController {
	
	//튜터링 작문게시판 이동
	@RequestMapping(value="/tutoringwrite", method=RequestMethod.GET)
	public ModelAndView letswrite() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/tutoring/letswrite");
		return mav;
	}

}
