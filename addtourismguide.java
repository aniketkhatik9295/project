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

@WebServlet("/addtourismguide")
public class addtourismguide extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			String travelername=req.getParameter("Guide Name");
			String Place=req.getParameter("Place");
			String Contact=req.getParameter("Contact");
			String Rate1=req.getParameter("Rate1");
			String Rate_Group=req.getParameter("Rate_Group");
			String Password=req.getParameter("password");

			guiddetals u=new guiddetals(travelername,Place, Contact,Rate1,Rate_Group,Password);
			
			guiddao dao= new guiddao(Dbconnection.getConn());
			
			HttpSession session=req.getSession();
			
			boolean f=dao.register(u);
			
			if(f) {
				session.setAttribute("succMsg","Register Sucessfully");
				resp.sendRedirect("admin/tourist_guide.jsp");
				
			}
			else {
				session.setAttribute("errorMsg","Something wrong");
				resp.sendRedirect("admin/tourist_guide.jsp");
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		
	}

	
	
	
	
}
