package hbmd.ctl.service;
import java.sql.SQLException;

import hbmd.ctl.dao.teacherDao;
import hbmd.ctl.domain.*;


public class teacherService {
	
	private teacherService() {};
	
	private static teacherService instanceService;
	static {
		instanceService = new teacherService();
	}
	
	public static teacherService getteacherService() {
		return  instanceService;
	}
	
	
	public teacher getByNum(String num) throws SQLException {
		return teacherDao.getInstance().getByNum(num);
	}
//	public teacher getBynum(String numString) {
//		teacher  teacher =new teacher();
//		
//		return teacher;
//	}

}
