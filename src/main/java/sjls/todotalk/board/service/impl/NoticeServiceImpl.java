package sjls.todotalk.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public void noticeWrite(HashMap<String, Object> map, HttpServletRequest req) {
		
		//파일 업로드
		PdsFile_QnA.save(map, req);
		
		//게시글 쓰기
		HashMap<String, Object> vo = noticeDao.noticeWrite(map);
		
		int notice_idx = (int) vo.get("NOTICE_IDX");
		
		System.out.println("service : "+ map);
		System.out.println("notice_idx : "+ notice_idx);
		map.put("notice_idx", notice_idx);
		
		//파일쓰기
		noticeDao.fileWrite(map);
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
