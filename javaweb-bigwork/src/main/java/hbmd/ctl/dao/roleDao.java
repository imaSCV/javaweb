package hbmd.ctl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hbmd.ctl.domain.Role;
import hbmd.ctl.domain.teacher;
import hbmd.ctl.util.JdbcUtil;

public class roleDao {
	private roleDao() {
	};

	private static roleDao Instance;
	static {
		Instance = new roleDao();
	}

	public static roleDao getRoleDaoInstance() {
		return Instance;
	}

		public  List<Role>  getRoleListByUserId(int userid) throws SQLException{
				List<Role> a=new ArrayList<Role>();
				int i=0; String allString , nameString ="Role";
				
				String sql ="SELECT\r\n"
						+ " role.id,\r\n"
						+ " role.remark,\r\n"
						+ " role.name,\r\n"
						+ " role.arearType \r\n"
						+ " FROM db02.role\r\n"
						+ " where role.id in\r\n"
						+ "	( select rolemeun.menuid from rolemeun where \r\n"
						+ "		rolemeun.roleid = ?);";
				try(Connection connection =JdbcUtil.getConnect();
						PreparedStatement psm =connection.prepareStatement(sql)){
						psm.setInt(1, userid);
					
						try(ResultSet rt  = psm.executeQuery()){//执行sql，把结果放在rt
								while (rt.next()) {
									a.add(new Role(rt.getString(1),rt.getString(2),rt.getString(3),rt.getString(4)));
				//			System.out.print(rt.getString(1));
				//			System.out.print(rt.getString(2));
				//			System.out.print(rt.getString(3));
								}
						}
			  }
			catch (Exception e) {
				// TODO: handle exception
			}
			return  a;
		}
	}
