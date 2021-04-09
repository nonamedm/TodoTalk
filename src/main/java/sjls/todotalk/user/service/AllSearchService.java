package sjls.todotalk.user.service;

import java.util.HashMap;
import java.util.List;

import sjls.todotalk.user.vo.UserVo;

public interface AllSearchService {

	List<UserVo> getTutorList(HashMap<String, Object> map);

	List<UserVo> getMentorList(HashMap<String, Object> map);

	List<HashMap<String, Object>> getBoardList(HashMap<String, Object> map);

}
