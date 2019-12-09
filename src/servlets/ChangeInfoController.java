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

import dao.PatientDAO;
import dao.UserDAO;
import models.Patients;
import models.Users;

/**
 * Servlet implementation class ChangeInfo
 */
@WebServlet("/ChangeInfo")
public class ChangeInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String ohipV;
	String midI;
	String lName;
	String fName;
	String password;

    public ChangeInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext ctx = getServletContext();
		Connection conn = (Connection)ctx.getAttribute("conn");
		
		Patients p1 = (Patients)session.getAttribute("user");
		
		ohipV = request.getParameter("healthcardVer");
		midI = request.getParameter("midInitials");
		lName = request.getParameter("lName");
		fName = request.getParameter("fName");
		if (fName.isEmpty()) {
			fName = p1.getFirstName();
		}
		if (lName.isEmpty()) {
			lName = p1.getLastName();		
		}
		if (midI.isEmpty()) {
			midI = p1.getMiddleInitials();	
		}
		if (ohipV.isEmpty()) {
			ohipV = p1.getOHIPVersion();
		}
		
		password = request.getParameter("password");
		Users u1 = (Users)session.getAttribute("loginInfo");
		if(password.isEmpty()) {
			password = u1.getPassword();
		}

		PatientDAO pDAO = new PatientDAO();
		pDAO.updatePatient(conn, fName, ohipV, midI, lName, p1.getFirstName());		
		session.removeAttribute("user");
		
		UserDAO uDAO = new UserDAO();
		uDAO.updateUser(conn, p1.getUserName(), password);
		u1.setPassword(password);
		
		
		Patients p2 = pDAO.getPatient(conn, p1.getUserName());

		session.setAttribute("user", p2);
		session.setAttribute("loginInfo", u1);
		
		System.out.println(p1.getFirstName());
		
		RequestDispatcher rd = request.getRequestDispatcher("infoUpdated.jsp");
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
