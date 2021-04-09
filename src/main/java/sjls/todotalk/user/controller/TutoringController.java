package sjls.todotalk.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.user.service.MentoringService;
import sjls.todotalk.user.vo.TuboVo;

@Controller
public class TutoringController {
	
	@Autowired
	MentoringService mentoringService;

	//튜터링 첫번째 게시판 이동
	@RequestMapping(value="/tutoringwrite", method=RequestMethod.GET)
	public ModelAndView letsWrite() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/tutoring/letswrite");
		return mav;
	}
	
	//튜터링 첫번째 게시판에서 글썼을때
	@RequestMapping(value="/postwriting", method=RequestMethod.POST)
	public String postWriting(TuboVo tuboVo) {
		
		ModelAndView mv = new ModelAndView();
		mentoringService.insertWriting(tuboVo);
		
		return "redirect:/tutoringwrite";
	}
	
}
