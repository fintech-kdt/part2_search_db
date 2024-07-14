package search2.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import search2.model.BlogItem;
import search2.util.DatabaseUtil;

public class BlogItemDAOImpl implements BlogItemDAO {
	private Connection conn = null;
	
	@Override
	public List<BlogItem> getBlogItemsByKeyword(String keyword) throws SQLException {
		String query = "SELECT * FROM BLOG_ITEMS WHERE KEYWORD = ?";
		try {
			conn = DatabaseUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, keyword);
			ResultSet rs = ps.executeQuery();
			List<BlogItem> items = new ArrayList<>();
			while (rs.next()) {
				items.add(
					new BlogItem(
						rs.getString("title"),
						rs.getString("link"),
						rs.getString("description"),
						rs.getString("blogger_name"),
						rs.getString("blogger_link"),
						rs.getString("postdate"),
						rs.getString("keyword")
				));				
			}
			return items;
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();			
			}
		}
	}

	@Override
	public void addBlogItem(BlogItem item) throws SQLException {
		String query = "INSERT INTO BLOG_ITEMS VALUES (?,?,?,?,?,?,?)";
		try {
			conn = DatabaseUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, item.getTitle());
			ps.setString(2, item.getLink());
			ps.setString(3, item.getDescription());
			ps.setString(4, item.getBloggerName());
			ps.setString(5, item.getBloggerLink());
			String dateStr = item.getPostdate();
			ps.setDate(6, Date.valueOf(dateStr.substring(0, 4)
					+ "-" + dateStr.substring(4, 6)
					+ "-" + dateStr.substring(6, 8)));
			System.out.println(ps.toString());
			ps.setString(7, item.getKeyword());
			System.out.println("Updated Count : " + ps.executeUpdate());
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();			
			}
		}
	}

}
