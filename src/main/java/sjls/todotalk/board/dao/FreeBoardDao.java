package sjls.todotalk.board.dao;

import java.util.HashMap;
import java.util.List;

import sjls.todotalk.board.vo.FreeBoardVo;
import sjls.todotalk.board.vo.FreeFileVo;
import sjls.todotalk.util.Criteria;

public interface FreeBoardDao {

	int geteListCount();

	List<FreeBoardVo> getFreeList(Criteria cri);

	FreeBoardVo getFreeRead(HashMap<String, Object> map);

	void boardDelete(HashMap<String, Object> map);

	FreeBoardVo freeWrite(HashMap<String, Object> map);

	void freeUpdate(HashMap<String, Object> map);

	void readcount(HashMap<String, Object> map);

	List<FreeFileVo> getFileList(HashMap<String, Object> map);

	void fileWrite(HashMap<String, Object> map);



}
