//The purpose of this class is to gather information from request parameters to create a new user

package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Person;
import models.Users;

@WebServlet("/CreatePerson")
public class CreatePersonController extends HttpServlet {
	
	Person p1;
	Users u1;
	Date date = null;
	SimpleDateFormat formatter;
	
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		date = new Date(); //Gets todays date. Will be used when users are booking appointments. Appointments can only be booked for the future
		formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		
		//Gathering information from jsp to create a new user
		String fDate = formatter.format(date);
		String fName = request.getParameter("fName");
		String lName= request.getParameter("lName");
		String midInitials = request.getParameter("midInitials");
		String userName= request.getParameter("userName");
		String password= request.getParameter("password");
		int role = Integer.parseInt(request.getParameter("role"));
		
		p1 = new Person(fName, midInitials, lName, userName);
		u1 = new Users(userName, role, password, fDate);
		
		//created a session object to carry forward user data accross multiple pages
		HttpSession session = request.getSession();
		
		//setting two session attributes, one for our user table and one for the patient/doc table
		session.setAttribute("person", p1);
		session.setAttribute("user", u1);
		
		//If the user is a patient, they will be redirected to the patient page, where they can register as a patient
		if (role == 2) {
			RequestDispatcher rd = request.getRequestDispatcher("patient.jsp");
			rd.forward(request, response);
			
		//If the user is a doctor, they will be redirected to the doctor page, where they can register as a doctor	
		} else if(role ==1) {	
			RequestDispatcher rd = request.getRequestDispatcher("practitioners.jsp");
			rd.forward(request, response);
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
