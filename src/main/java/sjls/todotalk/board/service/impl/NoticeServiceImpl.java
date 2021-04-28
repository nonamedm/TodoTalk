package sjls.todotalk.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjls.todotalk.board.dao.NoticeDao;
import sjls.todotalk.board.service.NoticeService;
import sjls.todotalk.board.vo.NoticeBoard;
import sjls.todotalk.util.Criteria;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<NoticeBoard>  getNoticeList(Criteria cri) {
		List<NoticeBoard>  getNoticeList = noticeDao.getNoticeList(cri);
		return getNoticeList;
	}

	@Override
	public int getNoticeListCount() {
		int result = noticeDao.getNoticeListCount();
		return result;
	}

	@Override
	public void noticeWrite(HashMap<String, Object> map) {
		noticeDao.noticeWrite(map);
		
	}

	@Override
	public HashMap<String, Object> getNoticeRead(int idx) {
		HashMap<String, Object> listOne = noticeDao.getNoticeRead(idx);
		return listOne;
	}

	@Override
	public void updateReadCount(int idx) {
		noticeDao.updateReadCount(idx);
		
	}

	@Override
	public void noticeUpdate(HashMap<String, Object> map) {
		noticeDao.noticeUpdate(map);
		
	}

	@Override
	public void noticeDelete(int idx) {
		noticeDao.noticeDelete(idx);
		
	}

	
}
