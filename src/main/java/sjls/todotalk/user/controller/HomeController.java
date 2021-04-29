package sjls.todotalk.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.user.dao.Sha256;
import sjls.todotalk.user.service.UserService;
import sjls.todotalk.user.vo.ImgVo;
import sjls.todotalk.user.vo.UserVo;


@Controller
public class HomeController {
	
	
	@Autowired
	private UserService userService;
	
	

	@RequestMapping("/")
	public String home() {
		return "home";		
	}
	
	// 로그인 화면
		@RequestMapping("/LoginForm")
		public String loginform() {
			return "login/loginForm";		
		}
		// 로그인 과정
		@RequestMapping("/Login")
		public  ModelAndView login(HttpServletResponse response,HttpSession session, @RequestParam HashMap<String, Object> map) throws IOException {
			ModelAndView  mv = new ModelAndView();
			String  check = (String) map.get("user_pwd");
			Sha256  sha = new Sha256();
			String  check2 = sha.encrypt(check);
			
			if( session.getAttribute("login") != null ) {
				//  기존의 login 값이 존재하면 삭제
				session.removeAttribute("login");
			}
			// 회원의 사진을 들고오기위한 로직
			ImgVo  img = userService.getPhoto(map);
			if(img != null) {
				session.setAttribute("img", img);
			}else {}
			UserVo vo = userService.getUser(map);
			if(vo!=null) {
				String vocheck = vo.getUser_pwd();  // vo ㅇ
				if(vocheck.equals(check)) {  // 암호화가 되어있지 않은 로그인
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
				}else if(vocheck.equals(check2)){  // 암화화가 되어있는 비밀번호
					String user_pwd2 =(String) map.get("user_pwd");
					
					map.put("user_pwd", check2);
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
//					response.setContentType("text/html; charset=UTF-8");
//					PrintWriter out = response.getWriter();
//					out.println("<script>alert('비밀번호가 틀립니다');   </script>");
//					out.flush();
					
					mv.setViewName("redirect:/LoginForm");		
					
				}
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
			return "redirect:/"; // 로그아웃시 이동할 주소
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
			
				
				String user_pwd2 =(String) map.get("user_pwd");
				// 암호화 작업
				Sha256 sha = new Sha256();
				String shaPwd = sha.encrypt(user_pwd2);
				map.put("user_pwd", shaPwd);
				//----------- 암호화 끝 
			userService.inserUser(map);
			
			return "redirect:/";     
		}
		//회원가입 아이디 중복확인
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
				html += " class=red id=check> 사용불가"  ; 
				html += " </b>";
			}else {
				html += " class=blue id=check> 사용가능"  ; 
				html += " </b>";
				
			}
			mv.addObject("html", html);
			mv.setViewName("jsonView");
			return mv;     
		}
		//로그인시  아이디 중복확인
		@RequestMapping("/Check_id2")
		public  ModelAndView check_id2(@RequestParam HashMap<String, Object> map){
			ModelAndView mav = new ModelAndView();
			int result = 0;
			System.out.println(map);
		/* UserVo vo = userService.getid2(map); */
			UserVo vo = userService.getUser(map);
			
			System.out.println("아이디  체크2 "+vo);
			System.out.println("비밀번호  체크  오나? ");
			String  check = (String) map.get("user_pwd");
			System.out.println("비밀번호 값 "+check);
			Sha256 sha = new Sha256();
			
			try {
				String check2 = sha.encrypt(check);
				String vocheck = vo.getUser_pwd();  // vo
				if(vo != null) {
					if(vocheck.equals(check)) {  // 암호화가 되어있지 않은 로그인
						result = 1;
						System.out.println("1번 : "+ result);
					}else if(vocheck.equals(check2)){  // 암화화가 되어있는 비밀번호
						result = 1;
						System.out.println("2번 : "+ result);
					}else {
						result = 0;
						System.out.println("3번 : "+ result);

					}
				}
			} catch (Exception e) {
				//NullPointerInception 이 뜨면 회원이아닌걸로 확인 후 jsp단으로 값 넘김
				System.out.println("error : " + e);
				result = -1;
			}
			
			mav.addObject("result", result);
			mav.setViewName("jsonView");
			return mav;	
		}
		
		// 비밀번호 체크 
		
		@RequestMapping("/Check_pwd")
		public ModelAndView  check_pwd(@RequestParam HashMap<String, Object> map) {
			
			ModelAndView mav = new ModelAndView();
			String result = "";
			System.out.println("비밀번호  체크  오나? ");
			String  check = (String) map.get("user_pwd");
			System.out.println("비밀번호 값 "+check);
			Sha256 sha = new Sha256();
			String check2 = sha.encrypt(check);
			UserVo vo = userService.getUser(map);
			
			
				String vocheck = vo.getUser_pwd();  // vo ㅇ
				if(vo!=null) {
					if(vocheck.equals(check)) {  // 암호화가 되어있지 않은 로그인
						result = "1";
						System.out.println("1번"+result);
						mav.addObject("result1",result);
						mav.setViewName("jsonView");
					}else if(vocheck.equals(check2)){  // 암화화가 되어있는 비밀번호
						result = "1";
						System.out.println("2번"+result);
						mav.addObject("result1", result);
						mav.setViewName("jsonView");
					}else {
						result = "0";
						System.out.println("3번"+result);
						mav.addObject("result1", result);
						mav.setViewName("jsonView");
					}
					
				}else {
					result = "0";
					System.out.println(result);
					mav.addObject("result1", result);
					mav.setViewName("jsonView");
					
				}
			return mav;
		}
		
		// 로그인된 상태에서 회원정보 가지고 오기
			@RequestMapping("/User_Info")
			public String user_info( HttpSession session ,  @RequestParam HashMap <String , Object>   map	) {
				String user_id = (String) session.getAttribute("user_id");
				map.put("user_id", user_id);
				ImgVo  img = userService.getPhoto(map);
				if(img!= null ) {
					session.setAttribute("img", img);
					session.setAttribute("photo_name", img.getPhoto_name());
					
				}else {}
				return "login/user_info"; 
			}
			// 회원정보 업데이트  프로필 사진 업로드
			
			@RequestMapping("/User_UpDate")
			public String user_update(HttpServletRequest request,HttpSession session ,  @RequestParam HashMap <String , Object> map)  {
//				ModelAndView mv = new ModelAndView();
		//-----------------------------------------
				ImgVo  img = userService.getPhoto(map);
				if(img == null) {
					userService.savePhoto(map, request);
				} else {}
			
				
		//-----------------------------------------
				 userService.getuser_info(map);
				map.remove("user_idx",   map.get("user_idx"));
				map.remove("user_name",  map.get("user_name"));
				map.remove("user_phone", map.get("user_phone"));
				map.remove("user_mail",  map.get("user_mail"));
				map.put(   "user_id",    session.getAttribute("user_id"));
				map.put(   "user_pwd",   session.getAttribute("user_pwd"));
				
				
				UserVo vo = userService.getUser(map);
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
				return "redirect:/User_Info"; 
			}
		
			@RequestMapping("/Find")
			public String find() {
				return "login/find";		
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
				return "login/find_pwd";		
			}
		
			@RequestMapping("/Find_PwdLoding")
			public String find_pwdloding(HttpSession session, @RequestParam HashMap<String , Object> map) {
				
				String user_pwd2 =(String) map.get("user_pwd");
				
				
				// 암호화 작업
				Sha256 sha = new Sha256();
				String shaPwd = sha.encrypt(user_pwd2);
				
				map.put("user_pwd", shaPwd);
				UserVo vo =userService.find_pwd(map); 
				if (vo != null) {
					return "redirect:/";
				}
				return "";		
			}
			@RequestMapping("/TestPhoto")
			public String test(HttpSession session, HashMap<String , Object> map) {
				map.put("photo_name", session.getAttribute("photo_name"));
				map.put("user_id", session.getAttribute("user_id"));
				
				userService.deletePhoto(map);
				
				//_________________________________________________
				
				if( session.getAttribute("login") != null ) {
					//  기존의 login 값이 존재하면 삭제
					session.removeAttribute("login");
				}
				
				if( session.getAttribute("img") != null ) {
					//  기존의 login 값이 존재하면 삭제
					session.removeAttribute("img");
				}
				ImgVo  img = userService.getPhoto(map);
				UserVo vo = userService.getUser(map);

				
				if(vo!=null) {
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
				}else {}
				
				if(img!= null ) {
					session.setAttribute("img", img);
				}else {}
				//_________________________________________________
				
				return "redirect:/";		
			}
	
	
}
