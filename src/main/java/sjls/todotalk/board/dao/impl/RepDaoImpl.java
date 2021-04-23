package sjls.todotalk.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.board.dao.RepDao;
import sjls.todotalk.board.vo.FreeFileVo;
import sjls.todotalk.board.vo.FreeReplyVo;
import sjls.todotalk.board.vo.QnAReplyVo;

@Repository("RepDao")
public class RepDaoImpl implements RepDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//QnA
	@Override
	public List<QnAReplyVo> getRepList(HashMap<String, Object> map) {
		List<QnAReplyVo> repList = sqlSession.selectList("Reply.repList",map);
		return repList;
	}

	@Override
	public void repWrite(HashMap<String, Object> map, HttpServletRequest request) {
		sqlSession.insert("Reply.repWrite",map);
		
	}

	@Override
	public void repDelete(HashMap<String, Object> map) {
		sqlSession.delete("Reply.repDelete",map);
		
	}

	
	//Free
	@Override
	public List<FreeReplyVo> getFreeRepList(HashMap<String, Object> map) {
		List<FreeReplyVo> repList = sqlSession.selectList("Reply.repListF",map);
		return repList;
	}


	@Override
	public void freeRepDelete(HashMap<String, Object> map) {
		sqlSession.delete("Reply.repDeleteF",map);

	}

	@Override
	public void FreeRepWrite(HashMap<String, Object> map, HttpServletRequest request) {
		sqlSession.insert("Reply.repWriteF",map);
		
	}

}
