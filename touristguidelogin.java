package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.*;
import com.db.Dbconnection;
import com.entity.*;

@WebServlet("/touristguidelogin")
public class touristguidelogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
try {
			
			String id=req.getParameter("id");
			String password=req.getParameter("password");
			
			
			HttpSession session=req.getSession();
			
			guiddao dao= new guiddao(Dbconnection.getConn());
			guiddetals td1=dao.loginguide(id, password);
			
			
			if(td1!=null) {
				session.setAttribute("userObj",td1);
				resp.sendRedirect("admin/viewtouristbooking.jsp");
				
			}else {
				session.setAttribute("errorMsg","invalid email & password");
				resp.sendRedirect("admin/touristlogin.jsp");
				
			}		
			
			
			}catch (Exception e){
				e.printStackTrace();
				
			}	
		
		
		
	}
	
	

}
