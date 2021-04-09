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
	private TutoringDao tutoringDao;

	@Override
	public void insertWriting(TuboVo vo) {
		
		tutoringDao.insertWriting(vo);
	}

	@Override
	public List<TuboVo> getWritingList(HashMap<String, Object> map) {
		
		List<TuboVo> writingList = tutoringDao.getWritingList(map);
		
		return writingList;
	}

	@Override
	public List<TuboVo> getQuestion1List(HashMap<String, Object> map) {
		
		List<TuboVo> question1List = tutoringDao.getQuestion1List(map);
		
		return question1List;
	}

	@Override
	public TuboVo getView(HashMap<String, Object> map) {
		TuboVo tuboVo = tutoringDao.getView(map);
		return tuboVo;
	}
	

}
