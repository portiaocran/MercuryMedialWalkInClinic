package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;

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
import models.Person;
import models.Users;

@WebServlet("/CreatePatient")

public class CreatePatientController extends HttpServlet {
	
	Patients patient;
	Date date= new Date();
	
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Long ohipNum =Long.parseLong(request.getParameter("ohipNum"));
		String ohipVer= request.getParameter("ohipVer");
		String gender= request.getParameter("gender");
		String date = request.getParameter("DOB");
		
		HttpSession session = request.getSession();
		
		Person p1= (Person) session.getAttribute("person");
		Users u1 = (Users) session.getAttribute("user");
		
		patient = new Patients (p1.getFirstName(), p1.getMiddleInitials(), p1.getLastName(), u1.getUsername(), ohipNum, ohipVer, gender, date);
		
		
		session.setAttribute("patient", patient);
		
		
		ServletContext ctx=getServletContext(); 
		
		System.out.println(patient.getFirstName());
		
		Connection conn = (Connection)ctx.getAttribute("conn");
		
		PatientDAO pDAO = new PatientDAO();
		UserDAO uDAO = new UserDAO();
		
		uDAO.addUser(conn, u1);
		
		pDAO.addPatient(conn, patient);
		
		RequestDispatcher rd = request.getRequestDispatcher("successful.jsp");
		rd.forward(request, response);
				
		PrintWriter pw= response.getWriter();
		response.setContentType("text/html");
		
		pw.write(patient.getFirstName() + "\n" + patient.getLastName() + "\n" + patient.getOHIPNumber() + "\n" + patient.getOHIPVersion() + date);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
