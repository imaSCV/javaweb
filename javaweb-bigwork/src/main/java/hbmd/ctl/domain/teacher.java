package hbmd.ctl.domain;

public class teacher {
	private int id;
	private String name;
	private String num;
	private String password;
	private int collegeId;
	private college college;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public college getCollege() {
		return college;
	}
	public void setCollege(college college) {
		this.college = college;
	}
}
