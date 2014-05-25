/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devTeam.xml.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author EUGI7210
 */
public class kmlToMwc {

    public static void convert(String inDir, String outFile) throws FileNotFoundException {
        PrintWriter pwOutFile = null;

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".kml");
            }
        };

        File dir = new File(inDir);
        pwOutFile = new PrintWriter(outFile);
        String[] fileList = dir.list(filter);

        if (fileList == null) {
            System.out.println("no kml files in directory!");
            return;
        }

        Arrays.sort(fileList);

        try {
            for (String fileName : fileList) {
                File kmlFile = new File(inDir + "/" + fileName);
                String line;
                line = getFormatedValues(kmlFile);

                pwOutFile.println(line);
                System.out.println(line);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(kmlToMwc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(kmlToMwc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(kmlToMwc.class.getName()).log(Level.SEVERE, null, ex);
        }
        pwOutFile.close();
    }

    private static String getFormatedValues(File kmlFile) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(kmlFile);
        doc.getDocumentElement().normalize();

        Element element = (Element) doc.getElementsByTagName("LookAt").item(0);

        int latitude = (int) Math.round(Double.parseDouble(getValue("latitude", element)) * Math.pow(10, 7));
        int longitude = (int) Math.round(Double.parseDouble(getValue("longitude", element)) * Math.pow(10, 7));
        int heading = (int) Float.parseFloat(getValue("heading", element));

        Element coordsElement = (Element) doc.getElementsByTagName("Point").item(0);
        String altStr = getValue("coordinates", coordsElement);

        int altitude = Math.round(Float.parseFloat(altStr.substring(altStr.indexOf(',', altStr.indexOf(',') + 1) + 1)));

        return "" + latitude + "," + longitude + "," + altitude + "," + heading;
    }

    private static String getValue(String tag, Element element) {
        NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }
}
