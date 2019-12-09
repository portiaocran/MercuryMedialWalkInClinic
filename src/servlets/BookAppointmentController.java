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
import models.Patients;

/**
 * Servlet implementation class bookAppointment
 */
@WebServlet("/bookAppointment")
public class BookAppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Patients p1= (Patients)session.getAttribute("user");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String dtdis = date + " at " + time;
		String dateTime = request.getParameter("date") + " " + request.getParameter("time");
		String dt= dateTime.replaceAll("([A-Z])", "");
		
		ServletContext ctx = getServletContext();
		
		Connection conn = (Connection)ctx.getAttribute("conn");
		
		String reason = request.getParameter("reason");
		
		AppointmentDAO aDAO = new AppointmentDAO();
		
		Appointments apt = new Appointments();
		apt.setDateTime(dt);
		apt.setHealthCardNum(p1.getOHIPNumber());
		apt.setReasonForVisit(reason);
		
		aDAO.addAppointment(conn, apt);
		
		session.setAttribute("appt", apt);
		session.setAttribute("dtDis", dtdis);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("appointmentBooked.jsp");
		
		rd.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
