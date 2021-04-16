package sjls.todotalk.user.vo;

public class ImgVo {
	
	//Fields 
	private int    user_photo_idx;  
	private int    user_idx; 
	private String user_id;
	private String profile_photo;
	private String photo_name;
	private String photo_orgfilename;
	private String photo_fileext;
	private String photo_sfilename;
	
	public ImgVo() {}
	public ImgVo(int user_photo_idx, int user_idx, String user_id, String profile_photo, String photo_name,
			String photo_orgfilename, String photo_fileext, String photo_sfilename) {
		super();
		this.user_photo_idx = user_photo_idx;
		this.user_idx = user_idx;
		this.user_id = user_id;
		this.profile_photo = profile_photo;
		this.photo_name = photo_name;
		this.photo_orgfilename = photo_orgfilename;
		this.photo_fileext = photo_fileext;
		this.photo_sfilename = photo_sfilename;
	}

	public int getUser_photo_idx() {
		return user_photo_idx;
	}

	public void setUser_photo_idx(int user_photo_idx) {
		this.user_photo_idx = user_photo_idx;
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

	public String getProfile_photo() {
		return profile_photo;
	}

	public void setProfile_photo(String profile_photo) {
		this.profile_photo = profile_photo;
	}

	public String getPhoto_name() {
		return photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}

	public String getPhoto_orgfilename() {
		return photo_orgfilename;
	}

	public void setPhoto_orgfilename(String photo_orgfilename) {
		this.photo_orgfilename = photo_orgfilename;
	}

	public String getPhoto_fileext() {
		return photo_fileext;
	}

	public void setPhoto_fileext(String photo_fileext) {
		this.photo_fileext = photo_fileext;
	}

	public String getPhoto_sfilename() {
		return photo_sfilename;
	}

	public void setPhoto_sfilename(String photo_sfilename) {
		this.photo_sfilename = photo_sfilename;
	}

	@Override
	public String toString() {
		return "ImgVo [user_photo_idx=" + user_photo_idx + ", user_idx=" + user_idx + ", user_id=" + user_id
				+ ", profile_photo=" + profile_photo + ", photo_name=" + photo_name + ", photo_orgfilename="
				+ photo_orgfilename + ", photo_fileext=" + photo_fileext + ", photo_sfilename=" + photo_sfilename + "]";
	}
	
	
	
	
	
	
}
