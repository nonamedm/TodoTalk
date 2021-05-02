
package sjls.todotalk.user.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sjls.todotalk.user.vo.TuboVo;
import sjls.todotalk.user.vo.TureVo;
import sjls.todotalk.util.Criteria;

public interface TutoringDao {
	
	TuboVo insertWriting(HashMap<String, Object> map);
 
	List<TuboVo> getWritingList(HashMap<String, Object> map, Criteria cri);

	List<TuboVo> getQuestion1List(HashMap<String, Object> map);

	TuboVo getView(HashMap<String, Object> map);

	List<TureVo> getReplyView(HashMap<String, Object> map);

	void insertReply(TureVo tureVo);

	List<TuboVo> getQuestion2List(HashMap<String, Object> map);

	int getListCount();

	void fileWrite(HashMap<String, Object> map);

}
