package ReadXml;

import java.io.File;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class test1 {

	public static void main(String[] args) {
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			// 读入文章属性
			org.w3c.dom.Document document = builder.newDocument();
			org.w3c.dom.Element root = document.createElement("languages");
			root.setAttribute("cat", "it");
			
			org.w3c.dom.Element lan1 = document.createElement("lan");
			lan1.setAttribute("id", "1");
			org.w3c.dom.Element name1 = document.createElement("name");
			name1.setTextContent("Java");
			org.w3c.dom.Element ide1 = document.createElement("ide");
			ide1.setTextContent("Eclipse");
			// 实现节点的包装
			lan1.appendChild(name1);// 添加子节点
			lan1.appendChild(ide1);

			org.w3c.dom.Element lan2 = document.createElement("lan");
			lan2.setAttribute("id", "2");
			org.w3c.dom.Element name2 = document.createElement("name");
			name2.setTextContent("Python");
			org.w3c.dom.Element ide2 = document.createElement("ide");
			ide1.setTextContent("Pycharm");
			lan2.appendChild(name2);// 添加子节点
			lan2.appendChild(ide2);

			org.w3c.dom.Element lan3 = document.createElement("lan");
			lan3.setAttribute("id", "3");
			org.w3c.dom.Element name3 = document.createElement("name");
			name3.setTextContent("C#");
			org.w3c.dom.Element ide3 = document.createElement("ide");
			ide3.setTextContent("Visual Studio");
			// 实现节点的包装			
			lan3.appendChild(name3);// 添加子节点
			lan3.appendChild(ide3);

			root.appendChild(lan1);
			root.appendChild(lan2);
			root.appendChild(lan3);

			document.appendChild(root);
			// ---------------------输出
			/*
			 * 先翻译在输出
			 */
			//输出到控制台
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			System.out.println(writer.toString());
			//输出到文件
			transformer.transform(new DOMSource(document), new StreamResult(new File("newxml.xml")));
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
