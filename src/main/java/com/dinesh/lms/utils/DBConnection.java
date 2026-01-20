package com.dinesh.lms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dinesh.lms.model.Books;

public class DBConnection {

	public static Connection createConnection()
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem","root","Dinraj8830@");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Books bookRowMapper(ResultSet rs) throws SQLException
	{
		Books b = new Books();
		while(rs.next())
		{
			b = new Books();
			b.setBook_Id(rs.getInt("book_Id"));
			b.setTitle(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setCategory(rs.getString("category"));
			b.setQuantity(rs.getInt("quantity"));
		}
		return b;
	}

	public static List<Books> bookRowMapperAll(ResultSet rs) throws SQLException
	{
		List<Books> list = new ArrayList();
		while(rs.next())
		{
			Books b = new Books();
			b.setBook_Id(rs.getInt("book_Id"));
			b.setTitle(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setCategory(rs.getString("category"));
			b.setQuantity(rs.getInt("quantity"));
			list.add(b);
		}
		return list;
	}
}








