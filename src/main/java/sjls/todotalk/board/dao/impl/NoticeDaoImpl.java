package sjls.todotalk.board.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.board.dao.NoticeDao;
import sjls.todotalk.util.Criteria;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Map<String, Object>> getNoticeList(Criteria cri) {
		List<Map<String, Object>> getNoticeList = sqlSession.selectList("notice.getNoticeList", cri);
		return getNoticeList;
	}

	@Override
	public int getNoticeListCount() {
		int result = sqlSession.selectOne("notice.getNoticeCount");
		return result;
	}

}
