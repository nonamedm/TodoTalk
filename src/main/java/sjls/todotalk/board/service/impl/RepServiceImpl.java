package sjls.todotalk.board.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjls.todotalk.board.dao.RepDao;
import sjls.todotalk.board.service.RepService;
import sjls.todotalk.board.vo.QnAReplyVo;

@Service("RepService")
public class RepServiceImpl implements RepService {
	
	@Autowired
	private RepDao repDao;

	@Override
	public List<QnAReplyVo> getRepList(HashMap<String, Object> map) {
		
		List<QnAReplyVo> repList =  repDao.getRepList(map);
		return repList;
		
	}

	@Override
	public void repWrite(HashMap<String, Object> map, HttpServletRequest request) {
		repDao.repWrite(map,request);
		
	}

	@Override
	public void repDelete(HashMap<String, Object> map) {
		repDao.repDelete(map);
		
	}

}
