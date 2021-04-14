package sjls.todotalk.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.user.service.TutoringService;
import sjls.todotalk.user.vo.TuboVo;
import sjls.todotalk.user.vo.TureVo;

@Controller
public class TutoringController {

	@Autowired
	TutoringService tutoringService;

	// 튜터링 게시판 이동
	@RequestMapping(value = "/tutoringwrite", method = RequestMethod.GET)
	public ModelAndView letsWrite(@RequestParam HashMap<String, Object> map) {

		List<TuboVo> tuboList = tutoringService.getWritingList(map);
		ArrayList<String> questionList = new ArrayList<String>();
		questionList.add("질문1");
		questionList.add("질문2");
		questionList.add("질문3");
		questionList.add("질문4");
		questionList.add("질문5");
		questionList.add("질문6");

		ModelAndView mav = new ModelAndView();
		// HashMap<String, Object> map = new HashMap<String, Object>();
		mav.addObject("tuboList", tuboList);
		mav.addObject("questionList", questionList);

		mav.setViewName("/tutoring/letswrite");
		return mav;
	}

	// 튜터링 게시판에서 글썼을때
	@RequestMapping(value = "/postwriting", method = RequestMethod.POST)
	public String postWriting(TuboVo tuboVo) {

		ModelAndView mv = new ModelAndView();
		tutoringService.insertWriting(tuboVo);

		return "redirect:/tutoringwrite";
	}

	// 튜터링 첫번째 게시판에서 첫번째 질문 클릭했을때
	@RequestMapping(value = "/tutoringwrite/view/question", method = RequestMethod.GET)
	public ModelAndView question1(@RequestParam HashMap<String, Object> map) {

		
		 String tubo_idx = (String) map.get("tubo_idx");
		 map.put("tubo_idx",tubo_idx);
		 
//		 String user_id = (String) map.get("user_id");
//		 map.put("user_id",user_id);
		 String tubo_regdate = (String) map.get("tubo_regdate");
		 map.put("tubo_regdate", tubo_regdate);
//		 String tubo_title = (String)map.get("tubo_title");
//		 map.put("tubo_title", tubo_title);
		/* TuboVo tuboVo =tutoringService.getView(map); */
		 

		List<TuboVo> tuboListOfQuestion1 = tutoringService.getQuestion1List(map);

		//List<TureVo> tureVo = tutoringService.getReplyView(map);

		ModelAndView mav = new ModelAndView();
		// mav.addObject("tuboVo",tuboVo);
		// System.out.println("tuboVo : " + tuboVo);
		//mav.addObject("tureVo", tureVo);
		// mav.addObject("tubo_title",tubo_title);
		mav.addObject("tuboListOfQuestion1", tuboListOfQuestion1);
		mav.setViewName("/tutoring/question");
		return mav;
	}

	// list에서 글 클릭했을때 이동하는 글 view페이지
	@RequestMapping("/tutoringwrite/view")
	public ModelAndView viewWriting(@RequestParam HashMap<String, Object> map) {

		String tubo_idx = (String) map.get("tubo_idx");
		map.put("tubo_idx", tubo_idx);
		String user_id = (String) map.get("user_id");
		map.put("user_id", user_id);
		String tubo_regdate = (String) map.get("tubo_regdate");
		map.put("tubo_regdate", tubo_regdate);
		String tubo_title = (String) map.get("tubo_title");
		map.put("tubo_title", tubo_title);
		TuboVo tuboVo = tutoringService.getView(map);

		// 댓글 파라미터 불러와야함
		List<TureVo> tureVo = tutoringService.getReplyView(map);

		ModelAndView mv = new ModelAndView();
		mv.addObject("tuboVo", tuboVo);
		mv.addObject("tureVo", tureVo);
		// mv.addObject("tubo_title",tubo_title);
		mv.setViewName("/tutoring/viewwriting");

		return mv;

	}

	@RequestMapping(value = "/postreply", method = RequestMethod.POST)
	public String postReply(TureVo tureVo, @RequestParam HashMap<String, Object> map) {

		ModelAndView mav = new ModelAndView();
		// 댓글리스트 땡겨와서 넣기
		// addObject 에 떙겨온 리스트(replyList) 넣기 -> ajax에서 result로 불러오기
		// (result.replyList.user_id)

		tutoringService.insertReply(tureVo);

		String tubo_idx = (String) map.get("tubo_idx");
		String user_id = (String) map.get("user_id");
		String tubo_regdate = (String) map.get("tubo_regdate");
		System.out.println("tubo_idx : " + tubo_idx + "user_id : " + user_id + "tubo_regdate : " + tubo_regdate);

		mav.setViewName("jsonView");

		return null;
	}

}