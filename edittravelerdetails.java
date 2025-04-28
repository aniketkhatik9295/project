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
import com.entity.travelerdetails;

@WebServlet("/edittravelerdetails")
public class edittravelerdetails extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			String travelername=req.getParameter("travelername");
			String manager=req.getParameter("manager");
			String contact=req.getParameter("contact");
			String address=req.getParameter("services");
			String password1=req.getParameter("pass1");
			int id=Integer.parseInt(req.getParameter("idl"));
			
			travelerdetails u=new travelerdetails(id,travelername,manager,contact,address,password1);
			
			travelerdao dao= new travelerdao(Dbconnection.getConn());
			
			HttpSession session=req.getSession();
			
			boolean f=dao.travelerupdate(u);
			
			if(f) {
				session.setAttribute("succMsg","Register Sucessfully");
				resp.sendRedirect("admin/ADDTRAVELLERS.jsp");
				
			}
			else {
				session.setAttribute("errorMsg","Something wrong");
				resp.sendRedirect("admin/ADDTRAVELLERS.jsp");
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}
