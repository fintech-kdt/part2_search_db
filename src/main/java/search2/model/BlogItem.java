package search2.model;

import search2.model.SearchResult.Item;

public class BlogItem {
	private String title;
	private String link;
	private String description;
	private String bloggerName;
	private String bloggerLink;
	private String postdate;
	private String keyword;
	
	public BlogItem(Item item, String keyword) {
		this.title = item.title;
		this.link = item.link;
		this.description = item.description;
		this.bloggerName = item.bloggerName;
		this.bloggerLink = item.bloggerLink;
		this.postdate = item.postdate;
		this.keyword = keyword;
	}
	
	public BlogItem(String title, String link, String description, String bloggerName, String bloggerLink,
			String postdate, String keyword) {
		super();
		this.title = title;
		this.link = link;
		this.description = description;
		this.bloggerName = bloggerName;
		this.bloggerLink = bloggerLink;
		this.postdate = postdate;
		this.keyword = keyword;
	}



	@Override
	public String toString() {
		return "BlogItem [title=" + title + ", link=" + link + ", description=" + description + ", bloggerName="
				+ bloggerName + ", bloggerLink=" + bloggerLink + ", postdate=" + postdate + ", keyword=" + keyword
				+ "]";
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public String getBloggerName() {
		return bloggerName;
	}

	public String getBloggerLink() {
		return bloggerLink;
	}

	public String getPostdate() {
		return postdate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setBloggerName(String bloggerName) {
		this.bloggerName = bloggerName;
	}

	public void setBloggerLink(String bloggerLink) {
		this.bloggerLink = bloggerLink;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
