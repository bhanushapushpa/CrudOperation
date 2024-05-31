package Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.book;

public class crudConnection {

	Connection con;
	String query;
	PreparedStatement ps;
	ResultSet rs;

	public boolean insertBook(book Model) {
		boolean result = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "");
			query = "insert into bookDetails(BookName,BookImage,AuthorName,PublicationName,Description,BookPrice) values(?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, Model.getBookName());
			ps.setString(2, Model.getBookImage());
			ps.setString(3, Model.getAuthorName());
			ps.setString(4, Model.getPublicationName());
			ps.setString(5, Model.getDescription());
			ps.setString(6, Model.getBookPrice());
			ps.executeUpdate();
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<book> bookDetail() {
		List<book> list = new ArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "");
			query = "SELECT * FROM bookdetails";
			ps = this.con.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {
				book book = new book();
				book.setId(rs.getInt("ID"));
				book.setAuthorName(rs.getString("AuthorName"));
				book.setBookImage(rs.getString("BookImage"));
				book.setBookName(rs.getString("BookName"));
				book.setBookPrice(rs.getString("BookPrice"));
				book.setDescription(rs.getString("Description"));
				book.setPublicationName(rs.getString("PublicationName"));
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;
	}

	public Boolean cancelBook(int id) {
		// boolean result = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "");
			query = "delete from bookdetails where ID=?";
			ps = this.con.prepareStatement(query);
			ps.setInt(1, id);
			Boolean data = ps.execute();
			return data;
			// result = true;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
			return false;
		}
		// return result;
	}

	public boolean updatetBook(book b, String id) {
		boolean result = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "");
			query = "update bookDetails set  BookName =?,BookImage =?,AuthorName =?,PublicationName =?,Description=?,BookPrice =? where id ="
					+ id;
			
		
			

			ps = con.prepareStatement(query);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getBookImage());
			ps.setString(3, b.getAuthorName());
			ps.setString(4, b.getPublicationName());
			ps.setString(5, b.getDescription());
			ps.setString(6, b.getBookPrice());

			ps.executeUpdate();
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public book bookReturn(int id) {
		book book = new book();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "");
			query = "SELECT * FROM bookdetails where ID=" + id;
			ps = this.con.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {

				book.setId(rs.getInt("ID"));
				book.setAuthorName(rs.getString("AuthorName"));
				book.setBookImage(rs.getString("BookImage"));
				book.setBookName(rs.getString("BookName"));
				book.setBookPrice(rs.getString("BookPrice"));
				book.setDescription(rs.getString("Description"));
				book.setPublicationName(rs.getString("PublicationName"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return book;
	}

}
