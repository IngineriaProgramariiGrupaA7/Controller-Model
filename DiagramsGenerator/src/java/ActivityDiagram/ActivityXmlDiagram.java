package ActivityDiagram;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by vlupoaie on 5/17/2016.
 *
 * Class used for marshaling and generating the activity xml
 *
 */
public class ActivityXmlDiagram {

    String doc;

    public ActivityXmlDiagram(ModelActivity modelActivity) throws JAXBException {
        StringWriter sw = new StringWriter();

        JAXBContext jaxbContext = JAXBContext.newInstance(ModelActivity.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(modelActivity, sw);
        this.doc = sw.toString();
    }

    @Override
    public String toString() {
        return this.doc;
    }
}
