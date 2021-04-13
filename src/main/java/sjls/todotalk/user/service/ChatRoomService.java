package sjls.todotalk.user.service;

import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import sjls.todotalk.user.vo.MessageVo;
import sjls.todotalk.user.vo.RoomVo;

public interface ChatRoomService {

	RoomVo createRoomById(String id);

	void handleActions(WebSocketSession session, MessageVo messageVo, ObjectMapper objectMapper);

	Object findAllRoom();

	RoomVo findRoomById(String roomId);

}
