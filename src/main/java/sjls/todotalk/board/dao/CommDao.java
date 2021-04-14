package sjls.todotalk.board.dao;

import java.util.HashMap;
import java.util.List;

import sjls.todotalk.board.vo.CommBoardVo;
import sjls.todotalk.board.vo.CommFileVo;
import sjls.todotalk.board.vo.FreeBoardVo;

public interface CommDao {

	List<CommBoardVo> getCommList(HashMap<String, Object> map);

	CommBoardVo getCommRead(HashMap<String, Object> map);

	void CommWrite(HashMap<String, Object> map);

	void delete(HashMap<String, Object> map);

	List<CommFileVo> getFileList(HashMap<String, Object> map);

	void update(HashMap<String, Object> map);

}
