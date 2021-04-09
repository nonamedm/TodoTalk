package sjls.todotalk.user.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjls.todotalk.user.dao.MentorSchDao;
import sjls.todotalk.user.service.MentorSchService;

@Service
public class MentorSchServiceImpl implements MentorSchService {
	
	@Autowired
	private MentorSchDao mentorSchDao;
	
	@Override
	public List<Map<String, Object>> getMentorList(String mentorSearch) {
		
		List<Map<String, Object>> mentorList = mentorSchDao.getMentorList(mentorSearch);
		return mentorList;
	}

}
