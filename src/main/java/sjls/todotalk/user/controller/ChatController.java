package sjls.todotalk.user.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.user.vo.RoomVo;
import sjls.todotalk.user.dao.Sha256;
import sjls.todotalk.user.service.AllSearchService;
import sjls.todotalk.user.service.ChatRoomService;
import sjls.todotalk.user.service.UserService;
import sjls.todotalk.user.vo.UserVo;


@Controller
public class ChatController {
	
	@Autowired
	AllSearchService allSearchService;
	
	@Autowired
	ChatRoomService chatRoomService;
	
	
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
	@RequestMapping(value="/talk/{id}", method=RequestMethod.GET) 
	public String talk (@PathVariable String id, Model model){		//클릭한 방의 id를 roomVo에 저장하고, 경로 지정
		RoomVo roomVo = chatRoomService.createRoomById(id);			//회원 로그인 되면 토크 거는사람 아이디도 받아오기
																	
		//추가할 로직 : 받은 id값과 로그인유저 id값으로 검색해서, 포함된 방이 없으면 새로 만들기
		roomVo = chatRoomService.findRoomById(roomVo.getRoomId());
		
		System.out.println(roomVo.getRoomId()+", "+roomVo.getName()+" : 대화방 생성 성공"); //대화방생성완료
		
		//여기서 DB 불러오기 -> model.addAttribute로 저장
		
		
		model.addAttribute("room",roomVo);							//roomVo를 room에 입력
		return "room";
	}
	@RequestMapping(value="/keeptalk/{id}", method=RequestMethod.GET)
	public String keeptalk (@PathVariable String id, Model model) {
		RoomVo roomVo = chatRoomService.findRoomById(id);
		model.addAttribute("room", roomVo);
		return "room";
	}
	
	@RequestMapping("/rooms")
	public String rooms (Model model) {
		Object chatRooms = new HashMap<String,RoomVo>();
		chatRooms = chatRoomService.findAllRoom();
		model.addAttribute("rooms",chatRooms);						//개설된 모든 대화방을 찾아서 rooms에 입력
		//System.out.println("넘어온 값 : "+chatRoomRepository.findAllRoom()); 확인
		
		return "rooms";
	}
}