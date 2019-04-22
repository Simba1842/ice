package com.jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class test1 {
	public static void main(String[] args) throws SQLException {
		Connection con=JDBCUtils.getConnection();
		PreparedStatement pst=con.prepareStatement("select * from product");
		ResultSet rs=pst.executeQuery();
	    while(rs.next()){
		int id=rs.getInt("id");//1代表第一列的列名
		String name=rs.getString("name");
		double price=rs.getDouble("price");
		System.out.println(id+", "+name+", "+price);
		}JDBCUtils.close(con,pst,rs);
	}
}
