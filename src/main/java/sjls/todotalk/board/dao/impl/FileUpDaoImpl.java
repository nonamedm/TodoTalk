package sjls.todotalk.board.dao.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import sjls.todotalk.board.dao.FileUpDao;

public class FileUpDaoImpl implements FileUpDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void setWrite(HashMap<String, Object> map) {
		sqlSession.insert("CommBoard.fileWrite",map);
		
	}

}
