package myclass.bol;



public class examinee {
	private String examID = null;// 身份证号
	private String examName = null;// 姓名
	private String sex = null;// 性别
	private String company = null;// 工作单位
	private String address = null;//单位地址
	private String phone = null;// 联系电话
	private String email = null;//email地址
	private String password = null;// 密码
	private String pic = null;// 照片文件名
	private String examType = null;// 考试类型
	private String memo = null;//备注
	/** 无参构造函数*/
	public examinee() {

	}

	/** 有参构造函数*/	
	public examinee(String examID, String examName, String sex, String company,
			String address, String phone, String email, String password,
			String examType, String memo, String pic) {
		this.examID = examID;
		this.examName = examName;
		this.sex = sex;
		this.company = company;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.examType = examType;
		this.memo = memo;
		this.pic = pic;
		this.address=address;
	}

	public String getAddress() {
		return address;
	}

	public String getCompany() {
		return company;
	}

	public String getEmail() {
		return email;
	}

	public String getExamID() {
		return examID;
	}

	public String getExamName() {
		return examName;
	}

	public String getExamType() {
		return examType;
	}

	public String getMemo() {
		return memo;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public String getPic() {
		return pic;
	}

	public String getSex() {
		return sex;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setExamID(String examID) {
		this.examID = examID;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
