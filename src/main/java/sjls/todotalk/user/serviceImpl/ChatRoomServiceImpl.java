package sjls.todotalk.user.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sjls.todotalk.user.service.ChatRoomService;
import sjls.todotalk.user.vo.MessageVo;
import sjls.todotalk.user.vo.MessageVo.MessageType;
import sjls.todotalk.user.vo.RoomVo;

@Service("chatRoomService")
public class ChatRoomServiceImpl implements ChatRoomService {
	
	private Map<String, RoomVo> chatRooms = new HashMap<String, RoomVo>();
	private List<HashMap<String,Object>> sessions = new ArrayList<>();
	
	@Override
	public RoomVo createRoomById(String id) {
		RoomVo roomVo = new RoomVo();
		roomVo.setRoomId(id);						//클릭한 상대방 id를 방번호로 채팅방 개설
		chatRooms.put(roomVo.getRoomId(), roomVo);
		
		return roomVo;
	}
	@Override
	public Object findAllRoom() {
		return chatRooms.values();
	}
	
	@Override
	public RoomVo findRoomById(String roomId) {
		return chatRooms.get(roomId);
	}

	@Override
	public void handleActions(WebSocketSession session, MessageVo messageVo, ObjectMapper objectMapper) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(messageVo.getType().equals(MessageType.ENTER)) {
			map.put("roomNumber", messageVo.getRoomId());
			map.put("session", session);
			sessions.add(map);
			
			messageVo.setMessage(messageVo.getSender() + " 님이 입장하셨습니다.");
			
		} else if (messageVo.getType().equals(MessageType.LEAVE)) {
			
			map.put("roomNumber",messageVo.getRoomId());
			map.put("session",session);
			sessions.remove(map);						// 나갈때 그 세션 지운다
			messageVo.setMessage(messageVo.getSender() + " 님이 퇴장하셨습니다.");
			System.out.println("남은 세션 수 : "+sessions.size());
			
		} else {
			messageVo.setMessage(messageVo.getSender()+" : "+messageVo.getMessage());
		}
		try {
			TextMessage textMessage = new TextMessage(objectMapper.writeValueAsString(messageVo.getMessage()));		// 
			String roomNumber = messageVo.getRoomId(); //지금 메세지 보낸 사람의 방번호 : messageVo.getRoomId();
			for (int i = 0; i < sessions.size(); i++) {
				// 메세지 가야 할 방번호 : for문 돌려서 이거랑 같은 곳 모두 보내기
				if(roomNumber.equals(sessions.get(i).get("roomNumber"))) {
					//System.out.println( "세션 출력테스트 : "+sessions.get(i).get("session")); 확인
					WebSocketSession sess = (WebSocketSession) sessions.get(i).get("session");
					sess.sendMessage(textMessage);
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
