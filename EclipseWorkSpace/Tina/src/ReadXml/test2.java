package ReadXml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class test2 {
	public static void main(String[] args) {

		try {
			//DOM方式解析
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();// 获取新的实例
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("language.xml"));
			Element root = document.getDocumentElement();
			System.out.println("cat=" + root.getAttribute("cat"));
			NodeList list = root.getElementsByTagName("lan");
			for (int i = 0; i < list.getLength(); i++) {
				Element lan = (Element) list.item(i);
				System.out.println("-----------------");
				System.out.println("id=" + lan.getAttribute("id"));

				// Element name=(Element) lan.getElementsByTagName("name").item(0);/*不专业*/
				// System.out.println("name="+name.getTextContent());
				NodeList child = lan.getChildNodes();
				for (int j = 0; j < child.getLength(); j++) {
					Node tarname = child.item(j);
					if (tarname instanceof Element)
						System.out.println(tarname.getNodeName() + "=" + tarname.getTextContent());

				}

			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
