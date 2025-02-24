package hbmd.ctl.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbmd.ctl.domain.student;
import hbmd.ctl.domain.stuinfo;
import hbmd.ctl.service.addService;
import hbmd.ctl.service.studentService;

/**
 * Servlet implementation class addServlet
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Integer id = null;
	    String stunum = null;
	    String stuname = null;
	    try {
	        id = Integer.parseInt(request.getParameter("id")); 
	        stunum = request.getParameter("stunum");
	        stuname = request.getParameter("stuname");
	    } catch (NumberFormatException e) {
	     
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
	        return;
	    }
	 
	   
	    stuinfo iStuinfo = new stuinfo(id, stunum, stuname, 0);
		try {
			addService.getaddServiceInstance().addinfo(iStuinfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean success = true; 
		request.setAttribute("operationResult", success);
		
		request.getRequestDispatcher("public/action/toAdd.jsp").forward(request, response);
		
			
			

	
	}
}
