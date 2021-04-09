package sjls.todotalk.user.daoImpl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.user.dao.MentoringDao;
import sjls.todotalk.user.vo.TuboVo;

@Repository
public class MentoringDaoImpl implements MentoringDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertWriting(TuboVo vo) {
		sqlSession.insert(".InsertWriting", vo);
	}


}
