package sjls.todotalk.user.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjls.todotalk.user.dao.UserDao;
import sjls.todotalk.user.service.UserService;
import sjls.todotalk.user.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {

	
	@Autowired
	private  UserDao  userDao;
	
	
	@Override
	public void inserUser(HashMap<String, Object> map) {
			userDao.insertUser(map);
	}

	@Override
	public UserVo getUser(HashMap<String, Object> map) {
		UserVo  vo = userDao.getUser(map);
		System.out.println("ser : "+map);
		return vo;
	}

	@Override
	public UserVo getid(HashMap<String, Object> map) {
		UserVo vo = userDao.getid(map);
		return vo;
	}
	@Override
	public UserVo getid2(HashMap<String, Object> map) {
		UserVo vo = userDao.getid2(map);
		return vo;
	}

	@Override
	public UserVo getuser_info(HashMap<String, Object> map) {
		UserVo vo = userDao.getuser_info(map);
		
		return vo;
	}

	@Override
	public UserVo find_pwd(HashMap<String, Object> map) {
		UserVo vo = userDao.find_pwd(map);
		return vo ;
	}


	@Override
	public void savePhoto(HashMap<String, Object> map, HttpServletRequest request) {
		ProFilePhoto.savePhoto(map,request);
		
		System.out.println(map);
		if(map.get("user_photo")!=null) {
			userDao.savePhoto(map);
		}
		
	}
	
	@Override
	public int attendanceCheckYn(HashMap<String, Object> map) {
		int result = userDao.attendanceCheckYn(map);
		return result;
	}
	
	@Override
	public void attendanceCheck(HashMap<String, Object> map) {
		userDao.attendanceCheck(map);
	}

	@Override
	public List<Map<String, Object>> attendanceTag(String userid) {
		List<Map<String, Object>> attendanceList = userDao.attendanceTag(userid);
		return attendanceList;
	}

	


}
