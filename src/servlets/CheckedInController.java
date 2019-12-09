package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AppointmentDAO;
import models.Appointments;

/**
 * Servlet implementation class checkedIn
 */
@WebServlet("/checkedIn")
public class CheckedInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheckedInController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext ctx = getServletContext();
		AppointmentDAO aDAO = new AppointmentDAO();
		
		Connection conn = (Connection)ctx.getAttribute("conn");
		Appointments a1 = (Appointments)session.getAttribute("regAppt");
		aDAO.checkIn(conn, a1);
		
		RequestDispatcher rd = request.getRequestDispatcher("successfulCheckIn.jsp");
		rd.forward(request, response);
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
