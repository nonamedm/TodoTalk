package sjls.todotalk.user.vo;

public class UserVo {
	private String user_id, user_name, user_pwd, user_phone, user_mail, country, address, regdate, introduce;
	public UserVo() {}
	public UserVo(String user_id, String user_name, String user_pwd, String user_phone, String user_mail,
			String country, String address, String regdate, String introduce) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_phone = user_phone;
		this.user_mail = user_mail;
		this.country = country;
		this.address = address;
		this.regdate = regdate;
		this.introduce = introduce;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	@Override
	public String toString() {
		return "UserVo [user_id=" + user_id + ", user_name=" + user_name + ", user_pwd=" + user_pwd + ", user_phone="
				+ user_phone + ", user_mail=" + user_mail + ", country=" + country + ", address=" + address
				+ ", regdate=" + regdate + ", introduce=" + introduce + "]";
	}
}
