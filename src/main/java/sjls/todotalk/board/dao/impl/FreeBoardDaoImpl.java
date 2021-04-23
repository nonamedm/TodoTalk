package sjls.todotalk.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import sjls.todotalk.board.dao.FreeBoardDao;
import sjls.todotalk.board.vo.FreeBoardVo;
import sjls.todotalk.board.vo.FreeFileVo;
import sjls.todotalk.util.Criteria;

@Repository("boardDao")
public class FreeBoardDaoImpl implements FreeBoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	//총 게시글 수 
	@Override
	public int geteListCount() {
		int result = sqlSession.selectOne("freeBoard.getCount");
		return result;
	}

	//페이징된 게시글 목록
	@Override
	public List<FreeBoardVo> getFreeList(Criteria cri) {
		List<FreeBoardVo> getFreeList = sqlSession.selectList("freeBoard.freeList", cri);
		return getFreeList;
	}
	
	//파일 목록 
	@Override
	public List<FreeFileVo> getFileList(HashMap<String, Object> map) {
		List<FreeFileVo> fileList = sqlSession.selectList("freeBoard.fileList",map);
		return fileList;
	}
	
	//게시글 읽기 조회
	@Override
	public FreeBoardVo getFreeRead(HashMap<String, Object> map) {
		FreeBoardVo vo = sqlSession.selectOne("freeBoard.freeRead",map);
		return vo;
	}
	
	//게시글 삭제 
	@Override
	public void boardDelete(HashMap<String, Object> map) {
		
		
		sqlSession.delete("freeBoard.delete",map);//게시글 삭제 
	}
	
	//게시글 쓰기 
	@Override
	public FreeBoardVo freeWrite(HashMap<String, Object> map) {
		 sqlSession.insert("freeBoard.freeInsert",map);
		 FreeBoardVo vo = sqlSession.selectOne("freeBoard.getFree_idx",map); //게시글 번호 조회
		return vo;
		
	}
	//파일 쓰기
	@Override
	public void fileWrite(HashMap<String, Object> map) {
		sqlSession.insert("freeBoard.fileWrite",map);
	}
	//파일 삭제 
	@Override
	public void fileDelete(HashMap<String, Object> map) {
		sqlSession.delete("freeBoard.fileDelete",map);
	}
	
	//글 수정 
	@Override
	public void freeUpdate(HashMap<String, Object> map) {
		sqlSession.update("freeBoard.update",map);
		
	}
	
	//조회수
	@Override
	public void readcount(HashMap<String, Object> map) {
		sqlSession.update("freeBoard.readcount",map);
		
	}

	
	//댓글 전체 삭제(게시글이랑 같이)
	@Override
	public void repAllDelete(HashMap<String, Object> map) {
		sqlSession.delete("Reply.repAllDeleteF",map);
		
	}

	


	

	

	



}
