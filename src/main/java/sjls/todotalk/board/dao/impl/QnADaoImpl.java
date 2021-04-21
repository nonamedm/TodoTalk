package sjls.todotalk.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.board.dao.QnADao;
import sjls.todotalk.board.vo.PdsVo;
import sjls.todotalk.board.vo.QnABoardVo;
import sjls.todotalk.board.vo.QnAFileVo;

@Repository("QnABoardDao")
public class QnADaoImpl implements QnADao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//게시물 목록 조회
	@Override
	public List<PdsVo> getQnAList(HashMap<String, Object> map) {
		
		List<PdsVo> qnaList = sqlSession.selectList("QnABoard.pagingList",map);
//		List<PdsVo> qnaList = sqlSession.selectList("QnABoard.qnaList",map);
		System.out.println(qnaList);
		//sqlSession.selectList("QnABoard.pagingList",map);
		
		return qnaList;
	}
	
	//총게시글 수 
	@Override
	public int countBoardList() {
		return sqlSession.selectOne("QnABoard.countBoardList");
	}
	
	//게시글 읽기
	@Override
	public QnABoardVo getQnARead(HashMap<String, Object> map) {
		
		QnABoardVo vo = sqlSession.selectOne("QnABoard.qnaRead",map);
		return vo;
	}
	
	//게시글 삭제 
	@Override
	public void boardDelete(HashMap<String, Object> map) {
		sqlSession.delete("QnABoard.delete",map);
	}
	
	//게시글 쓰기
	@Override
	public QnABoardVo qnaWrite(HashMap<String, Object> map) {
		
		sqlSession.insert("QnABoard.qnaWrite",map); //text 쓰기
		QnABoardVo vo = sqlSession.selectOne("QnABoard.getQna_Idx",map); //게시글 번호 조회
		return vo;
		
	}
	
	//게시글 수정 
	@Override
	public void qnaUpdate(HashMap<String, Object> map) {
		sqlSession.update("QnABoard.qnaUpdate",map);	
	}
	
	//파일 목록 조회
	@Override
	public List<QnAFileVo> getFileList(HashMap<String, Object> map) {
		List<QnAFileVo> fileList = sqlSession.selectList("QnABoard.fileList",map);
		return fileList;
	}
	
	//파일 삭제
	@Override
	public void fileDelete(HashMap<String, Object> map) {
		sqlSession.delete("QnABoard.FileDelete",map);
	}
	
	//파일 쓰기
	@Override
	public void fileWrite(HashMap<String, Object> map) {
		System.out.println("게시글 쓰기map:  "+map);
		sqlSession.insert("QnABoard.fileWrite",map); 
	}
	
	//조회수
	@Override
	public void readcount(HashMap<String, Object> map) {
		sqlSession.update("QnABoard.readcount",map);
	}
	




}
