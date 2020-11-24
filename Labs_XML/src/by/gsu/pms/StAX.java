package by.gsu.pms;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;

public class StAX {



    public static void main(String[] args) throws FileNotFoundException,
            XMLStreamException
    {

        String uri = "https://www.w3schools.com/xml/simple.xml";
        parser(uri);
    }

    public static void parser(String uri) throws FileNotFoundException,
            XMLStreamException
    {
        boolean bname = false;
        boolean bprice = false;
        boolean bdescription = false;
        boolean bcalories = false;

        URL url = null;
        try {
            url = new URL(uri);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream input = null;
        try {
            assert url != null;
            input = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = factory.createXMLEventReader(uri, input);

        while (eventReader.hasNext())
        {

            XMLEvent event = eventReader.nextEvent();

            if (event.isStartElement())
            {
                StartElement element = (StartElement)event;

                Iterator<Attribute> iterator = element.getAttributes();
                while (iterator.hasNext())
                {
                    Attribute attribute = iterator.next();
                    QName name = attribute.getName();
                    String value = attribute.getValue();
                    System.out.println(name+" = " + value);
                }

                if (element.getName().toString().equalsIgnoreCase("name"))
                {
                    bname = true;
                }
                if (element.getName().toString().equalsIgnoreCase("price"))
                {
                    bprice = true;
                }
                if (element.getName().toString().equalsIgnoreCase("description"))
                {
                    bdescription = true;
                }
                if (element.getName().toString().equalsIgnoreCase("calories"))
                {
                    bcalories = true;
                }
            }

            if (event.isEndElement())
            {
                EndElement element = (EndElement) event;

                if (element.getName().toString().equalsIgnoreCase("name"))
                {
                    bname = false;
                }
                if (element.getName().toString().equalsIgnoreCase("price"))
                {
                    bprice = false;
                }
                if (element.getName().toString().equalsIgnoreCase("description"))
                {
                    bdescription = false;
                }
                if (element.getName().toString().equalsIgnoreCase("calories"))
                {
                    bcalories = false;
                }
            }

            if (event.isCharacters())
            {
                // Depending upon the tag opened the data is retrieved .
                Characters element = (Characters) event;
                if (bname)
                {
                    System.out.println(element.getData());
                }
                if (bprice)
                {
                    System.out.println(element.getData());
                }
                if (bdescription)
                {
                    System.out.println(element.getData());
                }
                if (bcalories)
                {
                    System.out.println(element.getData());
                }
            }
        }
    }
}
