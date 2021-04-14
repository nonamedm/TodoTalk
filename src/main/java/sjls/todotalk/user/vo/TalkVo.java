package sjls.todotalk.user.vo;

public class TalkVo {
	private String room_id, receiver_id, require_id, chat_message;
	public TalkVo() {}
	public TalkVo(String room_id, String receiver_id, String require_id, String chat_message) {
		this.room_id = room_id;
		this.receiver_id = receiver_id;
		this.require_id = require_id;
		this.chat_message = chat_message;
	}
	public String getroom_id() {
		return room_id;
	}
	public void setroom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	public String getRequire_id() {
		return require_id;
	}
	public void setRequire_id(String require_id) {
		this.require_id = require_id;
	}
	public String getChat_message() {
		return chat_message;
	}
	public void setChat_message(String chat_message) {
		this.chat_message = chat_message;
	}
	@Override
	public String toString() {
		return "TalkVo [room_id=" + room_id + ", receiver_id=" + receiver_id + ", require_id=" + require_id
				+ ", chat_message=" + chat_message + "]";
	}
	
}
