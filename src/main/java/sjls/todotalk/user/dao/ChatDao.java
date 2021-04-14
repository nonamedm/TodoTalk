package sjls.todotalk.user.dao;

import java.util.HashMap;

public interface ChatDao {

	void createChatRoom(HashMap<String, Object> createRoom);

	String findChatRoom(HashMap<String, Object> createRoom);

}
