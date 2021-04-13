package com.green.join.handler;

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

import com.green.join.service.ChatRoomRepository;
import com.green.join.vo.MessageVo;
import com.green.join.vo.RoomVo;
import com.green.join.vo.MessageVo.MessageType;

@RequestMapping("/chat")
public class EchoHandler extends TextWebSocketHandler {
	
	private String roomId;
	private String name;
	private List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();
//	private Set<WebSocketSession> sessions = new HashSet<WebSocketSession>();
	
	@Autowired
	private ChatRoomRepository chatRoomRepository;
	
	ObjectMapper objectMapper = new ObjectMapper();					// Java Object -> String 변환 메소드
	
	//로그 (아직 잘 모르겠음)
	private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	
		    
    //클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행 (type : ENTER, TALK, LEAVE)
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());
        String msg = message.getPayload();
        System.out.println("메세지 도착 : "+msg);
        
        //System.out.println("출력테스트"+objectMapper.readValue(msg, MessageVo.class)); //확인
        MessageVo messageVo = objectMapper.readValue(msg, MessageVo.class);   
        
        RoomVo roomVo = chatRoomRepository.findRoomById(messageVo.getRoomId());
        chatRoomRepository.handleActions(session, messageVo, objectMapper);
        //handleActions(session, messageVo, objectMapper);
    }

	private void sendMessage(MessageVo messageVo, ObjectMapper objectMapper) throws IOException {
		TextMessage textMessage = new TextMessage(objectMapper.writeValueAsString(messageVo.getMessage()));
		for(WebSocketSession sess : sessions) {
			sess.sendMessage(textMessage);
		}
	}


}

