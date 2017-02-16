package com.afm.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.afm.model.People;

public class PeopleRepository {

	Connection con;
	Statement st;
	PreparedStatement ps;
	
	
	public PeopleRepository(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost/memobox?user=root&password=");
		st = con.createStatement();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public People savePeople(People p) {
	    try {
			ps = con.prepareStatement("insert into people(name,lastName,age)"+"values(?,?,?)");
			 ps.setString(1, p.getName());
		        ps.setString(2, p.getLastName());
		        ps.setInt(3, p.getAge());
		        ps.execute();
		        ps.close();
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	public List<People> getPeople(){
		List<People> pList = new ArrayList<People>();
		ResultSet rs = null;
		try {
			rs = st.executeQuery("select id,name,lastName,age from people");
			while(rs.next()){
				pList.add(new People(rs.getInt("id"), rs.getString("name"), rs.getString("lastName"), rs.getInt("age")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pList;
	}

	public void deletePeople(int id) {

		try {
			st.executeUpdate("delete from people where id="+id);
			//st.executeQuery("delete from people where id="+id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public void updateP(People p) {
		// TODO Auto-generated method stub
		try {
			ps = con.prepareStatement("UPDATE people SET name=?,lastName=?,age=? WHERE id=?");
			ps.setString(1, p.getName());
			ps.setString(2, p.getLastName());
			ps.setInt(3, p.getAge());
			ps.setInt(4, p.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}//Cierre de clase
