package com.Registration3.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Registration3.Model.DAOService3;
import com.Registration3.Model.DAOServiceImpl3;

@WebServlet("/verifylogin")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public loginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		DAOService3 service=new DAOServiceImpl3();
		service.ConnectDB();
		boolean status=service.loginverify(email, password);
		if(status==true)
		{
			 HttpSession session=request.getSession(true);
			session.setAttribute("email", email);
			 session.setMaxInactiveInterval(10);
			RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/view/NewRegistration3.jsp");
		   rd.forward(request, response);
		//  request.setAttribute("save", "Registration successful..");  
		
	}
		else
		{  request.setAttribute("error","username/password invalid");
		    RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}
		
		}catch(Exception e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}
	}

}
