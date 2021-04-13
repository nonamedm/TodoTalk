package sjls.todotalk.user.vo;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

public class RoomVo {
	private String roomId;
	private String name;
	private Set<WebSocketSession> sessions = new HashSet<>();
	public RoomVo() {}
	public RoomVo(String roomId, String name, Set<WebSocketSession> sessions) {
		this.roomId = roomId;
		this.name = name;
		this.sessions = sessions;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<WebSocketSession> getSessions() {
		return sessions;
	}
	public void setSessions(Set<WebSocketSession> sessions) {
		this.sessions = sessions;
	}
	@Override
	public String toString() {
		return "RoomVo [roomId=" + roomId + ", name=" + name + ", sessions=" + sessions + "]";
	}
}
