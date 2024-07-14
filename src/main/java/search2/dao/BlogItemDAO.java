package search2.dao;

import java.sql.SQLException;
import java.util.List;

import search2.model.BlogItem;

public interface BlogItemDAO {
	List<BlogItem> getBlogItemsByKeyword(String keyword) throws SQLException;
	void addBlogItem(BlogItem item) throws SQLException;
}
