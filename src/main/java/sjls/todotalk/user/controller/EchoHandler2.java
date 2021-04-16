package sjls.todotalk.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sjls.todotalk.user.service.ChatRoomService;
import sjls.todotalk.user.vo.MessageVo;
import sjls.todotalk.user.vo.RoomVo;
import sjls.todotalk.user.vo.MessageVo.MessageType;

@RequestMapping("/chat2")
public class EchoHandler2 extends TextWebSocketHandler {
	
	private String roomId, name;
	private List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();
	
	@Autowired
	private ChatRoomService chatRoomService;

	//JSON -> String 변환 메소드
	ObjectMapper objectMapper = new ObjectMapper(); 
	
	//로그 (아직 잘 모르겠음)
	private static Logger logger = LoggerFactory.getLogger(EchoHandler2.class);
	
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());
		String msg = message.getPayload();
		System.out.println("도착한 메세지 : "+msg);
		
		MessageVo messageVo = objectMapper.readValue(msg, MessageVo.class);
		
		chatRoomService.handleActions(session, messageVo, objectMapper);
	}
	

}

