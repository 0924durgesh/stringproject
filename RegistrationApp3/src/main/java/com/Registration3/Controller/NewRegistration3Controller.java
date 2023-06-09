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
import com.*;;


@WebServlet("/savereg")
public class NewRegistration3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NewRegistration3Controller() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/NewRegistration3.jsp");
	       rd.forward(request, response); 		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession(false);
		 session.setMaxInactiveInterval(10);
			
		if(session.getAttribute("email")!=null)
		{   
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		  
		DAOService3 service=new DAOServiceImpl3();
		service.ConnectDB();
		service.SaveRegistration(name, city, email, mobile);
		request.setAttribute("msg","record is saved...");
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/NewRegistration3.jsp");
       rd.forward(request, response); 		
		}
		else
		{RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		  rd.forward(request, response);
			
		}
		
		}
	catch(Exception e)
	{   
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		  rd.forward(request, response);
		
	}

}}
