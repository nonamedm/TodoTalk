package sjls.todotalk.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.TextMessage;

import sjls.todotalk.user.vo.MessageVo;

public interface ChatDao {

	void createChatRoom(HashMap<String, Object> createRoom);

	String findChatRoom(HashMap<String, Object> createRoom);

	void saveMessage(MessageVo messageVo) throws Exception;

	List<MessageVo> loadAllMessage(String roomId);

	List<MessageVo> findRoomByLogin(String loginId);

	void readMessage(MessageVo messageVo);

	void nowConnect(MessageVo messageVo);

	int alertCount(String loginId);

	int findNewMessage(Map<String, Object> map);

}
