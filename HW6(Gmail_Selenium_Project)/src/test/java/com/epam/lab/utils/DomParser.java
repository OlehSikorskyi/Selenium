package com.epam.lab.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParser {
   /* private final static Logger LOG = LogManager.getLogger(DomParser.class);
    public static final String USER_DIR = "user.dir";
    public static final String PATH = "\\src\\main\\resources\\user.xml";

    public static void main(String[] args) {
        try {
            File srcXmlFile = new File(System.getProperty(USER_DIR) + PATH);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(srcXmlFile);

            doc.getDocumentElement().normalize();
            LOG.info("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("user");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                LOG.info("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    LOG.info(eElement.getElementsByTagName("login").item(4).getTextContent());
                    LOG.info(eElement.getElementsByTagName("password").item(4).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
