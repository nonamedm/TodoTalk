package sjls.todotalk.user.daoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.user.dao.TutoringDao;
import sjls.todotalk.user.vo.TuboVo;
import sjls.todotalk.user.vo.TureVo;
import sjls.todotalk.util.Criteria;

@Repository
public class TutoringDaoImpl implements TutoringDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override 
	public void insertWriting(TuboVo vo) {
		sqlSession.insert("tutoring.InsertWriting", vo);
	}
 
	@Override
	public List<TuboVo> getWritingList(HashMap<String, Object> map, Criteria cri) {
		List <TuboVo> writingList = sqlSession.selectList("tutoring.TutoringList", cri);
		return writingList;
	}

	@Override
	public List<TuboVo> getQuestion1List(HashMap<String, Object> map) {
		List <TuboVo> question1List = sqlSession.selectList("tutoring.Question1List", map);	
		return question1List;
	}

	@Override
	public List<TuboVo> getQuestion2List(HashMap<String, Object> map) {
		List <TuboVo> question2List = sqlSession.selectList("tutoring.Question2List", map);	
		return question2List;
	}
	
	@Override
	public TuboVo getView(HashMap<String, Object> map) {
		List<TuboVo> writingList = sqlSession.selectList("tutoring.ViewWriting", map);
		
		TuboVo vo = new TuboVo();	
		
		if( writingList.size() != 0 ) {
				vo = writingList.get(0);
			}	
		return vo;
	}

	@Override
	public List<TureVo> getReplyView(HashMap<String, Object> map) {
		List<TureVo> replyList = sqlSession.selectList("tutoring.ViewReply", map);
		return replyList;
	}

	@Override
	public void insertReply(TureVo tureVo) {
		sqlSession.insert("tutoring.InsertReply", tureVo);
		
	}

	@Override
	public int getListCount() {
		int result = sqlSession.selectOne("tutoring.getCount");
		return result;
	}



}
