package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

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
import models.Patients;

/**
 * Servlet implementation class apptCancelledController
 */
@WebServlet("/apptCancelledController")
public class ApptCancelledController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ApptCancelledController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		Connection conn = (Connection) ctx.getAttribute("conn");
		AppointmentDAO aDAO = new AppointmentDAO();
		HttpSession session = request.getSession();
		
		int apptNumber = Integer.parseInt(request.getParameter("cancel"));
	
		aDAO.cancelAppt(conn, apptNumber);
		
		Patients patient = (Patients)session.getAttribute("user");
		ArrayList<Appointments> apptList = aDAO.getApptList(conn, patient.getOHIPNumber());
		session.setAttribute("apptList", apptList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("cancelConfirmation.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
