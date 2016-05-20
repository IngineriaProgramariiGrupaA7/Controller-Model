package UseCaseDiagram;

import FisaCerinte.FisaCerintelor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 *
 * @author Daniel
 *
 * Class used to marshall all content and create xml document
 *
 */
public class XmlDocument {

    String doc;

    public XmlDocument(FisaCerintelor fisaCerintelor) throws JAXBException {

        StringWriter sw = new StringWriter();

        JAXBContext jaxbContext = JAXBContext.newInstance(FisaCerintelor.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(fisaCerintelor, sw);

        this.doc = sw.toString();

    }

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
