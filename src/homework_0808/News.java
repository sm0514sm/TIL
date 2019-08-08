package homework_0808;

public class News {
	private String title;
	private String desc;
	private String link;
	
	public News() {
	}
	public News(String title, String desc, String link) {
		this.title = title;
		this.desc = desc;
		this.link = link;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		if(desc == null)
			return "";
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(title);
		return builder.toString();
	}
	
}
