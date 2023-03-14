package com.Registration3.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.Registration3.Model.DAOService3;
import com.Registration3.Model.DAOServiceImpl3;

@WebServlet("/listAll")
public  class GetAllRegistrationController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public GetAllRegistrationController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session=request.getSession(false);
		 if(session.getAttribute("email")!=null)
		{
		DAOService3 service=new DAOServiceImpl3();
		service.ConnectDB();
		ResultSet result=service.getAllReg();
		
		request.setAttribute("result",result);
	 RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/view/ListRegistration.jsp");
	rd.forward(request, response);
	}
	
	else
	{
	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	  rd.forward(request, response);
	}
		}
		catch(Exception e)
		{RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		  rd.forward(request, response);
	     }
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	
	
	
}