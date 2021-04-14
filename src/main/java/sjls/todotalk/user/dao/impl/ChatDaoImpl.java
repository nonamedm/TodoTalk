package sjls.todotalk.user.dao.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.user.dao.ChatDao;

@Repository("chatDao")
public class ChatDaoImpl implements ChatDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public String findChatRoom(HashMap<String, Object> createRoom) {
		String roomId = sqlSession.selectOne("Talk.findChatRoom",createRoom);
		return roomId;
	}

	@Override
	public void createChatRoom(HashMap<String, Object> createRoom) {
		sqlSession.insert("Talk.createChatRoom",createRoom);		//채팅 신청자가 만든 방과
		sqlSession.insert("Talk.createChatRoom2",createRoom);		//상대방 입장의 방 동시에 2개를 만듦
		
	}


}
