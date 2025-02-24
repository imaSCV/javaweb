package hbmd.ctl.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbmd.ctl.domain.student;
import hbmd.ctl.service.studentService;

/**
 * Servlet implementation class findServlet
 */
@WebServlet("/findServlet")
public class findServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		student student =new student();
		try {
			student=  studentService.getStudentServiceInstance().getByNum(request.getParameter("studentnum"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(student!=null) {
		request.setAttribute("studentinfo", student);
		}
		request.getRequestDispatcher("public/action/toFindg.jsp").forward(request, response);
		//request.getRequestDispatcher("public/mesage.jsp").forward(request, response);
	}

}
