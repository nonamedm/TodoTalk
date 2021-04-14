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
public class HomeController {
	
	@Autowired
	AllSearchService allSearchService;
	
	@Autowired
	ChatRoomService chatRoomService;
	
	@Autowired
	private UserService userService;
	
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
	
	
	// 로그인 화면
		@RequestMapping("/LoginForm")
		public String loginform() {
			return "login/loginForm";		
		}
		// 로그인 과정
		@RequestMapping("/Login")
		public  ModelAndView login(HttpSession session, @RequestParam HashMap<String, Object> map) {
			ModelAndView  mv = new ModelAndView();
			
			
			UserVo vo = userService.getUser(map);
			
			System.out.println(vo);
			
			if( session.getAttribute("login") != null ) {
				//  기존의 login 값이 존재하면 삭제
				session.removeAttribute("login");
			}
			
			if(vo != null) {  // 암호화가 되어있지 않은 로그인
				session.setAttribute("login",          vo);
				session.setAttribute("user_id",        vo.getUser_id());
				session.setAttribute("user_idx",       vo.getUser_idx());
				session.setAttribute("user_mail",      vo.getUser_mail());
				session.setAttribute("user_name",      vo.getUser_name());
				session.setAttribute("user_phone",     vo.getUser_phone());
				session.setAttribute("user_pwd",       vo.getUser_pwd());
				session.setAttribute("user_regdate",   vo.getRegdate());
				session.setAttribute("user_register",  vo.getRegister());
				session.setAttribute("user_country",   vo.getCountry());
				session.setAttribute("user_introduce", vo.getIntroduce());
				mv.setViewName("redirect:/");
			}else if(map!= null){  // 암화화가 되어있는 비밀번호
				String user_pwd2 =(String) map.get("user_pwd");
				
				Sha256 sha = new Sha256();
				String shaPwd = sha.encrypt(user_pwd2);
				
				map.put("user_pwd", shaPwd);
				System.out.println("map :"+map);
				
				 vo = userService.getUser(map);
				 	session.setAttribute("login",          vo);
					session.setAttribute("user_id",        vo.getUser_id());
					session.setAttribute("user_idx",       vo.getUser_idx());
					session.setAttribute("user_mail",      vo.getUser_mail());
					session.setAttribute("user_name",      vo.getUser_name());
					session.setAttribute("user_phone",     vo.getUser_phone());
					session.setAttribute("user_pwd",       vo.getUser_pwd());
					session.setAttribute("user_regdate",   vo.getRegdate());
					session.setAttribute("user_register",  vo.getRegister());
					session.setAttribute("user_country",   vo.getCountry());
					session.setAttribute("user_introduce", vo.getIntroduce());
				
					mv.setViewName("redirect:/");		
			}else {
				mv.setViewName("redirect:/LoginForm");		
				
			}
			return mv;    
		}  
		
		
		// 로그아웃 처리
		@RequestMapping("/LogOut")
		public  String  logout( HttpSession session	) {
			if(session != null) {
				session.invalidate();  // 새션 전채를 날려버림
			}
			else {
				System.out.println("값이 없습니다");
			}
			//  session.removeArribute("login"); // 해당 속성만 제거
			return "redirect:/"; // 로그아웃시 이동할 주소
			//return "redirect:/PDS/List?menu_id..."; // 로그아웃시 이동할 주소
		}
		
		
		// 회원가입 화면 
		@RequestMapping("/User_MakeForm")
		public  String  user_makeform() {
			
			return "login/user_make";     // �씠�룞�븷 jsp �씠由�
		}  
		// 회원가입 과정
		@RequestMapping("/User_Make")
		public  String  user_make(
				@RequestParam HashMap<String, Object> map) {
			String i  = "@";
			
			String user_mail=(String) map.get("user_mail1");
			user_mail += i ;
			user_mail += (String) map.get("user_mail2");
			map.remove("user_mail1", map.get("user_mail1"));
			map.remove("user_mail2", map.get("user_mail2"));
			map.put("user_mail", user_mail);
				
			String user_phone =""; 
			user_phone += (String) map.get("user_phone1");
			user_phone += "-";
			user_phone += (String) map.get("user_phone2") ;
			user_phone += "-";
			user_phone += (String) map.get("user_phone3") ;
			map.put("user_phone", user_phone);
			map.remove("user_phone1", map.get("user_phone1"));
			map.remove("user_phone2", map.get("user_phone2"));
			map.remove("user_phone3", map.get("user_phone3"));
			
				System.out.println(map);
				
				String user_pwd2 =(String) map.get("user_pwd");
				
				System.out.println("기존 PWD"+ user_pwd2);
				
				
				
				Sha256 sha = new Sha256();
				String shaPwd = sha.encrypt(user_pwd2);
				
				map.put("user_pwd", shaPwd);
				System.out.println("map :"+map);
					
				
				
				
				
				
			userService.inserUser(map);
			
			
			
			
			

			
			
			return "redirect:/";     // �씠�룞�븷 jsp �씠由�
		}
		// 아이디 중복확인
		@RequestMapping("/Check_id")
		public  ModelAndView check_id(
				@RequestParam HashMap<String, Object> map) {
			
			System.out.println(map);
			
			UserVo  vo  = userService.getid(map);
			ModelAndView mv= new ModelAndView();
			System.out.println(vo);
			String result = "";
			if(vo != null) {
				result += "false";
			}else {
				result += "true";
			}
			
			String html = "<b";
			if(result.equals("false") ) {
				html += " class=red> 사용불가"  ; 
				html += " </b>";
			}else {
				html += " class=blue> 사용가능"  ; 
				html += " </b>";
				
			}
			System.out.println("userid1 "+html);
			mv.addObject("html", html);
			mv.setViewName("jsonView");
			
			
			return mv;     
		}
		// 아이디 중복확인
		@RequestMapping("/Check_id2")
		public  ModelAndView check_id2(
				@RequestParam HashMap<String, Object> map) {
			
			System.out.println(map);
			
			UserVo  vo  = userService.getid2(map);
			ModelAndView mv= new ModelAndView();
			System.out.println(vo);
			String result = "";
			if(vo != null) {
				result += "true";
			}else {
				result += "false";
			}
			
			String html = "<b";
			if(result.equals("false") ) {
				html += " class=red> 존제하지않는 값입니다"  ; 
				html += " </b>";
			}else {
				html += " class=blue>"  ; 
				html += " </b>";
				
			}
			System.out.println("getid2"+ html);
			mv.addObject("html", html);
			mv.setViewName("jsonView");
			
			
			return mv;     
		}
		
		// 로그인된 상태에서 회원정보 가지고 오기
			@RequestMapping("/User_Info")
			public String user_info( HttpSession session ,  @RequestParam HashMap <String , Object>   map	) {
				System.out.println("user_info :"+ session.getAttribute("login"));
			
				return "login/user_info"; 
			}
			// 회원정보 업데이트 
			@RequestMapping("/User_UpDate")
			public String user_update( HttpSession session ,  @RequestParam HashMap <String , Object>   map	) {
//				ModelAndView mv = new ModelAndView();
				System.out.println("1"+map);
				 userService.getuser_info(map);
				map.remove("user_idx",   map.get("user_idx"));
				map.remove("user_name",  map.get("user_name"));
				map.remove("user_phone", map.get("user_phone"));
				map.remove("user_mail",  map.get("user_mail"));
				map.put(   "user_id",    session.getAttribute("user_id"));
				map.put(   "user_pwd",   session.getAttribute("user_pwd"));
				
				
				UserVo vo = userService.getUser(map);
				
				System.out.println(vo);
				
				if( session.getAttribute("login") != null ) {
					//  기존의 login 값이 존재하면 삭제
					session.removeAttribute("login");
				}
				
				if(vo != null) {
					session.setAttribute("login",          vo);
					session.setAttribute("user_id",        vo.getUser_id());
					session.setAttribute("user_idx",       vo.getUser_idx());
					session.setAttribute("user_mail",      vo.getUser_mail());
					session.setAttribute("user_name",      vo.getUser_name());
					session.setAttribute("user_phone",     vo.getUser_phone());
					session.setAttribute("user_pwd",       vo.getUser_pwd());
					session.setAttribute("user_regdate",   vo.getRegdate());
					session.setAttribute("user_register",  vo.getRegister());
					session.setAttribute("user_country",   vo.getCountry());
					session.setAttribute("user_introduce", vo.getIntroduce());
				
				}else{
					return "redirect:/";
					
				}
				
				System.out.println("수정"+map);
				
				System.out.println("update :" + session.getAttribute("login") );
				return "redirect:/"; 
			}
		
			@RequestMapping("/Find")
			public String find() {
				return "find";		
			}
			@RequestMapping("/Find_Id")
			public String find_id( ) {
				return "find";		
			}
			@RequestMapping("/Find_IdLoding")
			public String find_idloding( @RequestParam HashMap<String , Object> map) {
				return "find";		
			}
			@RequestMapping("/Find_Pwd")
			public String find_pwd( ) {
				return "find";		
			}
		
			@RequestMapping("/Find_PwdLoding")
			public String find_pwdloding(HttpSession session, @RequestParam HashMap<String , Object> map) {
				System.out.println("비번 찾기 "+map);
				UserVo vo =userService.find_pwd(map);
//				session.setAttribute("user_id", map.get("user_id"));
				if(vo!= null) {
					session.setAttribute("user_idx", vo);
					return  "redirect:/"; 
				}else {
					return  "redirect:/"; 
					
				}
				
//				return "find";		
			}
	
	
	
}
