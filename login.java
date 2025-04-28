package com.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.*;
import com.db.Dbconnection;
import com.entity.*;


@WebServlet("/login")
public class login  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		
			String id=req.getParameter("id");
			String password=req.getParameter("password");
			
			
			HttpSession session=req.getSession();
			
			hoteldao dao= new hoteldao(Dbconnection.getConn());
			hoteldetals hotel=dao.loginhotel(id, password);
			
			
			if(hotel!=null) {
				session.setAttribute("userObj",hotel);
				resp.sendRedirect("admin/viewhotelbooking.jsp");
				
			}else {
				session.setAttribute("errorMsg","invalid email & password");
				resp.sendRedirect("admin/adminlogin.jsp");
				
			}		
			
		}catch (Exception e){
			e.printStackTrace();
			
		}
	}

		
	}


