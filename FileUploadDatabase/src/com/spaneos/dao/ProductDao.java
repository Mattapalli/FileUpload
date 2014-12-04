package com.spaneos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import com.spaneos.pojo.Product;

public class ProductDao {
	private static String dbURL = "jdbc:mysql://localhost:3306/mattapalli";
	private static String dbUser = "root";
	private static String dbPass = "rama";
	static Connection conn;
	static Statement statement;
	Set<Product>pSet;
	ResultSet rs;
	
	public Set<Product> getAllProduct() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		conn=DriverManager.getConnection(dbURL,dbUser,dbPass);
		String sql="Select * from Product";
		statement=conn.createStatement();
		rs=statement.executeQuery(sql);
		
		while(rs.next()){
			Product product=new Product();
			product.setId(rs.getInt("id"));
			product.setKEYWORD(rs.getString("KEYWORD"));
			product.setTOTAL_COUNT(rs.getInt("TOTAL_COUNT"));
			pSet.add(product);
		}
		conn.close();
		return pSet;
	}

}
