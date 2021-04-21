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
import sjls.todotalk.board.vo.QnAFileVo;

@Service("QnAService")
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	private QnADao qnaBoardDao;
	
	//게시판 목록 
	@Override
	public List<PdsVo> getQnAList(HashMap<String, Object> map) {
		
		// 게시글 목록 
		List<PdsVo> qnaList = qnaBoardDao.getQnAList(map);
		System.out.println("service에서 게시글 목록 값 "+ qnaList);
		
		//페이징 ----------------------------------------------------------
//		int pagetotalcount = 5;  //페이지 번호 갯수 (1~5번까지)
//		int pagecount  = (int) map.get("pagecount"); //조회된 결과 라인수
//		int nowpage    = (int) map.get("nowpage"); //현재 페이지
//		int pagegrpnum = (int) map.get("pagegrpnum"); // 한 페이지에 출력될 row(line) 수
//		int totalcount = countBoardListTotal();
		
		
		// 출력할 paging.jsp를 위힌 정보 준비
		BoardPaging bp = new BoardPaging();
		PdsVo vo = bp.getPdsPagingInfo();
		map.put("pagePdsVo", vo);
		System.out.println("service 목록 MAP: "+ map);
	
		return qnaList;
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
		
		qnaBoardDao.fileDelete(map);  //파일 삭제 
		qnaBoardDao.boardDelete(map); //게시글 삭제 
		
		//부모 자식 테이블로 되어있어서 
		//파일 테이블 먼저 삭제하고 게시판 테이블 삭제해야 삭제 됨 
		//아니면 foreign key 에러남 ﻿
	}
	
	//게시글 쓰기
	@Override
	public void getQnAWrite(HashMap<String, Object> map, HttpServletRequest request) {
		
		//파일 업로드
		PdsFile_QnA.save(map, request);
		
		//게시글 쓰기 
		QnABoardVo vo =qnaBoardDao.qnaWrite(map);
		//위에 쓴 게시글 정보 db에 저장
		int qna_idx = vo.getQna_idx();
		map.put("qna_idx",qna_idx);
		
		qnaBoardDao.fileWrite(map);
	}
	

	//게시글 수정
	@Override
	public void getQnAUpdate(HashMap<String, Object> map, HttpServletRequest request) {
		//파일 업로드
		//PdsFile_QnA.save(map, request);
		//게시글 text 수정
		qnaBoardDao.qnaUpdate(map);	
	}
	
	
	//파일 목록 
	@Override
	public List<QnAFileVo> getFileList(HashMap<String, Object> map) {
		
		List<QnAFileVo> fileList = qnaBoardDao.getFileList(map);
		return fileList;
	}
	
	//조회수 
	@Override
	public void readcount(HashMap<String, Object> map) {
		qnaBoardDao.readcount(map);
	}


}
