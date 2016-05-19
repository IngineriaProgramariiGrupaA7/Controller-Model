package view2.diagramgenerator;

import view2.model.Diagram;
import view2.xmlparser.XMLReader;

import java.awt.*;
import java.io.File;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {
    
    /**
     * Se initializeaza XMLReader pentru parsarea datelor din xml
     * Se Apleleaza functia de generarea a diagramei,in index.html care va fi deschisa cu 
     * browserul implicit
     *
     * @param args the arguments
     */
    @SuppressWarnings("unused")
	public static void main(String args[]) {
        XMLReader xmlReader = new XMLReader();
        Diagram diagram = xmlReader.parseXMLFile("site/xml/data.xml");
        DiagramGenerator dg = new DiagramGenerator();

        try {
            dg.generateDiagram("site/xml/data.xml", "site/diagram/index.html");
            Desktop.getDesktop().open(new File("site/diagram/index.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
