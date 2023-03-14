package com.Registration3.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServiceImpl3 implements DAOService3 {
  private Connection con; 
  private Statement stmnt;
	@Override
	public boolean loginverify(String email, String password) {
		try {
      ResultSet rs=stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
		  return rs.next();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void ConnectDB()  {
	 try { try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqldb1","root","test");
	    stmnt=con.createStatement();
	     
	   } catch (SQLException e)
	       {
		   e.printStackTrace();
	       }
		
	}

	@Override
	public void SaveRegistration(String name, String city, String email, String mobile) {
	
	      try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		
	          }
	      catch (SQLException e)
	      {
				e.printStackTrace();
		  }
	
	      }

	@Override
	public ResultSet getAllReg() {
		
		try 
		{
		ResultSet result=stmnt.executeQuery("select * from registration");
		 	return result;
		}catch (Exception e)
		   {
			e.printStackTrace();
		   }
		
		   return null;
	  }

	@Override
	public void deleteByEmail(String email) {
     try {
		stmnt.executeUpdate("delete from registration where email='"+email+"'");
	} catch (SQLException e) {
		e.printStackTrace();
	}		
	}

	@Override
	public void updatedata(String email, String mobile) {
             try {
				int check=stmnt.executeUpdate("update registration set mobile='"+mobile+"' where email='"+email+"'");
		           
				
             } catch (SQLException e) {
			  	}		
	}
	
	
}
