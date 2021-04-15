package sjls.todotalk.board.dao;

import java.util.HashMap;
import java.util.List;

import sjls.todotalk.board.vo.QnABoardVo;

public interface QnADao {

	List<QnABoardVo> getQnAList(HashMap<String, Object> map);

	QnABoardVo getQnARead(HashMap<String, Object> map);

	void boardDelete(HashMap<String, Object> map);

	void qnaWrite(HashMap<String, Object> map);

	void qnaUpdate(HashMap<String, Object> map);

}
