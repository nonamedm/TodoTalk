package sjls.todotalk.board.vo;

public class QNABoardVo {
	
	private String board_name;
	private int qna_idx;
	private String qna_title;
	private String qna_cont;
	private int user_idx;
	private String user_id;
	private String qna_regdate;
	private int qna_readcount;
	
	public QNABoardVo() {}
	public QNABoardVo(String board_name, int qna_idx, String qna_title, String qna_cont, int user_idx, String user_id,
			String qna_regdate, int qna_readcount) {
		super();
		this.board_name = board_name;
		this.qna_idx = qna_idx;
		this.qna_title = qna_title;
		this.qna_cont = qna_cont;
		this.user_idx = user_idx;
		this.user_id = user_id;
		this.qna_regdate = qna_regdate;
		this.qna_readcount = qna_readcount;
	}
	
	
	
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public int getQna_idx() {
		return qna_idx;
	}
	public void setQna_idx(int qna_idx) {
		this.qna_idx = qna_idx;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_cont() {
		return qna_cont;
	}
	public void setQna_cont(String qna_cont) {
		this.qna_cont = qna_cont;
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
	public String getQna_regdate() {
		return qna_regdate;
	}
	public void setQna_regdate(String qna_regdate) {
		this.qna_regdate = qna_regdate;
	}
	public int getQna_readcount() {
		return qna_readcount;
	}
	public void setQna_readcount(int qna_readcount) {
		this.qna_readcount = qna_readcount;
	}
	
	
	
	@Override
	public String toString() {
		return "QNABoardVo [board_name=" + board_name + ", qna_idx=" + qna_idx + ", qna_title=" + qna_title
				+ ", qna_cont=" + qna_cont + ", user_idx=" + user_idx + ", user_id=" + user_id + ", qna_regdate="
				+ qna_regdate + ", qna_readcount=" + qna_readcount + "]";
	}
	
	

}
