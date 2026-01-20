package com.dinesh.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dinesh.lms.model.Books;
import com.dinesh.lms.utils.DBConnection;

public class BookDao {

	public int addBook(Books b)
	{
		int check = 0;
		String sql = "insert into Books(title,author,category,quantity)values(?,?,?,?)";
		try(Connection con=DBConnection.createConnection();
			PreparedStatement pst = con.prepareStatement(sql);){
			pst.setString(1, b.getTitle());
			pst.setString(2,b.getAuthor());
			pst.setString(3, b.getCategory());
			pst.setInt(4, b.getQuantity());
			check = pst.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
		return check;
	}

	public Books viewBookById(int book_Id)
	{
		Books b = new Books();
		String sql="select book_id,title,author,category,quantity from Books where book_Id=?";
		try(Connection con = DBConnection.createConnection();
			PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, book_Id);
			ResultSet rs = pst.executeQuery();
			b = DBConnection.bookRowMapper(rs);
		} catch (Exception e) {e.printStackTrace();}
		return b;
	}

	public List<Books> viewAllBooks()
	{
		List<Books> list = new ArrayList();
		String sql="select book_Id,title,author,category,quantity from Books";
		try(Connection con=DBConnection.createConnection();
			PreparedStatement pst =con.prepareStatement(sql);) {
			ResultSet rs = pst.executeQuery();
			list = DBConnection.bookRowMapperAll(rs);
		} catch (Exception e) {e.printStackTrace();}
		return list;
	}

	public int updateBooks(Books b)
	{
		int check = 0;
		String sql="update Books set title=?,author=?,category=?,quantity=? where book_Id=?";
		try(Connection con=DBConnection.createConnection();
			PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1,b.getTitle());
			pst.setString(2, b.getAuthor());
			pst.setString(3, b.getCategory());
			pst.setInt(4, b.getQuantity());
			pst.setInt(5, b.getBook_Id());
			check = pst.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
		return check;
	}

	public int deleteBooksById(int book_Id)
	{
		int check = 0;
		String sql="delete from Books where book_Id=?";
		try(Connection con=DBConnection.createConnection();
			PreparedStatement pst=con.prepareStatement(sql);) {
			pst.setInt(1, book_Id);
			check=pst.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
		return check;
	}
}












