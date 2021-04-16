package sjls.todotalk.user.vo;

public class MessageVo {
	
	public enum MessageType {
		ENTER, CHAT, LEAVE;
	}
	private MessageType type;
	private String roomId, sender, receiver, message;
	public MessageVo() {}
	public MessageVo(MessageType type, String roomId, String sender, String receiver, String message) {
		super();
		this.type = type;
		this.roomId = roomId;
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "MessageVo [type=" + type + ", roomId=" + roomId + ", sender=" + sender + ", receiver=" + receiver
				+ ", message=" + message + "]";
	}
	
}
