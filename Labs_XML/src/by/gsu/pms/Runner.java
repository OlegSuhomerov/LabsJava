package by.gsu.pms;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Runner {
    public static void main(String[] argv) throws IOException, ParserConfigurationException, org.xml.sax.SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("https://www.w3schools.com/xml/simple.xml");

        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList foodList = doc.getElementsByTagName("food");
        food[] foodObjects = new food[foodList.getLength()];

        for (int i = 0; i < foodList.getLength(); i++) {

            Node nNode = foodList.item(i);
            System.out.println("\nCurrent Element: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;

                Node nodeName = elem.getElementsByTagName("name").item(0);
                String name = nodeName.getTextContent();

                Node nodePrice = elem.getElementsByTagName("price").item(0);
                String price = nodePrice.getTextContent();

                Node nodeDescription = elem.getElementsByTagName("description").item(0);
                String description = nodeDescription.getTextContent();

                Node nodeCalories = elem.getElementsByTagName("calories").item(0);
                int calories = Integer.parseInt(nodeCalories.getTextContent());

                foodObjects[i] = new food(name, price, description, calories);
                System.out.println(foodObjects[i]);
            }
        }
    }
}
