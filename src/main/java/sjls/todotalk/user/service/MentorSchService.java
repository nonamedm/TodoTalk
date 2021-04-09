package sjls.todotalk.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MentorSchService {
	
	//멘토검색기능
	public List<Map<String, Object>> getMentorList(String mentorSearch);
	
	//멘토정보기능
	public HashMap<String, Object> getMentorInfo(String userid);
	
	
	
	
}
