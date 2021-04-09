package sjls.todotalk.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.user.service.AllSearchService;
import sjls.todotalk.user.vo.UserVo;


@Controller
public class HomeController {
	
	@Autowired
	AllSearchService allSearchService;
	
	@RequestMapping("/")
	public String home() {
		return "home";		
	}
	
	@RequestMapping(value="/AllSearch", method=RequestMethod.GET)
	public ModelAndView allSearch(String query) {
		String queryString = query;
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("queryString", queryString);	//검색어 mapping
		//튜터 검색결과 반환
		List<UserVo> tutorVo = allSearchService.getTutorList(map);
		int tutorVoSize = tutorVo.size();
		System.out.println("튜터검색결과 : "+tutorVo);
		//멘토 검색결과 반환
		List<UserVo> mentorVo = allSearchService.getMentorList(map);
		System.out.println("멘토검색결과 : "+mentorVo);
		int mentorVoSize = mentorVo.size();
		//게시판 검색결과 반환
		List<HashMap<String, Object>> boardAllSearch = allSearchService.getBoardList(map);
		System.out.println("게시판검색결과 :"+boardAllSearch);
		int boardAllSearchSize = boardAllSearch.size();
//		System.out.println(map.size());
//		System.out.println(boardAllSearch.get(0));
		
		mav.addObject("tutorVo",tutorVo);
		mav.addObject("tutorVoSize",tutorVoSize);
		mav.addObject("mentorVo",mentorVo);
		mav.addObject("mentorVoSize",mentorVoSize);
		mav.addObject("boardAllSearch",boardAllSearch);
		mav.addObject("boardAllSearchSize",boardAllSearchSize);
		mav.setViewName("/allSearch");
		
		return mav;		
	}
	
}
