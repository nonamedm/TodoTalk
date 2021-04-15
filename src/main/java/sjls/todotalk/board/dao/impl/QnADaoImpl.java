package sjls.todotalk.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.board.dao.QnADao;
import sjls.todotalk.board.vo.QnABoardVo;

@Repository("QnABoardDao")
public class QnADaoImpl implements QnADao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//게시물 목록 조회
	@Override
	public List<QnABoardVo> getQnAList(HashMap<String, Object> map) {
		
		List<QnABoardVo> qnaList = sqlSession.selectList("QnABoard.qnaList",map);
		return qnaList;
	}
	
	//게시글 읽기
	@Override
	public QnABoardVo getQnARead(HashMap<String, Object> map) {
		
		QnABoardVo vo = sqlSession.selectOne("QnABoard.qnaRead",map);
		return vo;
	}
	
	//게시글 삭제 
	@Override
	public void boardDelete(HashMap<String, Object> map) {
		sqlSession.delete("QnABoard.delete",map);
	}
	
	//게시글 쓰기
	@Override
	public void qnaWrite(HashMap<String, Object> map) {
		
		sqlSession.insert("QnABoard.qnaWrite",map); //text 쓰기
		
	}

	@Override
	public void qnaUpdate(HashMap<String, Object> map) {
		sqlSession.update("QnABoard.qnaUpdate",map);
		
	}

}
