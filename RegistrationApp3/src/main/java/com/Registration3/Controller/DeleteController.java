package com.Registration3.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Registration3.Model.DAOService3;
import com.Registration3.Model.DAOServiceImpl3;


@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteController() {
        super();
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email=request.getParameter("email");
	//	System.out.println("delete="+email);
		DAOService3 service=new DAOServiceImpl3();
		service.ConnectDB();
		service.deleteByEmail(email);
	    
		ResultSet result=service.getAllReg();
	   request.setAttribute("result", result);
       RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/ListRegistration.jsp");
             rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
