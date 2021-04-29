package sjls.todotalk.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import sjls.todotalk.board.vo.NoticeBoard;
import sjls.todotalk.util.Criteria;


public interface NoticeService {
	
	//공지사항 리스트 불러오기
	public List<NoticeBoard> getNoticeList(Criteria cri);
	
	//게시물 총 갯수
	public int getNoticeListCount();
	
	//공지사항 글쓰기
	public void noticeWrite(HashMap<String, Object> map, HttpServletRequest req);
	
	//공지사항 글 읽기
	public HashMap<String, Object> getNoticeRead(int idx);
	
	//해당글 조회수 올리기
	public void updateReadCount(int idx);
	
	//공지사항 수정
	public void noticeUpdate(HashMap<String, Object> map);
	
	//공지사항 글 삭제
	public void noticeDelete(int idx);
	
	
}
