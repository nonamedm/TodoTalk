package sjls.todotalk.board.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import sjls.todotalk.board.dao.QnADao;
import sjls.todotalk.board.service.QnAService;
import sjls.todotalk.board.vo.PdsVo;
import sjls.todotalk.board.vo.QnABoardVo;

@Service("QnAService")
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	private QnADao qnaBoardDao;
	
	//게시판 목록 
	@Override
	public List<PdsVo> getQnAList(HashMap<String, Object> map) {
		
		// 게시글 목록 
		List<PdsVo> qnaList = qnaBoardDao.getQnAList(map);
		System.out.println("contoroller list "+ qnaList);
		
		//페이징 ----------------------------------------------------------
		int pagetotalcount = 5;  //페이지 번호 갯수 (1~5번까지)
//		int pagecount  = (int) map.get("pagecount"); //조회된 결과 라인수
//		int nowpage    = (int) map.get("nowpage"); //현재 페이지
//		int pagegrpnum = (int) map.get("pagegrpnum"); // 한 페이지에 출력될 row(line) 수
//		int totalcount = countBoardListTotal();
		
		
		// 출력할 paging.jsp를 위힌 정보 준비
		BoardPaging bp = new BoardPaging();
		PdsVo vo = bp.getPdsPagingInfo();
		map.put("pagePdsVo", vo);
		
		
		return qnaList;
	}
	
	//총 게시글 수
	private int countBoardListTotal() {
		return qnaBoardDao.countBoardList();
	}

	//게시글 읽기
	@Override
	public QnABoardVo getQnARead(HashMap<String, Object> map) {
		//글 내용 읽기 
		QnABoardVo qnaBoardVo = qnaBoardDao.getQnARead(map);
		return qnaBoardVo;
	}
	
	//게시글 삭제 
	@Override
	public void boardDelete(HashMap<String, Object> map) {
		qnaBoardDao.boardDelete(map);
		
	}
	
	//게시글 쓰기
	@Override
	public void getQnAWrite(HashMap<String, Object> map, HttpServletRequest request) {
		
		//textarea에 text 글쓰기
		qnaBoardDao.qnaWrite(map);
		
	}
	
	//게시글 수정
	@Override
	public void getQnAUpdate(HashMap<String, Object> map, HttpServletRequest request) {
		//게시글 text 수정
		qnaBoardDao.qnaUpdate(map);
		
	}

	

}
