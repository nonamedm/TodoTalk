package sjls.todotalk.board.vo;

public class subPdsVo {
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
	
	public subPdsVo() {}
	public subPdsVo(int nowpage, int prevnowpage, int nextnowpage, int totalcount, int totalpagecount, int pagestartnum,
			int pageendnum, int pagegrpnum, int pagecount, boolean isshowpageprev, boolean isshowpagenext, int bnum,
			int lvl, int step, int nref, int filescount) {
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
		return "PdsVo [nowpage=" + nowpage + ", prevnowpage=" + prevnowpage + ", nextnowpage=" + nextnowpage
				+ ", totalcount=" + totalcount + ", totalpagecount=" + totalpagecount + ", pagestartnum=" + pagestartnum
				+ ", pageendnum=" + pageendnum + ", pagegrpnum=" + pagegrpnum + ", pagecount=" + pagecount
				+ ", isshowpageprev=" + isshowpageprev + ", isshowpagenext=" + isshowpagenext + ", bnum=" + bnum
				+ ", lvl=" + lvl + ", step=" + step + ", nref=" + nref + ", filescount=" + filescount + "]";
	}
	

	
	

}
