package sjls.todotalk.user.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjls.todotalk.user.dao.TutoringDao;
import sjls.todotalk.user.service.TutoringService;
import sjls.todotalk.user.vo.TuboVo;

@Service
public class TutoringServiceImpl implements TutoringService {
	
	@Autowired 
	private TutoringDao mentoringDao;

	@Override
	public void insertWriting(TuboVo vo) {
		
		mentoringDao.insertWriting(vo);
	}

	@Override
	public List<TuboVo> getWritingList(HashMap<String, Object> map) {
		
		List<TuboVo> writingList = mentoringDao.getWritingList(map);
		
		return writingList;
	}
	

}
