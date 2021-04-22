package sjls.todotalk.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import sjls.todotalk.board.vo.NoticeBoard;
import sjls.todotalk.util.Criteria;


public interface NoticeService {
	
	//공지사항 리스트 불러오기
	public List<NoticeBoard> getNoticeList(Criteria cri);
	
	//게시물 총 갯수
	public int getNoticeListCount();
}
