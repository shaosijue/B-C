package net.yasite.api.params;

public class GoodListParams extends BaseHttpParam {
	private String page;
	private String id;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
