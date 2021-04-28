package sjls.todotalk.board.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.board.dao.NoticeDao;
import sjls.todotalk.board.vo.NoticeBoard;
import sjls.todotalk.util.Criteria;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<NoticeBoard> getNoticeList(Criteria cri) {
		List<NoticeBoard> getNoticeList = sqlSession.selectList("notice.getNoticeList", cri);
		return getNoticeList;
	}

	@Override
	public int getNoticeListCount() {
		int result = sqlSession.selectOne("notice.getNoticeCount");
		return result;
	}

	@Override
	public void noticeWrite(HashMap<String, Object> map) {
		sqlSession.insert("notice.noticeWrite", map);
		
	}

	@Override
	public HashMap<String, Object> getNoticeRead(int idx) {
		HashMap<String, Object> listOne = sqlSession.selectOne("notice.getNoticeRead", idx);
		return listOne;
	}

	@Override
	public void updateReadCount(int idx) {
		sqlSession.update("notice.updateReadCount", idx);
		
	}

	@Override
	public void noticeUpdate(HashMap<String, Object> map) {
		sqlSession.update("notice.noticeUpdate", map);
		
	}

	@Override
	public void noticeDelete(int idx) {
		sqlSession.delete("notice.noticeDelete", idx);
		
	}

}
