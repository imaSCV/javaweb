package hbmd.ctl.service;

import java.sql.SQLException;

import hbmd.ctl.dao.addDao;
import hbmd.ctl.dao.studentDao;
import hbmd.ctl.domain.student;
import hbmd.ctl.domain.stuinfo;

public class addService {
	private addService() {}
	  private static addService service;
	  static {
		  service =new addService();
		  
	  }
public static addService getaddServiceInstance() {
	return service;
}

public  void addinfo(stuinfo stu) throws SQLException {
	addDao.getStudentDaoInstance().add(stu);
}

}
