package sjls.todotalk.user.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjls.todotalk.user.dao.AllSearchDao;
import sjls.todotalk.user.service.AllSearchService;
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

}
