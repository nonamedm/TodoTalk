package sjls.todotalk.user.vo;

public class TuboVo {
	
	//Fields
	private int tubo_idx;
	private String tubo_cont;
	private String tubo_title;
	private int user_idx;
	private String user_id;
	private String tubo_regdate;
	private int tubo_readcount;
	
	//Constructors
	public TuboVo() {}
	public TuboVo(int tubo_idx, String tubo_cont, String tubo_title, int user_idx, String user_id, String tubo_regdate,
			int tubo_readcount) {
		this.tubo_idx = tubo_idx;
		this.tubo_cont = tubo_cont;
		this.tubo_title = tubo_title;
		this.user_idx = user_idx;
		this.user_id = user_id;
		this.tubo_regdate = tubo_regdate;
		this.tubo_readcount = tubo_readcount;
	}
	
	//Getter and Setter
	public int getTubo_idx() {
		return tubo_idx;
	}
	public void setTubo_idx(int tubo_idx) {
		this.tubo_idx = tubo_idx;
	}
	public String getTubo_cont() {
		return tubo_cont;
	}
	public void setTubo_cont(String tubo_cont) {
		this.tubo_cont = tubo_cont;
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
	public String getTubo_regdate() {
		return tubo_regdate;
	}
	public void setTubo_regdate(String tubo_regdate) {
		this.tubo_regdate = tubo_regdate;
	}
	public int getTubo_readcount() {
		return tubo_readcount;
	}
	public void setTubo_readcount(int tubo_readcount) {
		this.tubo_readcount = tubo_readcount;
	}
	public String getTubo_title() {
		return tubo_title;
	}
	public void setTubo_title(String tubo_title) {
		this.tubo_title = tubo_title;
	}
	
	//toString
	@Override
	public String toString() {
		return "TuboVo [tubo_idx=" + tubo_idx + ", tubo_cont=" + tubo_cont + ", tubo_title=" + tubo_title
				+ ", user_idx=" + user_idx + ", user_id=" + user_id + ", tubo_regdate=" + tubo_regdate
				+ ", tubo_readcount=" + tubo_readcount + "]";
	}
	
}
