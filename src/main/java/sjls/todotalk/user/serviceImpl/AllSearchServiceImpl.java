package sjls.todotalk.user.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjls.todotalk.user.dao.AllSearchDao;
import sjls.todotalk.user.service.AllSearchService;
import sjls.todotalk.user.vo.RelationVo;
import sjls.todotalk.user.vo.UserVo;

@Service("allSearchService")
public class AllSearchServiceImpl implements AllSearchService {

	@Autowired
	AllSearchDao allSearchDao;

	@Override
	public List<UserVo> getTutorList(HashMap<String, Object> map) {
		List<UserVo> tutorVo = allSearchDao.getTutorList(map);
		return tutorVo;
	}

	@Override
	public List<UserVo> getMentorList(HashMap<String, Object> map) {
		List<UserVo> mentorVo = allSearchDao.getMentorList(map);
		return mentorVo;
	}

	@Override
	public List<HashMap<String, Object>> getBoardList(HashMap<String, Object> map) {
		List<HashMap<String, Object>> boardAllSearch = allSearchDao.getBoardList(map);
		return boardAllSearch;
	}

	@Override
	public UserVo getUserList(String receiver_id) {
		UserVo userVo = allSearchDao.getUserList(receiver_id);
		return userVo;
	}

	@Override
	public String getPhotoName(String receiver_id) {
		String userPhoto = allSearchDao.getPhotoName(receiver_id);
		return userPhoto;
	}

	@Override
	public void relationCreate(Map<String, Object> map) {
		allSearchDao.relationCreate(map);
	}

	@Override
	public List<RelationVo> getRelationList(String loginId) {
		List<RelationVo> relationList = allSearchDao.getRelationList(loginId);
		return relationList;
	}

}
