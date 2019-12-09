/** This Servlet is used to create a new user and log in.
 **/

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AppointmentDAO;
import dao.PatientDAO;
import dao.PractitionerDAO;
import dao.UserDAO;
import models.Appointments;
import models.Patients;
import models.Practitioners;
import models.Users;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Patients p2;
	PatientDAO p1;
	PractitionerDAO p5;
	Practitioners p4;
	Users u2;
	HttpSession session;
	ServletContext ctx;
	AppointmentDAO aptDAO;
	ArrayList<Appointments> apptList;
	UserDAO uDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);  
		
		Calendar cal2 = Calendar.getInstance();
		String date2 = simpleDateFormat.format(cal2.getTime());

		String date = simpleDateFormat.format(cal.getTime());
		
		session = request.getSession();
		session.setAttribute("date", date);
		session.setAttribute("date2", date2);
		
		ctx = getServletContext();
		Connection conn =(Connection)ctx.getAttribute("conn");
		
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			
			p1 = new PatientDAO();
			p2 = p1.getPatient(conn, userName, password);
			p5 = new PractitionerDAO();
			p4 = p5.getPractitioners(conn, userName, password); 
		
			u2 = new Users();
			
			uDAO = new UserDAO();
			
		
				if (p2 != null && p4 == null) {
					String DOB = p2.getDateofBirth();
					session.setAttribute("healthCard", p2.getOHIPNumber());
					u2.setPassword(password);
					u2.setUsername(userName);
					u2.setRole(2);
					uDAO.updateDate(conn, userName, date2);
					session.setAttribute("loginInfo", u2);
					session.setAttribute("user", p2);
					session.setAttribute("DOB", DOB);
					
					RequestDispatcher rd = request.getRequestDispatcher("userProfile.jsp");
					rd.forward(request, response);
				} else if (p4 != null & p2==null) {
					uDAO.updateDate(conn, userName, date2);
						String pracName;
						session.setAttribute("user", p4);
						session.setAttribute("username", userName);
						pracName = p4.getPracticeName();
						session.setAttribute("pracName", pracName);
			
						RequestDispatcher rd = request.getRequestDispatcher("userProfile2.jsp");
						rd.forward(request, response);
				} else{
						pw.println("Please enter a correct username and password, or register");
						pw.println("<br><br><a href='index.jsp'> Login Page</a>");
					}

		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
