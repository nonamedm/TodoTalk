package sjls.todotalk.board.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sjls.todotalk.board.vo.QnABoardVo;

public interface QnAService {

	List<QnABoardVo> getQnAList(HashMap<String, Object> map);

	QnABoardVo getQnARead(HashMap<String, Object> map);

	void boardDelete(HashMap<String, Object> map);

	void getQnAWrite(HashMap<String, Object> map, HttpServletRequest request);

	void getQnAUpdate(HashMap<String, Object> map, HttpServletRequest request);

}