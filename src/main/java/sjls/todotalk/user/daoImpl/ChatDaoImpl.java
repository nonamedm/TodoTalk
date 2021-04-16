package sjls.todotalk.user.daoImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.socket.TextMessage;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sjls.todotalk.user.dao.ChatDao;
import sjls.todotalk.user.vo.MessageVo;
import sjls.todotalk.user.vo.MessageVo.MessageType;

@Repository("chatDao")
public class ChatDaoImpl implements ChatDao {

	@Autowired
	private SqlSession sqlSession;
	//JSON -> String 변환 메소드
	ObjectMapper objectMapper = new ObjectMapper(); 
	
	@Override
	public String findChatRoom(HashMap<String, Object> createRoom) {
		String roomId = sqlSession.selectOne("talk.findChatRoom",createRoom);
		return roomId;
	}

	@Override
	public void createChatRoom(HashMap<String, Object> createRoom) {
		sqlSession.insert("talk.createChatRoom",createRoom);		//채팅 신청자가 만든 방과
		sqlSession.insert("talk.createChatRoom2",createRoom);		//상대방 입장의 방 동시에 2개를 만듦
		
	}

	@Override
	public void saveMessage(MessageVo messageVo) throws Exception {
		
		System.out.println("DB 저장할 messageVo값 : "+messageVo);	
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if(messageVo.getType().toString().equals("CHAT")) {
			map.put("messageVo", messageVo);
			sqlSession.insert("talk.saveMessage",map);
		}
	}

	@Override
	public List<MessageVo> loadAllMessage(String roomId) {
		List<MessageVo> loadMessage = sqlSession.selectList("talk.loadMessage",roomId);
		return loadMessage;
	}

	@Override
	public List<MessageVo> findRoomByLogin(String loginId) {
		List<MessageVo> findRoomByLogin = sqlSession.selectList("talk.findRoomByLogin",loginId);
		return findRoomByLogin;
	}

	@Override
	public void readMessage(MessageVo messageVo) {
		String roomId = messageVo.getRoomId();
		String sender = messageVo.getSender();		//내가 들어가는 사람이고, 나한테 온 메세지를 읽는거니까 sender
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("messageVo", messageVo);
		System.out.println("READCHECK : "+roomId+" : "+sender);
		sqlSession.update("talk.readMessage",map);
		
	}

	@Override
	public void nowConnect(MessageVo messageVo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("messageVo", messageVo);
		if(messageVo.getType().equals(MessageType.ENTER)) {
			sqlSession.update("talk.enterConnect",map);
		}
		if(messageVo.getType().equals(MessageType.LEAVE)) {
			sqlSession.update("talk.leaveConnect",map);
		}
		
	}

	


}
