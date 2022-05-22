package framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class LoadProperty {
    private static final Logger logger = LoggerFactory.getLogger(LoadProperty.class);

    public static String getProperty(String property) {

        Properties properties = new Properties();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("data.properties");
            properties.load(inputStream);
        } catch (IOException  e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }

    public static String getXml(String gameName, int n) {
        DocumentBuilderFactory documentBuilderFactory;
        DocumentBuilder documentBuilder;
        Document document;
        String stringNode = "";
        try {
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("testData.xml");
            document = documentBuilder.parse(inputStream);
            Element element = document.getDocumentElement();
            NodeList nodeList = element.getElementsByTagName(gameName).item(n).getChildNodes();
            Node node = nodeList.item(n);
            stringNode = node.getNodeValue().trim();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return stringNode;
    }
}
