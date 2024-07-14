package search2.service;

import java.sql.SQLException;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import search2.dao.BlogItemDAO;
import search2.dao.BlogItemDAOImpl;
import search2.model.BlogItem;
import search2.model.SearchResult;
import search2.model.SearchResult.Item;

public class BlogItemService {
	private NaverApiService apiService;
	private final String baseUrl = "https://openapi.naver.com/";
	private final String clientID = "NZJNJtZ5vewbPhnYgfSS";
	private final String clientSecret = "GdtOWaDVBO";
	private BlogItemDAO dao;
	
	public BlogItemService() {
		Retrofit retrofit = new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
			    .baseUrl(baseUrl)
			    .build();
		apiService = retrofit.create(NaverApiService.class);
		dao = new BlogItemDAOImpl();
	}
	
	public void addBlogItems(String keyword) throws Exception {
		SearchResult searchResult = apiService.search(clientID, clientSecret, "blog", keyword, 100, 1)
				.execute().body();
		for (Item item : searchResult.items) {
			BlogItem blogItem = new BlogItem(item, keyword);
			System.out.println(blogItem);
			dao.addBlogItem(blogItem);
		}
	}
	
	public List<BlogItem> findBlogItemsByKeyword(String keyword) throws SQLException {
		return dao.getBlogItemsByKeyword(keyword);
	}
}
