 package workshop_0822;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BookDAO {
	public void insertBook(Book book) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into Book(isbn, title, author, publisher, price, description)"
					   + " values(?, ?, ?, ?, ?, ?) ";
			int ind = 1;
			stmt = con.prepareStatement(sql);
			stmt.setString(ind++, book.getIsbn());
			stmt.setString(ind++, book.getTitle());
			stmt.setString(ind++, book.getAuthor());
			stmt.setString(ind++, book.getPublisher());
			stmt.setString(ind++, book.getPrice()+"");
			stmt.setString(ind++, book.getDescription());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	
	public void updateBook(Book book) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " update Book set title=?, author=?, publisher=?, price=?, description=? "
					   + " where isbn = ? ";
			int ind = 1;
			stmt = con.prepareStatement(sql);
			stmt.setString(ind++, book.getTitle());
			stmt.setString(ind++, book.getAuthor());
			stmt.setString(ind++, book.getPublisher());
			stmt.setString(ind++, book.getPrice()+"");
			stmt.setString(ind++, book.getDescription());
			stmt.setString(ind++, book.getIsbn());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	
	public void deleteBook(String isbn) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " delete from Book where isbn = ? ";
			int ind = 1;
			stmt = con.prepareStatement(sql);
			stmt.setString(ind++, isbn);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		
	}
	
	public Book findBook(String isbn) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from book where isbn = ? ";
			int ind = 1;
			stmt = con.prepareStatement(sql);
			stmt.setString(ind++, isbn);
			rs = stmt.executeQuery();
			while(rs.next())
				return new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), Integer.parseInt(rs.getString("price")), rs.getString("description"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return null;
	}
	
	public List<Book> listBooks(){
		List<Book> list = new LinkedList<Book>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from book ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
				list.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), Integer.parseInt(rs.getString("price")), rs.getString("description")));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return list;
	}
	
	public int count() {
		return 0;
	}
}
