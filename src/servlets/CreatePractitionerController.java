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

import dao.AddressDAO;
import dao.PractitionerDAO;
import dao.UserDAO;
import models.Address;
import models.Person;
import models.Practitioners;
import models.Users;

/**
 * Servlet implementation class CreatePractitioner
 */
@WebServlet("/CreatePractitioner")
public class CreatePractitionerController extends HttpServlet {
	Practitioners practitioner;
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String streetAdd = request.getParameter("street");
		String aptUnit = request.getParameter("aptUnit");
		String streetAdd2 = request.getParameter("street2");
		String city= request.getParameter("city");
		String province = request.getParameter("province");
		String postalCode = request.getParameter("postalCode");
		String type = request.getParameter("type");
		
		int CPSO = Integer.parseInt(request.getParameter("CPSO"));
		String pracName = request.getParameter("pracName");
	
		
		HttpSession session = request.getSession();
		
		Person p1= (Person) session.getAttribute("person");
		Users u1 = (Users) session.getAttribute("user");
	
		
		Address a1= new Address(streetAdd, streetAdd2,aptUnit, city, province, postalCode, type, p1.getUserName());
		
		AddressDAO a1DAO = new AddressDAO();
		UserDAO uDAO = new UserDAO();
		
		ServletContext ctx = getServletContext();
		
		Connection conn = (Connection)ctx.getAttribute("conn");
		
		uDAO.addUser(conn, u1);
		a1DAO.addAddress(conn, a1);
		Address a2 = a1DAO.getAddress(conn, p1.getUserName());
		
		practitioner = new Practitioners(p1.getFirstName(), p1.getMiddleInitials(), p1.getLastName(), p1.getUserName(),pracName, CPSO, a2.getAddressId());
		PractitionerDAO pDAO = new PractitionerDAO();
		pDAO.addPractitioner(conn, practitioner);
		
		session.setAttribute("doctor", practitioner);
		
		RequestDispatcher rd = request.getRequestDispatcher("successful.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
