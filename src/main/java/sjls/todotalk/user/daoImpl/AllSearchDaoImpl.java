package sjls.todotalk.user.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.user.dao.AllSearchDao;
import sjls.todotalk.user.vo.UserVo;

@Repository("allSearchDao")
public class AllSearchDaoImpl implements AllSearchDao {

	@Autowired
	private  SqlSession  sqlSession; 
	
	@Override
	public List<UserVo> getTutorList(HashMap<String, Object> map) {
		map.put("tutorResult", sqlSession.selectList("user.GetTutorList",map)); //이거 안하는 방법 알아요?
		List<UserVo> tutorVo = (List<UserVo>) map.get("tutorResult");
		return tutorVo;
	}

	@Override
	public List<UserVo> getMentorList(HashMap<String, Object> map) {
		map.put("mentorResult", sqlSession.selectList("user.GetMentorList",map));
		List<UserVo> mentorVo = (List<UserVo>) map.get("mentorResult");
		return mentorVo;
	}

}
