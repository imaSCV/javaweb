package hbmd.ctl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hbmd.ctl.domain.student;
import hbmd.ctl.domain.stuinfo;
import hbmd.ctl.util.JdbcUtil;

public class addDao {
	private addDao() {}
	private static addDao addDao;
	static {
		addDao =new addDao();
		
	}
	public static addDao getStudentDaoInstance() {
		return addDao;
	}
	public   void  add(stuinfo num) throws SQLException {
		
		String sql = "INSERT INTO `db02`.`infotb` (`idinfotb`, `stunum`, `stuname`, `stuats`) VALUES (?, ?, ?, ?);";
		Connection connection = JdbcUtil.getConnect();
		try {
		    PreparedStatement psm = connection.prepareStatement(sql); // 装载sql语句
		    psm.setInt(1, num.getId()); // 替换sql中第一个"?"
		    psm.setString(2, num.getStunum());
		    psm.setString(3, num.getStuname());
		    psm.setInt(4, num.getStatus());
		    
		    int rowsAffected = psm.executeUpdate(); // 执行INSERT操作
		    
		    System.out.println("Rows affected: " + rowsAffected);
		    
		} catch (SQLException e) {
		    e.printStackTrace(); // 处理SQL异常
		} finally {
		    try {
		        if (connection != null && !connection.isClosed()) {
		            connection.close(); // 关闭数据库连接
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		}
	
	}
}
