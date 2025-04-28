package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.*;


public class travelerdao {
	
	 private Connection conn;

	public travelerdao(Connection conn) {
		super();
		this.conn = conn;
	}

	public List<travelerdetails> gettravelerdetails(){
		        		List<travelerdetails> list=new ArrayList<travelerdetails>();
		        		travelerdetails ap=null;
		        		try {
		        			String sql="SELECT * FROM TOURISM_TRAVELER";
		        			PreparedStatement ps=conn.prepareStatement(sql);
		        			
		        			ResultSet rs=ps.executeQuery();
		        			
		        			while(rs.next()) {
		        				ap=new travelerdetails();
		        				 ap.setTid(rs.getInt(1));
		        				 ap.setName(rs.getString(2));
		        				 ap.setPlace(rs.getString(3));
		        				 ap.setContact(rs.getString(4));
		        				 ap.setService(rs.getString(5));
		        				 ap.setPassword(rs.getString(6));
		        				list.add(ap);
		        			}
		        					        			
		        			
		        		}catch(Exception e) {
		        			System.out.println(e);
		        		}
		        		
		        		return list;
		        	}


	public travelerdetails  gettravelerdetailsid(int id){

		travelerdetails ap=null;
		try {
			String sql="SELECT * FROM TOURISM_TRAVELER where T_ID=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ap=new travelerdetails();
				 ap.setTid(rs.getInt(1));
				 ap.setName(rs.getString(2));
				 ap.setPlace(rs.getString(3));
				 ap.setContact(rs.getString(4));
				 ap.setService(rs.getString(5));
				 ap.setPassword(rs.getString(6));
				
			}
					        			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return ap;
	}

	
	
	
	public boolean register(travelerdetails u) {
		   boolean f=false;
		   
		         try {
		        	 String sql1="INSERT INTO TOURISM_TRAVELER(NAME,PLACE,CONTACT,SERVICE,password)VALUES(?,?,?,?,?)";
		        	 PreparedStatement ps=conn.prepareStatement(sql1);
		        	 ps.setString(1,u.getName());
		        	 ps.setString(2,u.getPlace());
		        	 ps.setString(3,u.getContact());
		        	 ps.setString(4,u.getService());
		        	 ps.setString(5,u.getPassword());
		        	

		        	 int i=ps.executeUpdate();
		        	 if(i == 1){		        		 
		        		 f=true;
		        	 }
		         }catch(Exception e){
		        		 System.out.print(e);
		        		 
		        	 }
		         return f;
	   }
	
	
	public boolean registera(travelerbooking u) {
		   boolean f=false;
		   
		         try {
		        	 String sql1="INSERT INTO TOURISM_TRAVELERBOOKING(T_ID,C_NAME,P_PLACE,TO_PLACE,CONTACT,B_DATE,C_ID)VALUES(?,?,?,?,?,?,?)";
		        	 PreparedStatement ps=conn.prepareStatement(sql1);
		        	 ps.setString(1,u.getTid());
		        	 ps.setString(2,u.getCname());
		        	 ps.setString(3,u.getPalce());
		        	 ps.setString(4,u.getTo_palce());
		        	 ps.setString(5,u.getCcontact());
		        	 ps.setString(6,u.getB_date());
		        	 ps.setString(7,u.getCid());


		        	 int i=ps.executeUpdate();
		        	 if(i == 1){		        		 
		        		 f=true;
		        	 }
		         }catch(Exception e){
		        		 System.out.print(e);
		        		 
		        	 }
		         return f;
	   }
	
	
	public List<travelerbooking> gettravelerbookingt_id(int c_id){
		List<travelerbooking> list=new ArrayList<travelerbooking>();
		travelerbooking ap=null;
		try {
			String sql="SELECT * FROM TOURISM_TRAVELERBOOKING  where C_ID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,c_id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ap=new travelerbooking();
				ap.setId(rs.getNString(1));
				ap.setTid(rs.getNString(2));
				ap.setCname(rs.getNString(3));
				ap.setPalce(rs.getNString(4));
				ap.setTo_palce(rs.getNString(5));
				ap.setCcontact(rs.getNString(6));
				ap.setB_date(rs.getNString(7));
				ap.setCid(rs.getNString(8));
				
				list.add(ap);
			}
					        			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	
	public List<travelerbooking> gettravelerbookingtid(String tid){
		List<travelerbooking> list=new ArrayList<travelerbooking>();
		travelerbooking ap=null;
		try {
			String sql="SELECT * FROM TOURISM_TRAVELERBOOKING WHERE t_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,tid);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ap=new travelerbooking();
				ap.setId(rs.getString(1));
				ap.setTid(rs.getString(2));
				ap.setCname(rs.getString(3));
				ap.setPalce(rs.getString(4));
				ap.setTo_palce(rs.getString(5));
				ap.setCcontact(rs.getString(6));
				ap.setB_date(rs.getString(7));
				ap.setCid(rs.getString(8));
				
				list.add(ap);
			}
					        			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	
	
	
	
	
	
	public travelerdetails logintr(String username,String psw){
		travelerdetails ap=null;
		 try {
			 String sql4="select * from TOURISM_TRAVELER where t_id=? and password=?";
			 PreparedStatement ps1=conn.prepareStatement(sql4);
			 ps1.setString(1,username);
			 ps1.setString(2,psw);
			 ResultSet rs=ps1.executeQuery();
			 
			 while(rs.next()) {
				 ap=new travelerdetails();
				 ap.setTid(rs.getInt(1));
				 ap.setName(rs.getString(2));
				 ap.setPlace(rs.getString(3));
				 ap.setContact(rs.getString(4));
				 ap.setService(rs.getString(5));
				 ap.setPassword(rs.getString(6));
				  
			 }
			 
			 
		 }catch(Exception e) {
			 System.out.print(e);
		 }
		 return ap;
	 }
	
	
	public boolean deletetraveler(int id) {
		boolean f=false;
		try {
			String sql="delete from TOURISM_TRAVELER where t_id=?";
			 PreparedStatement ps1=conn.prepareStatement(sql);
			 ps1.setInt(1, id);
			 int i=ps1.executeUpdate();
			 if(i==1) {
				 f=true;
			 }
		}
			 catch(Exception e) {
				 e.printStackTrace();
			 }
			 return f;
		}
	
	
	
	public boolean traveler(int id) {
		boolean f=false;
		try {
			String sql="delete from TOURISM_TRAVELERBOOKING where c_id=?";
			 PreparedStatement ps1=conn.prepareStatement(sql);
			 ps1.setInt(1,id);
			 int i=ps1.executeUpdate();
			 if(i==1) {
				 f=true;
			 }
		}
			 catch(Exception e) {
				 e.printStackTrace();
			 }
			 return f;
		}

	public boolean travelerupdate(travelerdetails d) {
		boolean f=false;
		
		try {
			String sql="update TOURISM_TRAVELER set NAME=?,PLACE=?,CONTACT=?,SERVICE=?,PASSWORD=? WHERE T_ID=?";
			 PreparedStatement ps1=conn.prepareStatement(sql);
			 
			 ps1.setString(1,d.getName());
			 ps1.setString(2,d.getPlace());
			 ps1.setString(3,d.getContact());
			 ps1.setString(4,d.getService());
			 ps1.setString(5, d.getPassword());
			 ps1.setInt(6,d.getTid());
			 
			 int i=ps1.executeUpdate();
			 if(i==1) {
				 f=true;
			 }
	
	
	}catch(Exception e) {
		System.out.print(e);
	}
		return f;
	}


}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

