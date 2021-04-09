package sjls.todotalk.user.daoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.user.dao.TutoringDao;
import sjls.todotalk.user.vo.TuboVo;

@Repository
public class TutoringDaoImpl implements TutoringDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertWriting(TuboVo vo) {
		sqlSession.insert("tutoring.InsertWriting", vo);
	}

	@Override
	public List<TuboVo> getWritingList(HashMap<String, Object> map) {
		
		List <TuboVo> writingList = sqlSession.selectList("tutoring.TutoringList", map);
		
		return writingList;
	}


}
