package hbmd.ctl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hbmd.ctl.domain.student;
import hbmd.ctl.domain.stuinfo;
import hbmd.ctl.util.JdbcUtil;

public class upLodeDao {
	private upLodeDao() {}
	private static upLodeDao upLode;
	static {
		upLode =new upLodeDao();
		
	}
	public static upLodeDao getStudentDaoInstance() {
		return upLode;
	}

	
	public   ResultSet  getResultSet() throws SQLException {
		List<stuinfo> iStuinfos =new ArrayList<stuinfo>();
		String sql ="SELECT * FROM db02.infotb;";
		Connection connection =JdbcUtil.getConnect();
		PreparedStatement psm =connection.prepareStatement(sql);//装载sql语句，并把结果放在psm
		//psm.setString(1, num);//用numString替换sql中第一个”？“
		ResultSet rt  = psm.executeQuery();//执行sql，把结果放在rt
		return rt;
		
//	if (rt.next()) {
//		stuinfo aStuinfo =new stuinfo(rt.getInt(1), rt.getString(2), rt.getString(3), 0);
//		iStuinfos.add(aStuinfo);
//	}
	
		
		//return student;
	}
}
