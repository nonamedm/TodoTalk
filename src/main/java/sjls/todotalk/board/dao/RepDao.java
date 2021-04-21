package sjls.todotalk.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sjls.todotalk.board.vo.QnAReplyVo;

public interface RepDao {

	List<QnAReplyVo> getRepList(HashMap<String, Object> map);

	void repWrite(HashMap<String, Object> map, HttpServletRequest request);

	void repDelete(HashMap<String, Object> map);

}
