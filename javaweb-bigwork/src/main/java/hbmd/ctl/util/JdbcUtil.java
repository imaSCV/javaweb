package hbmd.ctl.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcUtil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static boolean driverLoad = false;
	static{
		if (getConfig()) {
			try {
				Class.forName(driver);
				driverLoad = true;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static boolean getConfig()
	{
		
		Properties properties = new Properties();
		InputStream iStream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//将文件中的数据加载到properties中
		try {
			properties.load(iStream);
			driver   = properties.getProperty("driver");
			url      = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//获取链接
	public static Connection getConnect() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}
	
	//获取statement 
	public static Statement getStatement(Connection conn) throws SQLException {
		return conn.createStatement();
	}
	//PrepareStatement
	public static PreparedStatement getPreparedStatement(Connection conn,String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}
	
	public static void colseConnect(Connection conn) {
		if (conn == null) {
			return;
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeStatement(Statement sm) {
		if (sm == null) {
			return;
		}
		try {
			sm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void colseResultSet(ResultSet rs){
		if (rs == null) {
			return;
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void  closeConnectionStateMent(Connection conn,Statement sm) {
		closeStatement(sm);
		colseConnect(conn);
	}
	public static void  closeAll(Connection conn,Statement sm,ResultSet rs) {
		colseResultSet(rs);
		closeStatement(sm);
		colseConnect(conn);
	}
}
