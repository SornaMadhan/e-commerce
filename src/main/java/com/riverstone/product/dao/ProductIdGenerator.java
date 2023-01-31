package com.riverstone.product.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProductIdGenerator implements IdentifierGenerator{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		int count=0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce-db","root","root");
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery("SELECT COUNT(*) From products_table" );
			if(rs.next()) {
				count=rs.getInt(1);
				count++;
			}
			return "P"+count;
		}
		catch (Exception e) {
			System.out.println("Inside ctch");
			e.printStackTrace();
		}
	
		return null;
	}
	

}
