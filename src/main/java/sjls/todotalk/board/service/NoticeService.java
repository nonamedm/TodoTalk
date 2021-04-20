package sjls.todotalk.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface NoticeService {
	
	//공지사항 리스트 불러오기
	public List<Map<String, Object>> getNoticeList();
	
	
	
}
