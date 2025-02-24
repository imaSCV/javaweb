package hbmd.ctl.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hbmd.ctl.domain.Role;
import hbmd.ctl.domain.student;
import hbmd.ctl.domain.teacher;
import hbmd.ctl.service.roleService;
import hbmd.ctl.service.studentService;
import hbmd.ctl.service.teacherService;
import hbmd.ctl.session.QjSession;

/**
 * Servlet implementation class loginServlet
 */

//Servlet---->services---->dao

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int LOGIN_IN = 1;
	private static final int LOGIN_OUT = 2;
	private static boolean RIGHT_ONE = false;
	private static  boolean RIGHT_TWO = false;
	private static  boolean RIGHT_THREE = false;
	private static  boolean RIGHT_FOUR = false;
	private static  boolean RIGHT_FIVE = false;
	private static  boolean RIGHT_SIX = false;
//	private static final String admit = null;
	private static final String ADMINISTRTO = "admin";
	QjSession qjSession = new QjSession();
	List<Role> roles = new ArrayList<Role>();
	/**
	 * @throws SQLException
	 * @see HttpServlet#HttpServlet()
	 * 
	 */
//12.13向getRole添加Id
	private void adminLongin(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
	//roleService.getRoleInstance().getRoles();	
	}
	
	
	private void setRightToRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("RIGHT_ONE", RIGHT_ONE);
		request.setAttribute("RIGHT_TWO", RIGHT_TWO);
		request.setAttribute("RIGHT_THREE", RIGHT_THREE);
		request.setAttribute("RIGHT_FOUR", RIGHT_FOUR);
		request.setAttribute("RIGHT_FIVE", RIGHT_FIVE);
		request.setAttribute("RIGHT_SIX", RIGHT_SIX);
	}
	
private void rightSet(List<Role> role) {//修改权限标识字
	RIGHT_ONE=roleService.getRoleInstance().isRightOne(role);
	RIGHT_TWO=roleService.getRoleInstance().isRightTwo(role);
	RIGHT_THREE=roleService.getRoleInstance().isRightThree(role);
	RIGHT_FOUR=roleService.getRoleInstance().isRightFour(role);
	RIGHT_FIVE=roleService.getRoleInstance().isRightFive(role);
	RIGHT_SIX=roleService.getRoleInstance().isRightSix(role);
}


	// 登出，并定向指指定页面
	private void loginOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("public/main.html");// 重定向到退出.jsp
	}

	// 通过login调用，为teacher提供login服务
	private void teacherLongin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// 1查找教师
		teacher teacher = teacherService.getteacherService().getByNum(request.getParameter("num"));
		if (teacher != null) {
			//System.out.print(request.getParameter("password"));
			// 比较密码
			//密码正确
			if(teacher.getPassword().equals(request.getParameter("password"))) {
				roles =roleService.getRoleInstance().getRoles(teacher.getId());
				Iterator<Role> iterator = roles.iterator();
				while (iterator.hasNext()) {
					System.out.print(iterator.next().getId());
				}
				rightSet(roles);//权限设置
				setRightToRequest(request, response);
				
				request.setAttribute("title", "成功");
				request.setAttribute("messsage", "用户存在");
//				request.getRequestDispatcher("public/mesage.jsp").forward(request, response);
					
			}
			else {//密码错误
				
			}

		} else {// 没有找到其用户num
			request.setAttribute("title", "失败");
			request.setAttribute("messsage", "用户不存在");
			request.getRequestDispatcher("public/mesage.jsp").forward(request, response);
			
		}
		

		// 查找角色

		// 查找权限

		// 若是班主任，查找其管理的班级

		// 若是辅导员，查所属向学院信息

		// 若是leader，设置其学院
	}

//为学生提供服务
	private student studentLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		return studentService.getStudentServiceInstance().getByNum(request.getParameter("num"));
		
	}

	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// 接受来main.jsp的post登录请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int option = Integer.parseInt(request.getParameter("option"));

		// switch stear
		switch (option) {
		case LOGIN_IN: {
			try {
				loginIn(request, response);
			}
			// 显示错误
			catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("ServletException");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("IOException");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("SQLException");

			}

			break;
		}
		case LOGIN_OUT: {
			loginOut(request, response);
			break;
		}
		default:
			break;
		}
		// switch end

	}
	// 登录，身份认证，根据权限重定向到指定页面
	private void loginIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String username = request.getParameter("num");
		boolean a =false;//密码正确与否
//		QjSession qjSession = new QjSession();
		HttpSession session = request.getSession();

		if (username.equals(ADMINISTRTO)) {
			// 超级管理员
			 adminLongin(request, response);
		} else if (username.trim().length() == 7) {
			// 老师7位数
			 teacherLongin(request, response);
			//qjSession.setTeacher(null);
			qjSession.setUserType(1);
	
		} else if(username.trim().length() == 6){
			// 学生
			 studentLogin(request, response);
			qjSession.setUserType(2);
		}
		
		//这里！！！！！！！！！！！12.12
		session.setAttribute("qjSession", qjSession);
	
		response.sendRedirect("public/main.html");//a为true时，密码正确
		
	}


}
