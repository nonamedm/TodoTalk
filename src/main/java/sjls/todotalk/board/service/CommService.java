package sjls.todotalk.board.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartRequest;

import sjls.todotalk.board.vo.CommBoardVo;
import sjls.todotalk.board.vo.CommFileVo;
import sjls.todotalk.board.vo.FreeBoardVo;

public interface CommService {

	List<CommBoardVo> getCommList(HashMap<String, Object> map);

	CommBoardVo getCommRead(HashMap<String, Object> map);

	void getCommWrite(HashMap<String, Object> map, HttpServletRequest request);

	void delete(HashMap<String, Object> map);

	List<CommFileVo> getFileList(HashMap<String, Object> map);

	void update(HashMap<String, Object> map, HttpServletRequest request);




	
}
