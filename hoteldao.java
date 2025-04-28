package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.*;
import com.entity.*;

public class hoteldao {
	
	 private Connection conn; 
 	public hoteldao(Connection conn) {
		super();
		this.conn = conn;
	}
	public List<hoteldetals> gethoteldetals(){
		List<hoteldetals> list=new ArrayList<hoteldetals>();
		hoteldetals ap=null;
		try {
			String sql="select * from tourism_hoteldetails";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ap=new hoteldetals();
				 ap.setHid(rs.getInt(1));
				 ap.setHotelname(rs.getString(2));
				 ap.setManager(rs.getString(3));
				 ap.setContact(rs.getString(4));
				 ap.setAddress1(rs.getString(5));
				 ap.setRate1(rs.getString(6));
				 ap.setRate2(rs.getString(7));
				 ap.setRate3(rs.getString(8));
				 ap.setRate4(rs.getString(9));
				list.add(ap);
			}
					        			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

	
	public hoteldetals gethoteldetalsid(int id){
		hoteldetals ap=null;
		try {
			String sql="select * from tourism_hoteldetails WHERE H_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ap=new hoteldetals();
				 ap.setHid(rs.getInt(1));
				 ap.setHotelname(rs.getString(2));
				 ap.setManager(rs.getString(3));
				 ap.setContact(rs.getString(4));
				 ap.setAddress1(rs.getString(5));
				 ap.setRate1(rs.getString(6));
				 ap.setRate2(rs.getString(7));
				 ap.setRate3(rs.getString(8));
				 ap.setRate4(rs.getString(9));
				 ap.setPassword(rs.getString(10));				
			}
					        			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return ap;
	}
	
	
	
	
	public boolean register(hoteldetals u) {
		   boolean f=false;
		   
		         try {
		        	 String sql1="INSERT INTO tourism_hoteldetails(hotel_name,manager,contact,address1,rate1,rate2,rate3,rate4,PASSWORD)VALUES(?,?,?,?,?,?,?,?,?)";
		        	 PreparedStatement ps=conn.prepareStatement(sql1);
		        	 ps.setString(1,u.getHotelname());
		        	 ps.setString(2,u.getManager());
		        	 ps.setString(3,u.getContact());
		        	 ps.setString(4,u.getAddress1());
		        	 ps.setString(5, u.getRate1());
		        	 ps.setString(6, u.getRate2());
		        	 ps.setString(7, u.getRate3());
		        	 ps.setString(8, u.getRate4());
		        	 ps.setString(9, u.getPassword());

		        	 int i=ps.executeUpdate();
		        	 if(i == 1){		        		 
		        		 f=true;
		        	 }
		         }catch(Exception e){
		        		 System.out.print(e);
		        		 
		        	 }
		         return f;
	   }
	
	
	
	public boolean register1(hotelbooking u) {
		   boolean f=false;
		   
		         try {
		        	 String sql1="INSERT INTO TOURISM_HOTELBOOKING(H_ID,C_ID,C_NAME,C_CONTACT,JOIN_DATE,LEAVE_DATE)VALUES(?,?,?,?,?,?)";
		        	 PreparedStatement ps=conn.prepareStatement(sql1);
		        	 ps.setString(1,u.getHid());
		        	 ps.setString(2,u.getCid());
		        	 ps.setString(3,u.getCname());
		        	 ps.setString(4,u.getCcontact());
		        	 ps.setString(5, u.getJoin_date());
		        	 ps.setString(6, u.getLave_date());


		        	 int i=ps.executeUpdate();
		        	 if(i == 1){		        		 
		        		 f=true;
		        	 }
		         }catch(Exception e){
		        		 System.out.print(e);
		        		 
		        	 }
		         return f;
	   }
	
	
	
	
	
	
	public List<hotelbooking> gethotelbookingall(){
		List<hotelbooking> list=new ArrayList<hotelbooking>();
		hotelbooking ap=null;
		try {
			String sql="select * from TOURISM_HOTELBOOKING";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ap=new hotelbooking();
				 ap.setHid(rs.getString(1));
				 ap.setCid(rs.getString(2));
				 ap.setCname(rs.getString(3));
				 ap.setCcontact(rs.getString(4));
				 ap.setJoin_date(rs.getString(5));
				 ap.setLave_date(rs.getString(6));
				 
				list.add(ap);
			}
					        			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}	
	
	
	
	
	
	public List<hotelbooking> gethotelbookingahid(int hid){
		List<hotelbooking> list=new ArrayList<hotelbooking>();
		hotelbooking ap=null;
		try {
			String sql="select * from TOURISM_HOTELBOOKING where hid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, hid);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ap=new hotelbooking();
				 ap.setHid(rs.getString(1));
				 ap.setCid(rs.getString(2));
				 ap.setCname(rs.getString(3));
				 ap.setCcontact(rs.getString(4));
				 ap.setJoin_date(rs.getString(5));
				 ap.setLave_date(rs.getString(6));
				 
				list.add(ap);
			}
					        			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}	
	
	
	public List<hotelbooking> gethotelbookingcid(int cid){
		List<hotelbooking> list=new ArrayList<hotelbooking>();
		hotelbooking ap=null;
		try {
			String sql="SELECT * FROM TOURISM_HOTELBOOKING WHERE c_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,cid);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ap=new hotelbooking();
				ap.setBid(rs.getString(1));
				 ap.setHid(rs.getString(2));
				 ap.setCid(rs.getString(3));
				 ap.setCname(rs.getString(4));
				 ap.setCcontact(rs.getString(5));
				 ap.setJoin_date(rs.getString(6));
				 ap.setLave_date(rs.getString(7));
				 
				list.add(ap);
			}
					        			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	public List<hotelbooking> gethotelbookinghid(int hid){
		List<hotelbooking> list=new ArrayList<hotelbooking>();
		hotelbooking ap=null;
		try {
			String sql="SELECT * FROM TOURISM_HOTELBOOKING WHERE h_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,hid);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ap=new hotelbooking();
				ap.setBid(rs.getString(1));
				 ap.setHid(rs.getString(2));
				 ap.setCid(rs.getString(3));
				 ap.setCname(rs.getString(4));
				 ap.setCcontact(rs.getString(5));
				 ap.setJoin_date(rs.getString(6));
				 ap.setLave_date(rs.getString(7));
				 
				list.add(ap);
			}
					        			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	
	
	
	public hoteldetals loginhotel(String username,String psw){
		hoteldetals ap=null;
		 try {
			 String sql4="select * from TOURISM_HOTELDETAILS where h_id=? ANd PASSWORD=?";
			 PreparedStatement ps1=conn.prepareStatement(sql4);
			 ps1.setString(1,username);
			 ps1.setString(2,psw);
			 ResultSet rs=ps1.executeQuery();
			 
			 while(rs.next()) {
				 ap=new hoteldetals();
				 ap.setHid(rs.getInt(1));
				 ap.setHotelname(rs.getString(2));
				 ap.setManager(rs.getString(3));
				 ap.setContact(rs.getString(4));
				 ap.setAddress1(rs.getString(5));
				 ap.setRate1(rs.getString(6));
				 ap.setRate2(rs.getString(7));
				 ap.setRate3(rs.getString(8));
				 ap.setRate4(rs.getString(9));
				 ap.setPassword(rs.getString(10));
				
				
				  
			 }
			 
			 
		 }catch(Exception e) {
			 System.out.print(e);
		 }
		 return ap;
	 }
	
	
	public boolean deletehotel(int id) {
		boolean f=false;
		try {
			String sql="delete from TOURISM_HOTELDETAILS where h_id=?";
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
	
	
	public boolean hotel(int id) {
		boolean f=false;
		try {
			String sql="delete from TOURISM_HOTELBOOKING where h_id=?";
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
	

	
	
	
	
	
	
	public boolean updatehotel(hoteldetals d) {
		boolean f=false;
		
		try {
			String sql="update TOURISM_HOTELDETAILS set HOTEL_NAME=?,MANAGER=?,CONTACT=?,ADDRESS1=?,RATE1=?,RATE2=?,RATE3=?,RATE4=?,PASSWORD=? WHERE h_id=?";
			 PreparedStatement ps1=conn.prepareStatement(sql);
			 
			 ps1.setString(1,d.getHotelname());
			 ps1.setString(2,d.getManager());
			 ps1.setString(3, d.getContact());
			 ps1.setString(4,d.getAddress1());
			 ps1.setString(5, d.getRate1());
			 ps1.setString(6, d.getRate2());
			 ps1.setString(7, d.getRate3());
			 ps1.setString(8, d.getRate4());
			 ps1.setString(9, d.getPassword());
			 ps1.setInt(10,d.getHid());
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
