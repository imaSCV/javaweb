package hbmd.ctl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import hbmd.ctl.domain.student;
import hbmd.ctl.util.JdbcUtil;

public class studentDao {
	private studentDao() {}
	private static studentDao studentDao;
	static {
		studentDao =new studentDao();
		
	}
	public static studentDao getStudentDaoInstance() {
		return studentDao;
	}
	public   student  getByNum(String num) throws SQLException {
		student student = new student();
		String sql ="SELECT * FROM db02.student WHERE num = ?";
		Connection connection =JdbcUtil.getConnect();
		PreparedStatement psm =connection.prepareStatement(sql);//装载sql语句，并把结果放在psm
		psm.setString(1, num);//用numString替换sql中第一个”？“
		ResultSet rt  = psm.executeQuery();//执行sql，把结果放在rt
	if (rt.next()) {
		student.setId(rt.getInt(1));
		student.setName(rt.getString(2)); 
		student.setName(rt.getString(3));
	}
		
		return student;
	}
	
	
}
