package com.C3p0Utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.jdbcutil.JDBCUtils;

public class test{

   @Test
    public void testC3p0() throws PropertyVetoException, SQLException{
	   Connection con=null;
	   PreparedStatement pst=null;
	   ResultSet rs=null;
    
        try {
        	con=C3p0Utils.getConnection();
        	String sql="select * from student";
        	pst=con.prepareStatement(sql);
        	 rs=pst.executeQuery();
    	    while(rs.next()) {
    		int id=rs.getInt("id");//1代表第一列的列名
    		String name=rs.getString("name");
    		int age=rs.getInt("age");
    		int score=rs.getInt("score");
    		System.out.println(id+", "+name+", "+age+", "+score);}
    		  } catch (Exception e) {
    			throw new RuntimeException(e);
    		  } finally {
    			  C3p0Utils.release(con,pst,rs);
    		  }
        }
        
 
}
