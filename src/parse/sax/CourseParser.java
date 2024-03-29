package parse.sax;


import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class CourseParser {
	// 利用SAX技术解析XML文件
	public static void main(String[] args) {
		try {
			// 1、创建SAX解析器对象
			XMLReader parser = XMLReaderFactory.createXMLReader();
			// 2,创建事件处理器
			MyHandler2 handler = new MyHandler2();
			// 3,为XML解析器添加事件处理器
			parser.setContentHandler(handler);
			// 4,进行解析
//			parser.parse(args[0]);
			parser.parse("src/xml/basics/course.xml");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// 自定义的事件处理器
class MyHandler2 extends DefaultHandler {


	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
//		// 解析元素的开始标记触发的回调函数
//		System.out.print("<" + qName);
//		for (int i = 0; i < atts.getLength(); i++) {
//			String attName = atts.getQName(i);
//			String attValue = atts.getValue(i);
//			System.out.print(" " + attName + "=\"" + attValue + "\"");
//		}
//		System.out.print(">");

	}

//	@Override
//	public void endElement(String uri, String localName, String qName)
//			throws SAXException {
//		// 解析元素的结束标记触发的回调函数
////		System.out.print("</" + qName + ">");
//
//	}


	int sum;
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// 解析字符数据触发的回调函数
		String content = new String(ch, start, length);
//		System.out.print(content+" hh ");
//		System.out.print(content);
//		System.out.println(ch[18]);
		String[] str = content.split("[^0-9]");
		for(String s:str){
			 sum+=Integer.parseInt(s);
		}
		System.out.println(sum);

	}

	

}