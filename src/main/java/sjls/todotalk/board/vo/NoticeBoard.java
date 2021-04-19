package sjls.todotalk.board.vo;

public class NoticeBoard {
	
	private String board_name;
	private int notice_idx;
	private String notice_title;
	private String notice_cont;
	private int user_idx;
	private String user_id;
	private String notice_regdate;
	private int notice_readcount;
	
	public NoticeBoard() {}
	public NoticeBoard(String board_name, int notice_idx, String notice_title, String notice_cont, int user_idx,
			String user_id, String notice_regdate, int notice_readcount) {
		super();
		this.board_name = board_name;
		this.notice_idx = notice_idx;
		this.notice_title = notice_title;
		this.notice_cont = notice_cont;
		this.user_idx = user_idx;
		this.user_id = user_id;
		this.notice_regdate = notice_regdate;
		this.notice_readcount = notice_readcount;
	}
	
	
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public int getNotice_idx() {
		return notice_idx;
	}
	public void setNotice_idx(int notice_idx) {
		this.notice_idx = notice_idx;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_cont() {
		return notice_cont;
	}
	public void setNotice_cont(String notice_cont) {
		this.notice_cont = notice_cont;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getNotice_regdate() {
		return notice_regdate;
	}
	public void setNotice_regdate(String notice_regdate) {
		this.notice_regdate = notice_regdate;
	}
	public int getNotice_readcount() {
		return notice_readcount;
	}
	public void setNotice_readcount(int notice_readcount) {
		this.notice_readcount = notice_readcount;
	}
	
	
	@Override
	public String toString() {
		return "NoticeBoard [board_name=" + board_name + ", notice_idx=" + notice_idx + ", notice_title=" + notice_title
				+ ", notice_cont=" + notice_cont + ", user_idx=" + user_idx + ", user_id=" + user_id
				+ ", notice_regdate=" + notice_regdate + ", notice_readcount=" + notice_readcount + "]";
	}
	

}
