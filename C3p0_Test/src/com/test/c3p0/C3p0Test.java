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

    //使用编码方式实现c3p0数据库连接池
   @Test
    public void TestC3p0() throws PropertyVetoException, SQLException{
        //第一步：创建连接池核心工具类
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        
        //第二步：连接池，url，驱动，账号，密码，初始连接数，最大连接数
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mybase");//设置url
        dataSource.setDriverClass("com.mysql.jdbc.Driver");//设置驱动
        dataSource.setUser("root");//mysql的账号
        dataSource.setPassword("root");//mysql的密码
        dataSource.setInitialPoolSize(6);//初始连接数，即初始化6个连接
        dataSource.setMaxPoolSize(50);//最大连接数，即最大的连接数是50
        dataSource.setMaxIdleTime(60);//最大空闲时间
        
        //第三步：从连接池对象中获取数据库连接
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