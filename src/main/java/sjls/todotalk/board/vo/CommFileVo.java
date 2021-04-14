package sjls.todotalk.board.vo;

public class CommFileVo {
	
	private int file_idx;    //파일번호
	private String file_name; //파일명
	private String file_ext; //파일 확장자
	private String sfile_name; //저장될 파일이름
	private int comm_idx; //게시글 번호 
	
	public CommFileVo() {}
	public CommFileVo(int file_idx, String file_name, String file_ext, String sfile_name, int comm_idx) {
		this.file_idx = file_idx;
		this.file_name = file_name;
		this.file_ext = file_ext;
		this.sfile_name = sfile_name;
		this.comm_idx = comm_idx;
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
	public int getComm_idx() {
		return comm_idx;
	}
	public void setComm_idx(int comm_idx) {
		this.comm_idx = comm_idx;
	}
	
	
	@Override
	public String toString() {
		return "CommFileVo [file_idx=" + file_idx + ", file_name=" + file_name + ", file_ext=" + file_ext
				+ ", sfile_name=" + sfile_name + ", comm_idx=" + comm_idx + "]";
	}
	
	


}
