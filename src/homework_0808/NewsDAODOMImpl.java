package homework_0808;

import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO {
	List<News> list = new LinkedList<News>();
	
	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> getNewsList(String url) {
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser;
		try {
			parser = fac.newDocumentBuilder();
			Document doc = parser.parse(url);
			NodeList nodelist = doc.getElementsByTagName("item");
			for (int i = 0, len = nodelist.getLength(); i < len; i++) {
				Node node = nodelist.item(i);
				News n = new News();
				for(Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
					if(child.getNodeType() != Node.ELEMENT_NODE)	continue;
					if(child.getNodeName().equals("title"))				n.setTitle(child.getTextContent());
					else if(child.getNodeName().equals("link"))			n.setLink(child.getTextContent());
					else if(child.getNodeName().equals("description")) {
						n.setDesc(child.getTextContent());
						list.add(n);
					}
						
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
