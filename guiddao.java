package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.*;


public class guiddao {
	
	 private Connection conn; 
	
	
	public guiddao(Connection conn) {
		super();
		this.conn = conn;
	}



	public List<guiddetals> gettravelerdetails(){
		List<guiddetals> list=new ArrayList<guiddetals>();
		guiddetals ap=null;
		try {
			String sql="SELECT * FROM TOURISM_GUIDE";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ap=new guiddetals();
				 ap.setId(rs.getString(1));
				 ap.setGname(rs.getString(2));
				 ap.setGplace(rs.getString(3));
				 ap.setGcontacet(rs.getString(4));
				 ap.setRate1(rs.getString(5));
				 ap.setRate_group(rs.getString(6));
				 ap.setPassword(rs.getString(7));
				list.add(ap);
			}
					        			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	public boolean register(guiddetals u) {
		   boolean f=false;
		   
		         try {
		        	 String sql1="INSERT INTO TOURISM_GUIDE(G_NAME,G_PLACE,G_CONTACT,RATE,RATE_GROUP,PASSWORD)VALUES(?,?,?,?,?,?)";
		        	 PreparedStatement ps=conn.prepareStatement(sql1);
		        	 ps.setString(1,u.getGname());
		        	 ps.setString(2,u.getGplace());
		        	 ps.setString(3,u.getGcontacet());
		        	 ps.setString(4,u.getRate1());
		        	 ps.setString(5, u.getRate_group());
		        	 ps.setString(6, u.getPassword());

		        	 int i=ps.executeUpdate();
		        	 if(i == 1){		        		 
		        		 f=true;
		        	 }
		         }catch(Exception e){
		        		 System.out.print(e);
		        		 
		        	 }
		         return f;
	   }
	
	public boolean registerg(guidbooking u) {
		   boolean f=false;
		   
		         try {
		        	 String sql1="INSERT INTO TOURISM_GUIDEBOOKING(G_ID,C_NAME,C_CONTACT,PLACE,B_DATE,C_ID1)VALUES(?,?,?,?,?,?)";
		        	 PreparedStatement ps=conn.prepareStatement(sql1);
		        	 ps.setString(1,u.getGid());
		        	 ps.setString(2,u.getCname());
		        	 ps.setString(3,u.getCcontact());
		        	 ps.setString(4,u.getPlace());
		        	 ps.setString(5, u.getB_date());
		        	 ps.setString(6, u.getCid());

		        	 int i=ps.executeUpdate();
		        	 if(i == 1){		        		 
		        		 f=true;
		        	 }
		         }catch(Exception e){
		        		 System.out.print(e);
		        		 
		        	 }
		         return f;
	   }
	
	
	public List<guidbooking> gettouristbookingt_id(int cid){
		List<guidbooking> list=new ArrayList<guidbooking>();
		guidbooking ap=null;
		try {
			String sql="SELECT * FROM TOURISM_GUIDEBOOKING  where C_ID1=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,cid);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ap=new guidbooking();
				ap.setId(rs.getNString(1));;
				ap.setGid(rs.getNString(2));
				ap.setCname(rs.getNString(3));
				ap.setCcontact(rs.getNString(4));
				ap.setPlace(rs.getNString(5));
				ap.setB_date(rs.getNString(6));
				
				list.add(ap);
			}
					        			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

	public List<guidbooking> gettouristbookingid(int cid){
		List<guidbooking> list=new ArrayList<guidbooking>();
		guidbooking ap=null;
		try {
			String sql="SELECT * FROM TOURISM_GUIDEBOOKING where g_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,cid);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ap=new guidbooking();
				ap.setId(rs.getNString(1));;
				ap.setGid(rs.getNString(2));
				ap.setCname(rs.getNString(3));
				ap.setCcontact(rs.getNString(4));
				ap.setPlace(rs.getNString(5));
				ap.setB_date(rs.getNString(6));
				
				list.add(ap);
			}
					        			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	
	

	public guiddetals loginguide(String username,String psw){
		guiddetals ap=null;
		 try {
			 String sql4="select * from TOURISM_GUIDE where id=? and password=?";
			 PreparedStatement ps1=conn.prepareStatement(sql4);
			 ps1.setString(1,username);
			 ps1.setString(2,psw);
			 ResultSet rs=ps1.executeQuery();
			 
			 while(rs.next()) {
				 ap=new guiddetals();
				 ap.setId(rs.getString(1));
				 ap.setGname(rs.getString(2));
				 ap.setGplace(rs.getString(3));
				 ap.setGcontacet(rs.getString(4));
				 ap.setRate1(rs.getString(5));
				 ap.setRate_group(rs.getString(6));
				 ap.setPassword(rs.getString(7));
			
			}
				  
			 
			 
			 
		 }catch(Exception e) {
			 System.out.print(e);
		 }
		 return ap;
	 }
	
	
	public boolean deletetourist(int id) {
		boolean f=false;
		try {
			String sql="delete from TOURISM_GUIDE where id=?";
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
	
	public boolean tourist(int id) {
		boolean f=false;
		try {
			String sql="delete from TOURISM_GUIDEBOOKING where id=?";
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

	
	
	public boolean tourist(guiddetals d) {
		boolean f=false;
		
		try {
			String sql="update TOURISM_GUIDE set G_NAME=?,G_PLACE=?,G_CONTACT=?,RATE=?,RATE_GROUP=?,PASSWORD=? WHERE ID=?";
			 PreparedStatement ps1=conn.prepareStatement(sql);
			 
			 ps1.setString(1,d.getGname());
			 ps1.setString(2,d.getGplace());
			 ps1.setString(3,d.getGcontacet());
			 ps1.setString(4,d.getRate1());
			 ps1.setString(5,d.getRate_group());
			 ps1.setString(6,d.getPassword());
			 
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
