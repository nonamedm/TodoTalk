package sjls.todotalk.user.daoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.user.dao.MentorSchDao;

@Repository
public class MentorSchDaoImpl implements MentorSchDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Map<String, Object>> getMentorList(String mentorSearch) {
		
		List<Map<String, Object>> mentorList = sqlSession.selectList("mentorSearch.getMentorSchList", mentorSearch);
		return mentorList;
	}

}
