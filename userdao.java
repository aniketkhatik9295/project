package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.user;

public class userdao {
	 private Connection conn;

	public userdao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean register(user u) {
		   boolean f=false;
		   
		         try {
		        	 String sql1="INSERT INTO tourism_user(USER_NAME,fullname,ADDRESS,PH_NO,PASSWORD)VALUES(?,?,?,?,?)";
		        	 PreparedStatement ps=conn.prepareStatement(sql1);
		        	 ps.setString(1,u.getUsername());
		        	 ps.setString(2,u.getFullname());
		        	 ps.setString(3,u.getAddress1());
		        	 ps.setString(4,u.getPhnumber());
		        	 ps.setString(5, u.getPassword());
		        	 int i=ps.executeUpdate();
		        	 if(i == 1){		        		 
		        		 f=true;
		        	 }
		         }catch(Exception e){
		        		 System.out.print(e);
		        		 
		        	 }
		         return f;
	   }
		        	 
		        	public user login(String username,String psw){
		        		 user u=null;
		        		 try {
		        			 String sql4="select * from TOURISM_user where USER_NAME=? AND PASSWORD=?";
		        			 PreparedStatement ps1=conn.prepareStatement(sql4);
		        			 ps1.setString(1,username);
		        			 ps1.setString(2,psw);
		        			 ResultSet rs=ps1.executeQuery();
		        			 
		        			 while(rs.next()) {
		        				 u=new user();
		        				 u.setCid(rs.getString(1));
		        				 u.setUsername(rs.getString(2));
		        				 u.setFullname(rs.getString(3));
		        				 u.setAddress1(rs.getString(4));
		        				 u.setPhnumber(rs.getString(5));
		        				 u.setPassword(rs.getString(6));
		        				
		        				  
		        			 }
		        			 
		        			 
		        		 }catch(Exception e) {
		        			 System.out.print(e);
		        		 }
		        		 return u;
		        	 }
			 
		       
		             	public List<user> getUser(){
		        		List<user> list=new ArrayList<user>();
		        		user ap=null;
		        		try {
		        			String sql="select * from TOURISM_user";
		        			PreparedStatement ps=conn.prepareStatement(sql);
		        			
		        			ResultSet rs=ps.executeQuery();
		        			
		        			while(rs.next()) {
		        				ap=new user();
		        				 ap.setCid(rs.getString(0));
		        				 ap.setUsername(rs.getString(1));
		        				 ap.setFullname(rs.getString(2));
		        				 ap.setAddress1(rs.getString(3));
		        				 ap.setPhnumber(rs.getString(4));		        				
		        				list.add(ap);
		        			}
		        					        			
		        			
		        		}catch(Exception e) {
		        			System.out.println(e);
		        		}
		        		
		        		return list;
		        	}
	 
	 
}
