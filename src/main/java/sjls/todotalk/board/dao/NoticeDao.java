package sjls.todotalk.board.dao;

import java.util.List;
import java.util.Map;

import sjls.todotalk.board.vo.NoticeBoard;
import sjls.todotalk.util.Criteria;

public interface NoticeDao {
	
	//공지사항 리스트
	public List<NoticeBoard> getNoticeList(Criteria cri);

	//게시물 총 갯수
	public int getNoticeListCount();
	
	
}
