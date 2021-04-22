package sjls.todotalk.board.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjls.todotalk.board.dao.FreeBoardDao;
import sjls.todotalk.board.service.FreeBoardService;
import sjls.todotalk.board.vo.FreeBoardVo;
import sjls.todotalk.board.vo.FreeFileVo;
import sjls.todotalk.util.Criteria;

@Service("BoardService")
public class FreeBoardServiceImpl implements FreeBoardService {
	
	@Autowired
	private FreeBoardDao boardDao;
	
	//페이징 리스트를 위한 총 게시글 수 
	@Override
	public int getListCount() {
		int result = boardDao.geteListCount();
		return result;
	}
	
	//페이징된 게시글 목록 
	@Override
	public List<FreeBoardVo> getFreeList(Criteria cri) {
		
		List<FreeBoardVo> getFreeList = boardDao.getFreeList(cri);
		return getFreeList;
	}
	
	//파일 목록 
	@Override
	public List<FreeFileVo> getFileList(HashMap<String, Object> map) {
		List<FreeFileVo> fileList = boardDao.getFileList(map);
		return fileList;
	}

	//게시글 조회 글 읽기
	@Override
	public FreeBoardVo getFreeRead(HashMap<String, Object> map) {
		
		FreeBoardVo freeBoardVo = boardDao.getFreeRead(map);
		return freeBoardVo;
	}
	
	//게시글 삭제 
	@Override
	public void boardDelete(HashMap<String, Object> map) {
		
		//파일 삭제 
		//댓글 삭제(전체)
		boardDao.boardDelete(map); //게시글 삭제 
		
		//부모 자식 테이블로 되어있어서 
		//파일,댓글 테이블 먼저 삭제하고 게시판 테이블 삭제해야 삭제 됨 
		//아니면 foreign key 에러남 
	}
	
	//게시글 쓰기
	@Override
	public void getFreeWrite(HashMap<String, Object> map, HttpServletRequest request) {
		// 파일 업로드 
		PdsFile_Free.save(map, request);
		//게시글 쓰기 
		FreeBoardVo vo = boardDao.freeWrite(map);
		
		//게시글 정보 db에 저장해서 파일 테이블에 글 번호 저장 
		int free_idx = vo.getFree_idx();
		map.put("free_idx", free_idx);
		//파일 쓰기
		boardDao.fileWrite(map);
		
	}
	
	//게시글 수정
	@Override
	public void getFreeUpdate(HashMap<String, Object> map, HttpServletRequest request) {
		
		boardDao.freeUpdate(map);
	}
	
	//조회수
	@Override
	public void readcount(HashMap<String, Object> map) {
		boardDao.readcount(map);
	}
	



	
}
