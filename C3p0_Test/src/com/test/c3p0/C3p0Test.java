package com.test.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.test.c3p0.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Test {

    //ʹ�ñ��뷽ʽʵ��c3p0���ݿ����ӳ�
   @Test
    public void TestC3p0() throws PropertyVetoException, SQLException{
        //��һ�����������ӳغ��Ĺ�����
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        
        //�ڶ��������ӳأ�url���������˺ţ����룬��ʼ�����������������
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mybase");//����url
        dataSource.setDriverClass("com.mysql.jdbc.Driver");//��������
        dataSource.setUser("root");//mysql���˺�
        dataSource.setPassword("root");//mysql������
        dataSource.setInitialPoolSize(6);//��ʼ������������ʼ��6������
        dataSource.setMaxPoolSize(50);//�������������������������50
        dataSource.setMaxIdleTime(60);//������ʱ��
        
        //�������������ӳض����л�ȡ���ݿ�����
        Connection con=dataSource.getConnection();
        String sql="select * from student";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        
        List<User> list=new ArrayList<User>();
        while(rs.next()){ 
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setScore(rs.getInt("score"));
            list.add(user);
        }
        
        System.out.println(list);
        con.close();
        ps.close();
        rs.close();
    }

}