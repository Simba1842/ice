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
        //第一步：创建连接池对象
        ComboPooledDataSource dataSource=new ComboPooledDataSource();//加载默认配置		
        	//ComboPooledDataSource dataSource=new ComboPooledDataSource();加载有名称的配置
        		
        
        //第二步：从连接池获取连接
        try {
        	conn=dataSource.getConnection();
        	String sql="select * from student";
        	pstmt=conn.prepareStatement(sql);
        	 rs=pstmt.executeQuery();
    	    while(rs.next()) {
    		int id=rs.getInt("id");//1代表第一列的列名
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