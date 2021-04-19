package sjls.todotalk.board.vo;

public class QnAFileVo {
	
	private int file_idx;
	private String file_name;
	private String file_ext;
	private String sfile_name;
	private int qna_idx;
	
	public QnAFileVo() {}
	public QnAFileVo(int file_idx, String file_name, String file_ext, String sfile_name, int qna_idx) {
		this.file_idx = file_idx;
		this.file_name = file_name;
		this.file_ext = file_ext;
		this.sfile_name = sfile_name;
		this.qna_idx = qna_idx;
	}
	
	public int getFile_idx() {
		return file_idx;
	}
	public void setFile_idx(int file_idx) {
		this.file_idx = file_idx;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_ext() {
		return file_ext;
	}
	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}
	public String getSfile_name() {
		return sfile_name;
	}
	public void setSfile_name(String sfile_name) {
		this.sfile_name = sfile_name;
	}
	public int getQna_idx() {
		return qna_idx;
	}
	public void setQna_idx(int qna_idx) {
		this.qna_idx = qna_idx;
	}
	
	@Override
	public String toString() {
		return "QnAFileVo [file_idx=" + file_idx + ", file_name=" + file_name + ", file_ext=" + file_ext
				+ ", sfile_name=" + sfile_name + ", qna_idx=" + qna_idx + "]";
	}
	
	
	

}
