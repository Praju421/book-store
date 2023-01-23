package com.js.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.js.dto.Book;

public class BookCRUD {
	final static String path = "com.mysql.cj.jdbc.Driver";
	final static String adress = "jdbc:mysql://localhost:3306/Book_store?user=root&password=tiger";
	static Connection c;

	public int insertBook(Book b) {
		try {
			Class.forName(path);
			c = DriverManager.getConnection(adress);
			PreparedStatement ps = c.prepareStatement("insert into book value(?,?,?,?,?)");
			ps.setInt(1, b.getBookid());
			ps.setString(2, b.getBookname());
			ps.setString(3, b.getAuthorname());
			ps.setInt(4, b.getPages());
			ps.setDouble(5, b.getPrice());
			return ps.executeUpdate();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return 0;
	}

	public int DeleteBookBYId(int Id) {
		try {
			Class.forName(path);

			c = DriverManager.getConnection(adress);
			PreparedStatement ps = c.prepareStatement("delete from Book where book_id=?");
			ps.setInt(1, Id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int updateBookById(int id, Book b) {
		try {
			Class.forName(path);
			c = DriverManager.getConnection(adress);
			PreparedStatement ps = c
					.prepareStatement("update book set book_name=?,author_name=?,no_of_pages=?,price=? where book_id=?");
			ps.setString(1, b.getBookname());
			ps.setString(2, b.getAuthorname());
			ps.setInt(3, b.getPages());
			ps.setDouble(4, b.getPrice());	
			ps.setInt(5, id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	public Book GetBookById(int id) {
		Book b = null;
		try {
			Class.forName(path);
			c = DriverManager.getConnection(adress);
			PreparedStatement ps = c.prepareStatement("select * from book where book_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				b = new Book();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthorname(rs.getString(3));
				b.setPages(rs.getInt(4));
				b.setPrice(rs.getInt(5));
				return b;
			} else {
				return b;
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {

				c.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return b;
	}

	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> al = new ArrayList<Book>();
		try {
			Class.forName(path);
			c = DriverManager.getConnection(adress);
			PreparedStatement ps = c.prepareStatement("Select * from Book");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthorname(rs.getString(3));
				b.setPages(rs.getInt(4));
				b.setPrice(rs.getDouble(5));
				al.add(b);

			}
			return al;
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {

				c.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

public boolean batchExecution(ArrayList<Book>books) {
	try {
	Class.forName(path);
	c=DriverManager.getConnection(adress);
	PreparedStatement ps = c.prepareStatement("insert into book value(?,?,?,?,?)");
	for(Book b:books) {
		ps.setInt(1, b.getBookid());
		ps.setString(2, b.getBookname());
		ps.setString(3, b.getAuthorname());
		ps.setInt(4, b.getPages());
		ps.setDouble(5, b.getPrice());
		ps.addBatch();
	}
	ps.executeBatch();
	return true;
}catch(

	ClassNotFoundException e)
	{
	e.printStackTrace();
}catch(
	SQLException e)
	{
		e.printStackTrace();
	}
	finally {
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return false;
}
}
