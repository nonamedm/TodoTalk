package sjls.todotalk.board.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartRequest;

import sjls.todotalk.board.dao.CommDao;
import sjls.todotalk.board.service.CommService;
import sjls.todotalk.board.vo.CommBoardVo;
import sjls.todotalk.board.vo.CommFileVo;
import sjls.todotalk.board.vo.FreeBoardVo;

@Service("CommService")
public class CommServiceImpl implements CommService {
	
	@Autowired
	private CommDao commDao;

	@Override
	public List<CommBoardVo> getCommList(HashMap<String, Object> map) {
		//나중에 여기다가 페이징
		//목록 불러오기 
		List<CommBoardVo> commList = commDao.getCommList(map);

		return commList;
	}

	@Override
	public CommBoardVo getCommRead(HashMap<String, Object> map) {
		CommBoardVo commBoardVo = commDao.getCommRead(map);
		return commBoardVo;
	}

	@Override
	public void getCommWrite(HashMap<String, Object> map, HttpServletRequest request) {
		//파일처리
	    PdsFile_Free.save(map, request);
		
		//게시글 쓰기
		commDao.CommWrite(map);
		
	}

	@Override
	public void delete(HashMap<String, Object> map) {
		commDao.delete(map);
		
	}

	@Override
	public List<CommFileVo> getFileList(HashMap<String, Object> map) {
		List<CommFileVo> fileList = commDao.getFileList(map);
		return fileList;
	}

	@Override
	public void update(HashMap<String, Object> map, HttpServletRequest request) {
		PdsFile_Free.save(map, request);
		commDao.update(map);

	}


}
