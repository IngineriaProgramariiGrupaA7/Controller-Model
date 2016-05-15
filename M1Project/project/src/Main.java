/**
 * Created by m on 4/26/16.
 */
package src;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {

    public static void main(String args[]){
        ModelFisaCerinte modelFisaCerinte=new ModelFisaCerinte();

        try {
            File file = new File("D:\\mario\\info\\anul2\\sem2\\IP\\Controller-Model-master\\MProject\\project\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(ModelFisaCerinte.class);


            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();



            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(modelFisaCerinte, file);
            jaxbMarshaller.marshal(modelFisaCerinte, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
