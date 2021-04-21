package sjls.todotalk.board.vo;

public class QnAReplyVo {
	
	private int qna_idx;
	private int qna_re_idx;
	private String qna_re_title;
	private String qna_re_cont;
	private String user_id;
	private String qna_re_regdate;
	
	public QnAReplyVo() {}
	public QnAReplyVo(int qna_idx, int qna_re_idx, String qna_re_title, String qna_re_cont, String user_id,
			String qna_re_regdate) {
		super();
		this.qna_idx = qna_idx;
		this.qna_re_idx = qna_re_idx;
		this.qna_re_title = qna_re_title;
		this.qna_re_cont = qna_re_cont;
		this.user_id = user_id;
		this.qna_re_regdate = qna_re_regdate;
	}
	
	
	public int getQna_idx() {
		return qna_idx;
	}
	public void setQna_idx(int qna_idx) {
		this.qna_idx = qna_idx;
	}
	public int getQna_re_idx() {
		return qna_re_idx;
	}
	public void setQna_re_idx(int qna_re_idx) {
		this.qna_re_idx = qna_re_idx;
	}
	public String getQna_re_title() {
		return qna_re_title;
	}
	public void setQna_re_title(String qna_re_title) {
		this.qna_re_title = qna_re_title;
	}
	public String getQna_re_cont() {
		return qna_re_cont;
	}
	public void setQna_re_cont(String qna_re_cont) {
		this.qna_re_cont = qna_re_cont;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getQna_re_regdate() {
		return qna_re_regdate;
	}
	public void setQna_re_regdate(String qna_re_regdate) {
		this.qna_re_regdate = qna_re_regdate;
	}
	
	
	@Override
	public String toString() {
		return "QnAReplyVo [qna_idx=" + qna_idx + ", qna_re_idx=" + qna_re_idx + ", qna_re_title=" + qna_re_title
				+ ", qna_re_cont=" + qna_re_cont + ", user_id=" + user_id + ", qna_re_regdate=" + qna_re_regdate + "]";
	}
	
	

}
