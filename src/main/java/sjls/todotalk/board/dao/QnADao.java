package sjls.todotalk.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sjls.todotalk.board.vo.PdsVo;
import sjls.todotalk.board.vo.QnABoardVo;
import sjls.todotalk.board.vo.QnAFileVo;

public interface QnADao {

	List<PdsVo> getQnAList(HashMap<String, Object> map);

	QnABoardVo getQnARead(HashMap<String, Object> map);

	void boardDelete(HashMap<String, Object> map);

	QnABoardVo qnaWrite(HashMap<String, Object> map);

	void qnaUpdate(HashMap<String, Object> map);

	int countBoardList();

	List<QnAFileVo> getFileList(HashMap<String, Object> map);

	void fileDelete(HashMap<String, Object> map);

	void fileWrite(HashMap<String, Object> map);

	void readcount(HashMap<String, Object> map);

	void repAllDelete(HashMap<String, Object> map);



}
