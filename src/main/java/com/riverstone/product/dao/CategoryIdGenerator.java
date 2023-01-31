package com.riverstone.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CategoryIdGenerator implements IdentifierGenerator{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		int count=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce-db","root","root");
			Statement statement=con.createStatement();
			System.out.println("inside try");
			ResultSet resultSet=statement.executeQuery("Select count(*) from categories_table");
			if (resultSet.next()) {
				count=resultSet.getInt(1);
				count++;
			}
			return "C"+count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	

}
