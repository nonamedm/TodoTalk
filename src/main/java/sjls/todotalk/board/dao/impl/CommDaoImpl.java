package sjls.todotalk.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.board.dao.CommDao;
import sjls.todotalk.board.vo.CommBoardVo;
import sjls.todotalk.board.vo.CommFileVo;
import sjls.todotalk.board.vo.FreeBoardVo;

@Repository("CommDao")
public class CommDaoImpl implements CommDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//게시물 리스트
	@Override
	public List<CommBoardVo> getCommList(HashMap<String, Object> map) {
		List<CommBoardVo> commList =  sqlSession.selectList("CommBoard.CommList",map);
	    //(List<CommBoardVo>) map.get("result");
		
		return commList;
	}
	
	//파일 리스트 
	@Override
	public List<CommFileVo> getFileList(HashMap<String, Object> map) {
		List<CommFileVo> fileList = sqlSession.selectList("CommBoard.fileList",map);
		return fileList;
	}
	
	@Override
	public CommBoardVo getCommRead(HashMap<String, Object> map) {
//		sqlSession.selectList("CommBoard.CommRead",map);
//		List<CommBoardVo> commList = (List<CommBoardVo>) map.get("result");
//		CommBoardVo commBoardVo = commList.get(0);
		CommBoardVo vo =  sqlSession.selectOne("CommBoard.CommRead",map);
	
		return vo;

	}

	@Override
	public void CommWrite(HashMap<String, Object> map) {
		System.out.println("dao "+map);
		sqlSession.insert("CommBoard.CommWrite",map);
		sqlSession.insert("CommBoard.fileWrite",map);
		
	}

	@Override
	public void delete(HashMap<String, Object> map) {
		sqlSession.delete("CommBoard.delete",map);
		
	}

	@Override
	public void update(HashMap<String, Object> map) {
		sqlSession.update("CommBoard.CommUpdate",map);
		
	}




}
