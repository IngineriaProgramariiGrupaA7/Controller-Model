package UseCaseDiagram;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Daniel
 */
public class XmlDocument {

    String doc;

    public XmlDocument(ModelUseCase modelUseCase) throws JAXBException {

        StringWriter sw = new StringWriter();

        JAXBContext jaxbContext = JAXBContext.newInstance(ModelUseCase.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(modelUseCase, sw);

        this.doc = sw.toString();

    }

    @Override
    public String toString() {

        return this.doc;

    }

}
