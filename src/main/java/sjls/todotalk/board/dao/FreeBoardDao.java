package sjls.todotalk.board.dao;

import java.util.List;

import sjls.todotalk.board.vo.FreeBoardVo;

public interface FreeBoardDao {

	List<FreeBoardVo> getBoardList();

	FreeBoardVo getBoardCont(int free_idx);

	void deleteBoard(int free_idx);

	void insertBoard(FreeBoardVo vo);

	void updateBoard(FreeBoardVo vo);

}
