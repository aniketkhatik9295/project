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


@WebServlet("/deletehotel")
public class deletehotel extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id=Integer.parseInt(req.getParameter("id"));
		HttpSession session=req.getSession();
		
		hoteldao  dao= new hoteldao(Dbconnection.getConn());
	
		
		
		if(dao.deletehotel(id)) {
			session.setAttribute("succ","hotel delete suss");
			resp.sendRedirect("admin/hotel.jsp");
			
		}else {
			session.setAttribute("errorMsg","hotel delete not suss");
			resp.sendRedirect("admin/hotel.jsp");
			
		}	
		
		
	}
	
	

}
