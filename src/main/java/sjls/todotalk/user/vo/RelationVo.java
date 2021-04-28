package sjls.todotalk.user.vo;

public class RelationVo {
	private int relation_idx;
	private String require_id, require_name, receiver_id, receiver_name, mentor, mentee, permit;
	public RelationVo() {}
	public RelationVo(int relation_idx, String require_id, String require_name, String receiver_id, String receiver_name,
			String mentor, String mentee, String permit) {
		super();
		this.relation_idx = relation_idx;
		this.require_id = require_id;
		this.require_name = require_name;
		this.receiver_id = receiver_id;
		this.receiver_name = receiver_name;
		this.mentor = mentor;
		this.mentee = mentee;
		this.permit = permit;
	}
	public int getrelation_idx() {
		return relation_idx;
	}
	public void setrelation_idx(int relation_idx) {
		this.relation_idx = relation_idx;
	}
	public String getRequire_id() {
		return require_id;
	}
	public void setRequire_id(String require_id) {
		this.require_id = require_id;
	}
	public String getRequire_name() {
		return require_name;
	}
	public void setRequire_name(String require_name) {
		this.require_name = require_name;
	}
	public String getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getMentor() {
		return mentor;
	}
	public void setMentor(String mentor) {
		this.mentor = mentor;
	}
	public String getMentee() {
		return mentee;
	}
	public void setMentee(String mentee) {
		this.mentee = mentee;
	}
	public String getPermit() {
		return permit;
	}
	public void setPermit(String permit) {
		this.permit = permit;
	}
	@Override
	public String toString() {
		return "RelationVo [relation_idx=" + relation_idx + ", require_id=" + require_id + ", require_name=" + require_name
				+ ", receiver_id=" + receiver_id + ", receiver_name=" + receiver_name + ", mentor=" + mentor
				+ ", mentee=" + mentee + ", permit=" + permit + "]";
	}
}
