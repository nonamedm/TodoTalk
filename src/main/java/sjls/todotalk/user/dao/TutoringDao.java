package sjls.todotalk.user.dao;

import java.util.HashMap;
import java.util.List;

import sjls.todotalk.user.vo.TuboVo;

public interface TutoringDao {
	
	void insertWriting(TuboVo vo);
 
	List<TuboVo> getWritingList(HashMap<String, Object> map);

	List<TuboVo> getQuestion1List(HashMap<String, Object> map);

	TuboVo getView(HashMap<String, Object> map);
}
