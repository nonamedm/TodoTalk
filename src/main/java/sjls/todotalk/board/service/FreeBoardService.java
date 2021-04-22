package sjls.todotalk.board.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sjls.todotalk.board.vo.FreeBoardVo;
import sjls.todotalk.board.vo.FreeFileVo;
import sjls.todotalk.util.Criteria;

public interface FreeBoardService {

	int getListCount();

	List<FreeBoardVo> getFreeList(Criteria cri);

	FreeBoardVo getFreeRead(HashMap<String, Object> map);

	void boardDelete(HashMap<String, Object> map);

	void getFreeWrite(HashMap<String, Object> map, HttpServletRequest request);

	void getFreeUpdate(HashMap<String, Object> map, HttpServletRequest request);

	void readcount(HashMap<String, Object> map);

	List<FreeFileVo> getFileList(HashMap<String, Object> map);

	
}
