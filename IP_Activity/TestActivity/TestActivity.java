package TestActivity;

import ActivityDiagram.ActivityXmlDiagram;
import ActivityDiagram.ModelActivity;

import javax.xml.bind.JAXBException;

/**
 * Created by vlupoaie on 5/17/2016.
 */
public class TestActivity {
    public static void main(String[] args) {
        ModelActivity modelActivity = new ModelActivity();
        try {
            ActivityXmlDiagram xmlDocument = new ActivityXmlDiagram(modelActivity);
            System.out.println(xmlDocument.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
