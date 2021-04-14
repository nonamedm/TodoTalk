package sjls.todotalk.board.vo;

public class CommBoardVo {
	
	private String board_name;
	private int comm_idx;
	private String comm_title;
	private String comm_cont;
	private int user_idx;
	private String user_id;
	private String comm_regdate;
	private int comm_readcount;
	
	public CommBoardVo() {}
	public CommBoardVo(String board_name, int comm_idx, String comm_title, String comm_cont, int user_idx,
			String user_id, String comm_regdate, int comm_readcount) {
		this.board_name = board_name;
		this.comm_idx = comm_idx;
		this.comm_title = comm_title;
		this.comm_cont = comm_cont;
		this.user_idx = user_idx;
		this.user_id = user_id;
		this.comm_regdate = comm_regdate;
		this.comm_readcount = comm_readcount;
	}
	
	
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public int getComm_idx() {
		return comm_idx;
	}
	public void setComm_idx(int comm_idx) {
		this.comm_idx = comm_idx;
	}
	public String getComm_title() {
		return comm_title;
	}
	public void setComm_title(String comm_title) {
		this.comm_title = comm_title;
	}
	public String getComm_cont() {
		return comm_cont;
	}
	public void setComm_cont(String comm_cont) {
		this.comm_cont = comm_cont;
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
	public String getComm_regdate() {
		return comm_regdate;
	}
	public void setComm_regdate(String comm_regdate) {
		this.comm_regdate = comm_regdate;
	}
	public int getComm_readcount() {
		return comm_readcount;
	}
	public void setComm_readcount(int comm_readcount) {
		this.comm_readcount = comm_readcount;
	}
	
	
	@Override
	public String toString() {
		return "CommBoardVo [board_name=" + board_name + ", comm_idx=" + comm_idx + ", comm_title=" + comm_title
				+ ", comm_cont=" + comm_cont + ", user_idx=" + user_idx + ", user_id=" + user_id + ", comm_regdate="
				+ comm_regdate + ", comm_readcount=" + comm_readcount + "]";
	}
	

	

}
