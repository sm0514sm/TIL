package homework_0808;

import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class NewsDAOSAXImpl implements INewsDAO {
	List<News> list = new LinkedList<News>();
	static class SAXHandler extends DefaultHandler{
		StringBuilder b;
		boolean flag;
		News n;
		List<News> list;
		public SAXHandler(List<News> list){
			System.out.println();
			this.list = list;
		}
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if (qName.equals("item")) {
				n = new News();
				list.add(n);
				flag = true;
			}
		}
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			b=new StringBuilder();
			b.append(new String(ch, start, length));
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (flag && qName.equals("title")) {
				n.setTitle(b.toString());
			}
			else if (flag &&qName.equals("link")) {
				n.setLink(b.toString());
				
			}
			else if (flag &&qName.equals("description")) {
				n.setDesc(b.toString());
				flag = false;
			}
			
		}
	}
	
	@Override
	public News search(int index) {
		if(index < list.size())
			return list.get(index);
		else
			return null;
	}

	@Override
	public List<News> getNewsList(String url) {
		try {
			SAXParserFactory fac = SAXParserFactory.newInstance();
			SAXParser parser = fac.newSAXParser();
			SAXHandler handler = new SAXHandler(list);
			parser.parse(url, handler);
			return list;
		} catch (Exception e) {
			return null;
		}
	}

}
