package search2;

import java.util.List;

import search2.model.BlogItem;
import search2.service.BlogItemService;

public class Main {
	public static void main(String[] args) throws Exception {
		String keyword = "고래는 물에서 숨 쉬지 않는다";
		BlogItemService service = new BlogItemService();
		List<BlogItem> items = service.findBlogItemsByKeyword(keyword);
		if (items.isEmpty()) {	
			service.addBlogItems(keyword);
		} else {			
			items.forEach(System.out::println);
		}
	}
}
