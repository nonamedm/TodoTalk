package sjls.todotalk.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sjls.todotalk.board.vo.FreeFileVo;
import sjls.todotalk.board.vo.FreeReplyVo;
import sjls.todotalk.board.vo.QnAReplyVo;

public interface RepDao {

	List<QnAReplyVo> getRepList(HashMap<String, Object> map);

	void repWrite(HashMap<String, Object> map, HttpServletRequest request);

	void repDelete(HashMap<String, Object> map);

	List<FreeReplyVo> getFreeRepList(HashMap<String, Object> map);

	void freeRepDelete(HashMap<String, Object> map);

	void FreeRepWrite(HashMap<String, Object> map, HttpServletRequest request);

}
