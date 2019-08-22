package workshop_0822;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			String sql = " update Book set title=?, author=?, publisher=?, price=?, description=?)"
					   + " where isbn = ? ";
			int ind = 1;
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
			String sql = " delete from Book where isbn = ? ";
			int ind = 1;
			stmt.setString(ind++, isbn);
			rs = stmt.executeQuery();
			while(rs.next())
				return new Book(rs.getString(columnIndex), title, author, publisher, price, description)
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return null;
	}
	
	public List<Book> listBooks(){
		
	}
	
	public int count() {
		return 0;
	}
}
