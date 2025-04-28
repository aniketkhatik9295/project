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

@WebServlet("/deletetourist")
public class deletetourist extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		int id=Integer.parseInt(req.getParameter("id"));
		HttpSession session=req.getSession();
		
		guiddao  dao= new guiddao(Dbconnection.getConn());
	
		
		
		if(dao.deletetourist(id)) {
			session.setAttribute("succ","tourist delete suss");
			resp.sendRedirect("admin/tourist.jsp");
			
		}else {
			session.setAttribute("errorMsg","tourist delete not suss");
			resp.sendRedirect("admin/tourist.jsp");
			
		}	
		
		
		
		
	}
	
	
	

}
