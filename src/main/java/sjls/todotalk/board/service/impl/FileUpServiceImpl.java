package sjls.todotalk.board.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;


import sjls.todotalk.board.dao.FileUpDao;
import sjls.todotalk.board.service.FileUpService;
import sjls.todotalk.board.vo.CommBoardVo;

public class FileUpServiceImpl implements FileUpService {
	
	@Autowired
	private FileUpDao fileupDao;
	
	@Override
	public void setWrite(HashMap<String, Object> map,
			HttpServletRequest request) {

		// 1. request 처리  - 넘어온 파일을 처리
	    PdsFile.save(map, request);
		
		// 2. 넘어온 정보 db 저장
	    fileupDao.setWrite(map); 
		
	}

}
