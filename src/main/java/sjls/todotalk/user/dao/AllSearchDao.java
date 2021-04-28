package sjls.todotalk.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sjls.todotalk.user.vo.RelationVo;
import sjls.todotalk.user.vo.UserVo;

public interface AllSearchDao {

	List<UserVo> getTutorList(HashMap<String, Object> map);

	List<UserVo> getMentorList(HashMap<String, Object> map);

	List<HashMap<String, Object>> getBoardList(HashMap<String, Object> map);

	UserVo getUserList(String receiver_id);

	String getPhotoName(String receiver_id);

	void relationCreate(Map<String, Object> map);

	List<RelationVo> getRelationList(String loginId);

	

}
