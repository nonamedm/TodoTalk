package sjls.todotalk.board.vo;

public class FreeBoardVo {
	
	private String board_name;
	private int free_idx;      //글 번호 
	private String free_title; //글 제목
	private String free_cont;  //글 내용
	private int user_idx; 
	private String user_id;    //사용자
	private String free_regdate; //작성일 
	private int free_readcount; //조회수
	
	public FreeBoardVo(){}
	public FreeBoardVo(String board_name, int free_idx, String free_title, String free_cont, int user_idx,
			String user_id, String free_regdate, int free_readcount) {
		this.board_name = board_name;
		this.free_idx = free_idx;
		this.free_title = free_title;
		this.free_cont = free_cont;
		this.user_idx = user_idx;
		this.user_id = user_id;
		this.free_regdate = free_regdate;
		this.free_readcount = free_readcount;
	}
	
	
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public int getFree_idx() {
		return free_idx;
	}
	public void setFree_idx(int free_idx) {
		this.free_idx = free_idx;
	}
	public String getFree_title() {
		return free_title;
	}
	public void setFree_title(String free_title) {
		this.free_title = free_title;
	}
	public String getFree_cont() {
		return free_cont;
	}
	public void setFree_cont(String free_cont) {
		this.free_cont = free_cont;
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
	public String getFree_regdate() {
		return free_regdate;
	}
	public void setFree_regdate(String free_regdate) {
		this.free_regdate = free_regdate;
	}
	public int getFree_readcount() {
		return free_readcount;
	}
	public void setFree_readcount(int free_readcount) {
		this.free_readcount = free_readcount;
	}
	
	
	
	@Override
	public String toString() {
		return "FreeBoardVo [board_name=" + board_name + ", free_idx=" + free_idx + ", free_title=" + free_title
				+ ", free_cont=" + free_cont + ", user_idx=" + user_idx + ", user_id=" + user_id + ", free_regdate="
				+ free_regdate + ", free_readcount=" + free_readcount + "]";
	}
	

	

}
