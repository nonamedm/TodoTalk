package sjls.todotalk.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjls.todotalk.user.dao.MentoringDao;
import sjls.todotalk.user.service.MentoringService;
import sjls.todotalk.user.vo.TuboVo;

@Service
public class MentoringServiceImpl implements MentoringService {
	
	@Autowired
	private MentoringDao mentoringDao;

	@Override
	public void insertWriting(TuboVo vo) {
		
		
	}
	

}
