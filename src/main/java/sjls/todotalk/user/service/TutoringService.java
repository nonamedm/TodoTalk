package sjls.todotalk.user.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sjls.todotalk.user.vo.TuboVo;
import sjls.todotalk.user.vo.TureVo;
import sjls.todotalk.util.Criteria;

public interface TutoringService {
	
	//글쓰기 
	void insertWriting(HashMap<String, Object> map, HttpServletRequest request);

	List<TuboVo> getQuestion1List(HashMap<String, Object> map);

	TuboVo getView(HashMap<String, Object> map);

	List<TureVo> getReplyView(HashMap<String, Object> map);

	void insertReply(TureVo tureVo);

	List<TuboVo> getQuestion2List(HashMap<String, Object> map);

	int getListCount();

	List<TuboVo> getWritingList(HashMap<String, Object> map, Criteria cri);

}