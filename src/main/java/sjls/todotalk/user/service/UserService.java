package sjls.todotalk.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.user.vo.UserVo;

public interface UserService {

	void inserUser(HashMap<String, Object> map);
	
	//로그인기능 
	UserVo getUser(HashMap<String, Object> map);

	// 아이디 중복 검사 
	UserVo getid(HashMap<String, Object> map);
	UserVo getid2(HashMap<String, Object> map);

	// 유저 개인정보 
	UserVo getuser_info(HashMap<String, Object> map);
	
	//비번 찾기
	UserVo find_pwd(HashMap<String, Object> map);
	

	// 프로필 삽입
	void savePhoto(HashMap<String, Object> map, HttpServletRequest request);
	
	//출석체크여부확인
	public int attendanceCheckYn(HashMap<String, Object> map);
	
	//유저 출석체크
	public void attendanceCheck(HashMap<String, Object> map);
	
	//출석현황리스트 
	public List<Map<String, Object>> attendanceTag(String userid);
	
	
	
//	// 비밀 번호 재설정
//	void user_pwdupdate(HashMap<String, Object> map);

}
