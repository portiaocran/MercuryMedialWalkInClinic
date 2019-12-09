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
 * Servlet implementation class registerController
 */
@WebServlet("/registerController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creating attribute objects
		HttpSession session = request.getSession();
		ServletContext ctx = getServletContext();
		AppointmentDAO aDAO = new AppointmentDAO();
		
		Patients p1 = (Patients)session.getAttribute("user");
		Connection conn = (Connection)ctx.getAttribute("conn");
		
		String date = (String)session.getAttribute("date2");
		
		//This method will display appointments for today that the patient hasn't registered for
		Appointments a1 = aDAO.registerAppt(conn, date , p1.getOHIPNumber());
		
		session.setAttribute("regAppt", a1);
		
		RequestDispatcher rd = request.getRequestDispatcher("checkIn.jsp");
		
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
