package sjls.todotalk.user.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.user.service.AllSearchService;
import sjls.todotalk.user.service.ChatRoomService;
import sjls.todotalk.user.vo.MessageVo;
import sjls.todotalk.user.vo.RelationVo;
import sjls.todotalk.user.vo.RoomVo;
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
	@RequestMapping(value="/talk", method= {RequestMethod.POST, RequestMethod.GET}) 
	public String talk (HttpServletRequest request,HttpServletResponse response, Model model){	
		String receiverId = request.getParameter("receiverId");
		String requireId = request.getParameter("requireId");
		String loginId = request.getParameter("loginId");
		System.out.println("로그인아이디 확인 : "+loginId);
		Object chatRooms = new HashMap<String,RoomVo>();
		chatRooms = chatRoomService.findAllRoom();
		
		//방이 현재 roomList에 없으면 만든다. DB 없으면 추가한다. 
		RoomVo roomVo = chatRoomService.createRoomById(receiverId,requireId);			
		model.addAttribute("room", roomVo);
		model.addAttribute("loginId",loginId);
		model.addAttribute("receiverId",receiverId);
		return "room";
	}
	@RequestMapping("/relationList")
	public String relationList (String loginId,Model model) {
		List<RelationVo> relationList = allSearchService.getRelationList(loginId);
		List<RelationVo> relationRequire = allSearchService.getRelationRequire(loginId);
		System.out.println("친구 목록 : "+relationList);
		System.out.println("친구 요청목록 : "+relationRequire);
		model.addAttribute("loginId",loginId);
		return "relationList";
	}
	@RequestMapping("/rooms")
	public String rooms (String loginId,Model model) {
		Object chatRooms = new HashMap<String,RoomVo>();
		chatRooms = chatRoomService.findAllRoom();
		model.addAttribute("rooms",chatRooms);			//개설된 모든 대화방을 찾아서 rooms에 입력
		//System.out.println("넘어온 값 : "+chatRoomRepository.findAllRoom()); 확인
		List<MessageVo> findRoomByLogin = chatRoomService.findRoomByLogin(loginId);
		List<Integer> newMessageList = new ArrayList<>();
		if(findRoomByLogin.size()!=0) {
			for (int i = 0; i < findRoomByLogin.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				String roomId = findRoomByLogin.get(i).getRoomId();
				map.put("roomId", roomId);
				map.put("loginId", loginId);
				int newMessage = chatRoomService.findNewMessage(map);
				newMessageList.add(newMessage);
			}
		}
		System.out.println("대화방 목록 : "+findRoomByLogin);
		model.addAttribute("list",findRoomByLogin);
		model.addAttribute("newList",newMessageList);
		model.addAttribute("loginId",loginId);
		return "rooms";
	}
	
	@RequestMapping(value="/loadTalk", method=RequestMethod.POST)
	public ModelAndView loadTalk (HttpServletRequest request) {
		String roomId = request.getParameter("roomId");
		List<MessageVo> loadMessage = new ArrayList<MessageVo>();
		ModelAndView mav = new ModelAndView();
		loadMessage = chatRoomService.loadAllMessage(roomId);
		
		//System.out.println("메세지 불러오기 확인 : "+loadMessage);
		mav.addObject("loadMessage",loadMessage);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value="/alertCount", method=RequestMethod.POST)
	public ModelAndView alertCount (HttpServletRequest request) {
		String loginId = request.getParameter("loginId");		//로그인 id 받아서, sql 조회 -> 메세지 수신 나인데 상태 1인거 다 가져오기
		int alertCount = chatRoomService.alertCount(loginId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("alertCount",alertCount);
		mav.setViewName("jsonView");
		return mav;
	}
	@RequestMapping(value="/relation", method= RequestMethod.POST) 
	public ModelAndView relation (HttpServletRequest request,HttpServletResponse response){
		String require_id = request.getParameter("require_id");
		String require_name = request.getParameter("require_name");
		String receiver_id = request.getParameter("receiver_id");
		//System.out.println("넘어온값"+require_id+require_name+receiver_id+receiver_name);
		//튜터 검색결과 반환
		UserVo userVo = allSearchService.getUserList(receiver_id);
		String userPhoto = allSearchService.getPhotoName(receiver_id);
		//System.out.println("receiver 정보 : "+userVo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("require_id",require_id);
		mav.addObject("require_name",require_name);
		mav.addObject("receiver",userVo);
		mav.addObject("photo_name",userPhoto);
		mav.setViewName("/relation");
		return mav;
	}
	@RequestMapping(value="/relationCreate", method= RequestMethod.POST) 
	public ModelAndView relationCreate (HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		String require_id = request.getParameter("require_id");
		String require_name = request.getParameter("require_name");
		String receiver_id = request.getParameter("receiver_id");
		String receiver_name = request.getParameter("receiver_name");
		//System.out.println("넘어온값확인 : "+require_id+require_name+receiver_id+receiver_name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("require_id", require_id);
		map.put("require_name", require_name);
		map.put("receiver_id", receiver_id);
		map.put("receiver_name", receiver_name);
		// 신청 중복 체크
		Map<String, Object> relationCheck = new HashMap<String, Object>();
		relationCheck.put("require_id", require_id);
		relationCheck.put("receiver_id", receiver_id);
		List<RelationVo> checkResult = allSearchService.getRelationCheck(relationCheck);	
		//System.out.println("중복체크 : "+checkResult);
		if(checkResult.size()>=1) {
		} else {
			allSearchService.relationCreate(map);
			mav.addObject("receiver_id",receiver_id);
			mav.addObject("receiver_name",receiver_name);
		}
		mav.setViewName("/relationCreate");
		return mav;
	}
	
}