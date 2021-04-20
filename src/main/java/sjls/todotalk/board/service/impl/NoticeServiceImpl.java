package sjls.todotalk.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjls.todotalk.board.dao.NoticeDao;
import sjls.todotalk.board.service.NoticeService;
import sjls.todotalk.util.Criteria;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<Map<String, Object>> getNoticeList(Criteria cri) {
		List<Map<String, Object>> getNoticeList = noticeDao.getNoticeList(cri);
		return getNoticeList;
	}

	@Override
	public int getNoticeListCount() {
		int result = noticeDao.getNoticeListCount();
		return result;
	}

}
