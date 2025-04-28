package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.user;


@WebServlet("/admin")
public class adminlogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id=req.getParameter("id");
			String password=req.getParameter("password");
			
			HttpSession session=req.getSession();
			if("Aniket".equals(id) && "Ani8085".equals(password)) {
				session.setAttribute("Aniket", new user());
				resp.sendRedirect("admin/index.jsp");
			} else {
				session.setAttribute("errorMsg", "invalid email & password");
				resp.sendRedirect("adminlogin.jsp");

			}
			
			
		}catch (Exception e){
			e.printStackTrace();
			
		}
	}

}
