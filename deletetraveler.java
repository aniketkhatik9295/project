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

@WebServlet("/deletetraveler")
public class deletetraveler extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		

		int id=Integer.parseInt(req.getParameter("id"));
		HttpSession session=req.getSession();
		
		travelerdao  dao= new travelerdao(Dbconnection.getConn());
	
		
		
		if(dao.deletetraveler(id)) {
			session.setAttribute("succ","traveler delete suss");
			resp.sendRedirect("admin/traveler.jsp");
			
		}else {
			session.setAttribute("errorMsg","traveler delete not suss");
			resp.sendRedirect("admin/traveler.jsp");
			
		}	
	}

	

}
