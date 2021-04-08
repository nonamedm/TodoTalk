package sjls.todotalk.user.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MentorMenteeSchController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="/mentorMenteeSearch", method=RequestMethod.GET)
	public ModelAndView mentorMenteeSearch(){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("mentorMenteeSearch/mentorMenteePage");
		return mav;
	}
}
