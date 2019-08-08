package homework_0808;

import java.util.List;

public interface INewsDAO {
	public News search(int index);
	public List<News> getNewsList(String url);
}
