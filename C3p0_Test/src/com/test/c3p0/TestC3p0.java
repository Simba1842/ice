package com.test.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.C3p0Utils.C3p0Utils;
import com.jdbcutil.*;
import org.junit.Test;

import com.jdbcutil.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3p0 {

   @Test
    public void testC3p0() throws PropertyVetoException, SQLException{
	   Connection conn=null;
	   PreparedStatement pstmt=null;
	   ResultSet rs=null;
        //��һ�����������ӳض���
        ComboPooledDataSource dataSource=new ComboPooledDataSource();//����Ĭ������		
        	//ComboPooledDataSource dataSource=new ComboPooledDataSource();���������Ƶ�����
        		
        
        //�ڶ����������ӳػ�ȡ����
        try {
        	conn=dataSource.getConnection();
        	String sql="select * from student";
        	pstmt=conn.prepareStatement(sql);
        	 rs=pstmt.executeQuery();
    	    while(rs.next()) {
    		int id=rs.getInt("id");//1�����һ�е�����
    		String name=rs.getString("name");
    		int age=rs.getInt("age");
    		int score=rs.getInt("score");
    		System.out.println(id+", "+name+", "+age+", "+score);}
    		  } catch (Exception e) {
    			throw new RuntimeException(e);
    		  } finally {
    			  C3p0Utils.release(conn,pstmt,rs);
    		  }
        }
        
 
}