package com.it18zhang.java23.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class TestDBCP {

	public static void main(String[] args) {
		try {
			BasicDataSource ds = new BasicDataSource() ;
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/big3");
			ds.setUsername("root");
			ds.setPassword("root");
			
			ds.setMaxTotal(10);
			ds.setInitialSize(3);
			Connection conn = ds.getConnection();
			PreparedStatement ppst = conn.prepareStatement("select 1");
			ResultSet rs = ppst.executeQuery();
			rs.next();
			System.out.println(rs.getInt(1));
			ppst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
