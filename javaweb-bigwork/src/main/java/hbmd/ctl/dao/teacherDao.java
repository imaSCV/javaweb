package hbmd.ctl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.JdbcConnection;

import hbmd.ctl.domain.teacher;
import hbmd.ctl.util.JdbcUtil;

//
public class teacherDao {
	private  teacherDao() {}
	private static teacherDao instance;
	static {
		instance =new teacherDao();
	}
	
	public  static teacherDao getInstance() {
		return instance;
	}
	
	//
	public teacher getByNum(String numString) throws SQLException {
		teacher  teacher =new teacher();
		String sql ="SELECT * FROM db02.teacher WHERE num = ?";
		
		try (Connection connection =JdbcUtil.getConnect();
				PreparedStatement psm =connection.prepareStatement(sql)){//装载sql语句，并把结果放在psm
					psm.setString(1, numString);//用numString替换sql中第一个”？“
					ResultSet rt  = psm.executeQuery();//执行sql，把结果放在rt
					
					if(rt.next()) {//next指针从第一行开始，要取第一个元素先执行一次next（），
						teacher.setId(rt.getInt(1));
						teacher.setName(rt.getString(2));
						teacher.setNum(rt.getString(3));
						teacher.setPassword(rt.getString(4));
						teacher.setCollegeId(rt.getInt(5));
					}
					else {
						teacher=null;
					}
		} 
		
		catch (Exception e) {
			System.out.println("142");
			// TODO: handle exception
		}
		
		return teacher;
	}
}
