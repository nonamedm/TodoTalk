package sjls.todotalk.user.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.user.service.TutoringService;
import sjls.todotalk.user.vo.TuboVo;

@Controller
public class TutoringController {
	
	@Autowired
	TutoringService mentoringService;

	//튜터링 첫번째 게시판 이동
	@RequestMapping(value="/tutoringwrite", method=RequestMethod.GET)
	public ModelAndView letsWrite(
			@RequestParam HashMap<String, Object> map) {
		
		List <TuboVo> tuboList = mentoringService.getWritingList(map);
		
		ModelAndView mav = new ModelAndView();
		//HashMap<String, Object> map = new HashMap<String, Object>();
		mav.addObject("tuboList", tuboList);
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
	
	//튜터링 첫번째 게시판에서 첫번째 질문 클릭했을때
	@RequestMapping(value="/question1", method=RequestMethod.GET)
	public ModelAndView question1(
			@RequestParam HashMap<String, Object> map) {
		
		List <TuboVo> tuboListOfQuestion1 = mentoringService.getQuestion1List(map);
		
		ModelAndView mav = new ModelAndView();
		//HashMap<String, Object> map = new HashMap<String, Object>();
		
		mav.addObject("tuboListOfQuestion1", tuboListOfQuestion1);
		mav.setViewName("/tutoring/question1");
		return mav; 
	}
}
