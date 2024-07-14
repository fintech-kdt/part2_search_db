package search2.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SearchResult {
	@SerializedName("lastBuildDate")
	public String lastBuildDate;

	@SerializedName("total")
	public int total;

	@SerializedName("start")
	public int start;

	@SerializedName("display")
	public int display;

	@SerializedName("items")
	public List<Item> items;

	public static class Item {
		@SerializedName("title")
		public String title;

		@SerializedName("link")
		public String link;

		@SerializedName("description")
		public String description;
		
		@SerializedName("bloggername")
		public String bloggerName;
		
		@SerializedName("bloggerlink")
		public String bloggerLink;
		
		@SerializedName("postdate")
		public String postdate;
	}
}
