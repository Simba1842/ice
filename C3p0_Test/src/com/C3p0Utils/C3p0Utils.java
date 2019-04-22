package com.C3p0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	public static DataSource getDataSource() {
		return dataSource;
	}
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//�ͷ���Դ
	public static void release(Connection con,PreparedStatement pst,ResultSet rs ) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		if(pst!=null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}

/*
 public class DataSourceUtils {

	public static DataSource dataSource;
	static
	{	
		dataSource = new ComboPooledDataSource();
	}
	public static  Connection getConnection()
	{
		Connection connection;
		try {
		connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new  RuntimeException();
		}
		return connection;
	}
	public static DataSource getDataSource()
	{
		return dataSource;
	}
		
}
 */









