package sjls.todotalk.user.service;

import java.util.List;

import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import sjls.todotalk.user.vo.MessageVo;
import sjls.todotalk.user.vo.RoomVo;

public interface ChatRoomService {

	RoomVo createRoomById(String id1, String id2);

	void handleActions(WebSocketSession session, MessageVo messageVo, ObjectMapper objectMapper) throws Exception;

	Object findAllRoom();

	RoomVo findRoomById(String roomId);

	List<MessageVo> loadAllMessage(String roomId);

	List<MessageVo> findRoomByLogin(String loginId);

	int alertCount(String loginId);

}
