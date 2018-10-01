package ReadXml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
public class test3 {
	public static void main(String[] args) {
		
	
	String xmlString ="<root><people>Dan</people></root>";
		try {
			Document document = DocumentHelper.parseText(xmlString);
			
			System.out.println(document.asXML());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
