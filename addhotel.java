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

@WebServlet("/addhotel")
public class addhotel extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String hotelname=req.getParameter("hotelname");
			String manager=req.getParameter("manager");
			String contact=req.getParameter("contact");
			String address=req.getParameter("address");
			String rate1=req.getParameter("rate1");
			String rate2=req.getParameter("rate2");
			String rate3=req.getParameter("rate3");
			String rate4=req.getParameter("rate4");
			String password=req.getParameter("Pass");

			hoteldetals aaru=new hoteldetals(hotelname,manager,contact,address,rate1,rate2,rate3,rate4,password);
			
			hoteldao dao= new hoteldao(Dbconnection.getConn());
			
			HttpSession session=req.getSession();
			
			boolean f=dao.register(aaru);
			
			if(f){
				session.setAttribute("sucMsg","Register Sucessfully");
				resp.sendRedirect("admin/addhotel.jsp");
				
			}
			else {
				session.setAttribute("errorMsg","Something wrong");
				resp.sendRedirect("admin/addhotel.jsp");
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
	}
	
	
	
	
	

}
