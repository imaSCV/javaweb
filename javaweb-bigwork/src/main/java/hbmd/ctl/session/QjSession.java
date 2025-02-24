package hbmd.ctl.session;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hbmd.ctl.domain.Role;
//默认为学生
//保存教师信息，把用户类型设位教师-->4个类型：：班头，管理员，辅导员，领导
//查找用户角色                                                                             |             |               |                  |
//查找权限                                                                                    权             权            权              权
import hbmd.ctl.domain.student;
import hbmd.ctl.domain.teacher;
public class QjSession {
	public static int USER_TYPE_TEACHER=1;
	public static int USER_TYPE_STUDENT=2;
	
	private Set<String> permissiones=new HashSet<String>();//权限
	private int userType;//1，老师  2，学生
	
	private student student;
	private teacher teacher;
	
	private List<Role> roles  ;
	//班头管理的班级id
	private String manageClass;
	
	//辅导员管理的学院id
	private int  fdy_colloegeId;
	//二级学院所属的领导id
	private int leader_colloegeId;
	
	public boolean hasPermisson(String permission) {
		
		return permissiones.contains(permission);
	}

	public Set<String> getPermissiones() {
		return permissiones;
	}

	public void setPermissiones(Set<String> permissiones) {
		this.permissiones = permissiones;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public student getStudent() {
		return student;
	}

	public void setStudent(student student) {
		this.student = student;
	}

	public teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(teacher teacher) {
		this.teacher = teacher;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getManageClass() {
		return manageClass;
	}

	public void setManageClass(String manageClass) {
		this.manageClass = manageClass;
	}

	public int getFdy_colloegeId() {
		return fdy_colloegeId;
	}

	public void setFdy_colloegeId(int fdy_colloegeId) {
		this.fdy_colloegeId = fdy_colloegeId;
	}

	public int getLeader_colloegeId() {
		return leader_colloegeId;
	}

	public void setLeader_colloegeId(int leader_colloegeId) {
		this.leader_colloegeId = leader_colloegeId;
	}
	
}
