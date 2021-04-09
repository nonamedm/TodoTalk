package sjls.todotalk.user.service;

import java.util.HashMap;
import java.util.List;

import sjls.todotalk.user.vo.TuboVo;

public interface TutoringService {
	
	//글쓰기 
	void insertWriting(TuboVo vo);

	List <TuboVo> getWritingList(HashMap<String, Object> map);

}
