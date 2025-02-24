package hbmd.ctl.service;

import java.sql.SQLException;

import hbmd.ctl.dao.studentDao;
import hbmd.ctl.domain.student;

public class studentService {
	private studentService() {}
	  private static studentService service;
	  static {
		  service =new studentService();
		  
	  }
public static studentService getStudentServiceInstance() {
	return service;
}

public  student getByNum(String num) throws SQLException {
	return studentDao.getStudentDaoInstance().getByNum(num);
}

}
