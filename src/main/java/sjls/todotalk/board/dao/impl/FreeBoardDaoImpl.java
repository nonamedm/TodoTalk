package sjls.todotalk.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import sjls.todotalk.board.dao.FreeBoardDao;
import sjls.todotalk.board.vo.FreeBoardVo;

@Repository("boardDao")
public class FreeBoardDaoImpl implements FreeBoardDao {
	
	@Autowired
	private  SqlSession sqlSession;

	@Override
	public List<FreeBoardVo> getBoardList() {
		List<FreeBoardVo> list = sqlSession.selectList("freeBoard.freeList");
		return list;
	}

	@Override
	public FreeBoardVo getBoardCont(int free_idx) {
		FreeBoardVo vo = sqlSession.selectOne("freeBoard.read",free_idx);
		
		return vo;
	}

	@Override
	public void deleteBoard(int free_idx) {
		sqlSession.delete("freeBoard.delete",free_idx);
		
	}

	@Override
	public void insertBoard(FreeBoardVo vo) {
		sqlSession.insert("freeBoard.insert",vo);
		
	}

	@Override
	public void updateBoard(FreeBoardVo vo) {
		sqlSession.update("freeBoard.update",vo);
	}

}
