package sjls.todotalk.user.vo;

public class TureVo {
	
	//Fields
	private int tubo_idx;
	private int tb_repidx;
	private String tb_repcont;
	private int user_idx;
	private String user_id;
	private String tb_regdate;
	
	//Constructors
	public TureVo() {}
	public TureVo(int tubo_idx, int tb_repidx, String tb_repcont, int user_idx, String user_id, String tb_regdate) {
		this.tubo_idx = tubo_idx;
		this.tb_repidx = tb_repidx;
		this.tb_repcont = tb_repcont;
		this.user_idx = user_idx;
		this.user_id = user_id;
		this.tb_regdate = tb_regdate;
	}
	
	//Getter and Setter
	public int getTubo_idx() {
		return tubo_idx;
	}
	public void setTubo_idx(int tubo_idx) {
		this.tubo_idx = tubo_idx;
	}
	public int getTb_repidx() {
		return tb_repidx;
	}
	public void setTb_repidx(int tb_repidx) {
		this.tb_repidx = tb_repidx;
	}
	public String getTb_repcont() {
		return tb_repcont;
	}
	public void setTb_repcont(String tb_repcont) {
		this.tb_repcont = tb_repcont;
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
	public String getTb_regdate() {
		return tb_regdate;
	}
	public void setTb_regdate(String tb_regdate) {
		this.tb_regdate = tb_regdate;
	}
	
	//toString
	@Override
	public String toString() {
		return "TureVo [tubo_idx=" + tubo_idx + ", tb_repidx=" + tb_repidx + ", tb_repcont=" + tb_repcont
				+ ", user_idx=" + user_idx + ", user_id=" + user_id + ", tb_regdate=" + tb_regdate + "]";
	}
	
}
