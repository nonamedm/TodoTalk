package sjls.todotalk.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjls.todotalk.board.dao.BoardDao;
import sjls.todotalk.board.service.BoardService;
import sjls.todotalk.board.vo.FreeBoardVo;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<FreeBoardVo> getBoardList() {
		
		List<FreeBoardVo> list = boardDao.getBoardList();
		return list;
	}
	
	@Override
	public FreeBoardVo getBoardCont(int free_idx) {
		FreeBoardVo vo = boardDao.getBoardCont(free_idx);
		return vo;
	}

	@Override
	public void deleteBoard(int free_idx) {
		boardDao.deleteBoard(free_idx);
		
	}

	@Override
	public void insertBoard(FreeBoardVo vo) {
		boardDao.insertBoard(vo);
		
	}

	
}
