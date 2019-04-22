package com.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	private JDBCUtils() {};
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mybase";
			String username="root";
			String password="root";
			con=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e+"数据库连接失败");
		}
	}
	public static Connection getConnection() {
		return con;
	}
	public static void close(Connection con,Statement stat,ResultSet rs ) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(stat!=null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
}
