package by.gsu.pms;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX {
    public static void main(String argv[]) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {



                boolean bname = false;
                boolean bprice = false;
                boolean bdescription = false;
                boolean bcalories = false;

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {

                    if (qName.equalsIgnoreCase("name")) {
                        bname = true;
                    }
                    if (qName.equalsIgnoreCase("price")) {
                        bprice = true;
                    }
                    if (qName.equalsIgnoreCase("description")) {
                        bdescription = true;
                    }
                    if (qName.equalsIgnoreCase("calories")) {
                        bcalories = true;
                    }

                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {
                }
                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bname) {
                        System.out.println("Name: " + new String(ch, start, length));
                        bname = false;
                    }
                    if (bprice) {
                        System.out.println("Price: " + new String(ch, start, length));
                        bprice = false;
                    }
                    if (bdescription) {
                        System.out.println("Description : " + new String(ch, start, length));
                        bdescription = false;
                    }
                    if (bcalories) {
                        System.out.println("Salary : " + new String(ch, start, length));
                        bcalories = false;
                    }
                }
            };
            saxParser.parse("https://www.w3schools.com/xml/simple.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


