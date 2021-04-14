package sjls.todotalk.user.serviceImpl;

import java.util.HashMap;

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


}
