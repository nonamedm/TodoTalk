package sjls.todotalk.board.vo;

public class PdsVo {
	//qna board vo 
	private String board_name;
	private int qna_idx;
	private String qna_title;
	private String qna_cont;
	private int user_idx;
	private String user_id;
	private String qna_regdate;
	private int qna_readcount;
	
	// 페이징 관련    
	private  int     nowpage;          // 현재 페이지 정보
	private  int     prevnowpage;      // 이전 10개 클릭시 적용되는 nowpage
	private  int     nextnowpage;      // 다음 10개 클릭시 적용되는 nowpage
	
	private  int     totalcount;       // 전체 row 수  
	private  int     totalpagecount;   // 화면에 보여줄 페이지 수
	
	private  int     pagestartnum;     // 화면에 보여줄 페이지 시작 번호
	private  int     pageendnum;       // 화면에 보여줄 페이지 끝 번호
	private  int     pagegrpnum;       // 페이지 그룹 숫자
	
	private  int      pagecount;        // 1 페이지에 보여줄 자료라인수
	
	private  boolean  isshowpageprev;
	private  boolean  isshowpagenext;
	
	
	// MBoard 답글관련
	private  int     bnum;
	private  int     lvl;
	private  int     step;
	private  int     nref;
	// 파일관련 - 목록(list)에 보여줄 조회된 파일 갯수
	private  int     filescount;
	
	public PdsVo() {}
	public PdsVo(String board_name, int qna_idx, String qna_title, String qna_cont, int user_idx, String user_id,
			String qna_regdate, int qna_readcount, int nowpage, int prevnowpage, int nextnowpage, int totalcount,
			int totalpagecount, int pagestartnum, int pageendnum, int pagegrpnum, int pagecount, boolean isshowpageprev,
			boolean isshowpagenext, int bnum, int lvl, int step, int nref, int filescount) {
		super();
		this.board_name = board_name;
		this.qna_idx = qna_idx;
		this.qna_title = qna_title;
		this.qna_cont = qna_cont;
		this.user_idx = user_idx;
		this.user_id = user_id;
		this.qna_regdate = qna_regdate;
		this.qna_readcount = qna_readcount;
		this.nowpage = nowpage;
		this.prevnowpage = prevnowpage;
		this.nextnowpage = nextnowpage;
		this.totalcount = totalcount;
		this.totalpagecount = totalpagecount;
		this.pagestartnum = pagestartnum;
		this.pageendnum = pageendnum;
		this.pagegrpnum = pagegrpnum;
		this.pagecount = pagecount;
		this.isshowpageprev = isshowpageprev;
		this.isshowpagenext = isshowpagenext;
		this.bnum = bnum;
		this.lvl = lvl;
		this.step = step;
		this.nref = nref;
		this.filescount = filescount;
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
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getPrevnowpage() {
		return prevnowpage;
	}
	public void setPrevnowpage(int prevnowpage) {
		this.prevnowpage = prevnowpage;
	}
	public int getNextnowpage() {
		return nextnowpage;
	}
	public void setNextnowpage(int nextnowpage) {
		this.nextnowpage = nextnowpage;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getTotalpagecount() {
		return totalpagecount;
	}
	public void setTotalpagecount(int totalpagecount) {
		this.totalpagecount = totalpagecount;
	}
	public int getPagestartnum() {
		return pagestartnum;
	}
	public void setPagestartnum(int pagestartnum) {
		this.pagestartnum = pagestartnum;
	}
	public int getPageendnum() {
		return pageendnum;
	}
	public void setPageendnum(int pageendnum) {
		this.pageendnum = pageendnum;
	}
	public int getPagegrpnum() {
		return pagegrpnum;
	}
	public void setPagegrpnum(int pagegrpnum) {
		this.pagegrpnum = pagegrpnum;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public boolean isIsshowpageprev() {
		return isshowpageprev;
	}
	public void setIsshowpageprev(boolean isshowpageprev) {
		this.isshowpageprev = isshowpageprev;
	}
	public boolean isIsshowpagenext() {
		return isshowpagenext;
	}
	public void setIsshowpagenext(boolean isshowpagenext) {
		this.isshowpagenext = isshowpagenext;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getNref() {
		return nref;
	}
	public void setNref(int nref) {
		this.nref = nref;
	}
	public int getFilescount() {
		return filescount;
	}
	public void setFilescount(int filescount) {
		this.filescount = filescount;
	}
	
	
	@Override
	public String toString() {
		return "PdsVo [board_name=" + board_name + ", qna_idx=" + qna_idx + ", qna_title=" + qna_title + ", qna_cont="
				+ qna_cont + ", user_idx=" + user_idx + ", user_id=" + user_id + ", qna_regdate=" + qna_regdate
				+ ", qna_readcount=" + qna_readcount + ", nowpage=" + nowpage + ", prevnowpage=" + prevnowpage
				+ ", nextnowpage=" + nextnowpage + ", totalcount=" + totalcount + ", totalpagecount=" + totalpagecount
				+ ", pagestartnum=" + pagestartnum + ", pageendnum=" + pageendnum + ", pagegrpnum=" + pagegrpnum
				+ ", pagecount=" + pagecount + ", isshowpageprev=" + isshowpageprev + ", isshowpagenext="
				+ isshowpagenext + ", bnum=" + bnum + ", lvl=" + lvl + ", step=" + step + ", nref=" + nref
				+ ", filescount=" + filescount + "]";
	}
	
	

}
