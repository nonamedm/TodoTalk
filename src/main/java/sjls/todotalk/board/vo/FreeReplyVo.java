package sjls.todotalk.board.vo;

public class FreeReplyVo {
	
	private int free_idx;
	private int free_re_idx;
	private String free_re_title;
	private String free_re_cont;
	private String user_id;
	private String free_re_regdate;
	
	public FreeReplyVo() {}
	public FreeReplyVo(int free_idx, int free_re_idx, String free_re_title, String free_re_cont, String user_id,
			String free_re_regdate) {
		super();
		this.free_idx = free_idx;
		this.free_re_idx = free_re_idx;
		this.free_re_title = free_re_title;
		this.free_re_cont = free_re_cont;
		this.user_id = user_id;
		this.free_re_regdate = free_re_regdate;
	}
	
	
	public int getFree_idx() {
		return free_idx;
	}
	public void setFree_idx(int free_idx) {
		this.free_idx = free_idx;
	}
	public int getFree_re_idx() {
		return free_re_idx;
	}
	public void setFree_re_idx(int free_re_idx) {
		this.free_re_idx = free_re_idx;
	}
	public String getFree_re_title() {
		return free_re_title;
	}
	public void setFree_re_title(String free_re_title) {
		this.free_re_title = free_re_title;
	}
	public String getFree_re_cont() {
		return free_re_cont;
	}
	public void setFree_re_cont(String free_re_cont) {
		this.free_re_cont = free_re_cont;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFree_re_regdate() {
		return free_re_regdate;
	}
	public void setFree_re_regdate(String free_re_regdate) {
		this.free_re_regdate = free_re_regdate;
	}
	
	
	@Override
	public String toString() {
		return "FreeReplyVo [free_idx=" + free_idx + ", free_re_idx=" + free_re_idx + ", free_re_title=" + free_re_title
				+ ", free_re_cont=" + free_re_cont + ", user_id=" + user_id + ", free_re_regdate=" + free_re_regdate
				+ "]";
	}
	

}
