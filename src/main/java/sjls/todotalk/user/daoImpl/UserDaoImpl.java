package sjls.todotalk.user.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.user.dao.UserDao;
import sjls.todotalk.user.vo.UserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// user 가입
	@Override
	public void insertUser(HashMap<String, Object> map) {
		sqlSession.insert("user.userinsert",map);
	}


	// user 로그인
	@Override
	public UserVo getUser(HashMap<String, Object> map) {
		UserVo vo =sqlSession.selectOne("user.userselect",map);
		System.out.println("dao : "+map);
		return vo;
	}


	// ajax  에서 아이디 중복확인
	@Override
	public UserVo getid(HashMap<String, Object> map) {
		UserVo  vo  =sqlSession.selectOne("user.userid",map);
		return vo;
	}
	// ajax  에서 아이디 중복확인
	@Override
	public UserVo getid2(HashMap<String, Object> map) {
		UserVo  vo  =sqlSession.selectOne("user.userid",map);
		return vo;
	}


	//user 정보 수정
	@Override
	public UserVo getuser_info(HashMap<String, Object> map) {
		UserVo vo = sqlSession.selectOne("user.userupdate",map);
		
		
		return vo;
	}


	//비밀번호 찾기
	@Override
	public UserVo find_pwd(HashMap<String, Object> map) {
		sqlSession.selectOne("user.find_pwd",map);
		UserVo vo = sqlSession.selectOne("user.userid", map); 
		return vo;
	}


	// 프로필 저장 DB
	@Override
	public void savePhoto(HashMap<String, Object> map) {
		sqlSession.insert("user.savephoto",map);
	}
	
	
	
	
	
	
	

}
