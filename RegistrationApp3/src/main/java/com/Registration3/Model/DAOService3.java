package com.Registration3.Model;

import java.sql.ResultSet;

public interface DAOService3 {
public boolean loginverify(String name,String password);
public void ConnectDB();
public void SaveRegistration(String name,String city,String email,String mobile);
public ResultSet getAllReg();

public void deleteByEmail(String email);
public void updatedata(String email, String mobile);

}
