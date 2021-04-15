package sjls.todotalk.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sjls.todotalk.user.vo.UserVo;

public interface UserDao {

	void insertUser(HashMap<String, Object> map);
	
	//로그인기능
	UserVo getUser(HashMap<String, Object> map);
	
	// user_id 중복확인
	UserVo getid(HashMap<String, Object> map);
	UserVo getid2(HashMap<String, Object> map);

	// user 개인 정보 
	UserVo getuser_info(HashMap<String, Object> map);
	
	// user  비밀번호 찾기
	UserVo find_pwd(HashMap<String, Object> map);
	
	// 프로필 사진 
	void savePhoto(HashMap<String, Object> map);

}
