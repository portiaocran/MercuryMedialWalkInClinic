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
 * Servlet implementation class cancelAppointment
 */
@WebServlet("/cancelAppointment")
public class CancelAppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CancelAppointmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentDAO aDAO = new AppointmentDAO();
		HttpSession session = request.getSession();
		ServletContext ctx = getServletContext();
		response.setCharacterEncoding("text/html");
		
		Connection conn = (Connection)ctx.getAttribute("conn");
		
		Patients patient = (Patients)session.getAttribute("user");
		ArrayList<Appointments> apptList = aDAO.getApptList(conn, patient.getOHIPNumber());

		session.setAttribute("apptList", apptList);
		RequestDispatcher rd = request.getRequestDispatcher("cancelAppointment.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
