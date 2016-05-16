
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {

    public static void main(String args[]){
        UseCase modelUseCase=new UseCase();

        try {
            File file = new File("C:\\Users\\Andra Barat\\Desktop\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(UseCase.class);


            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();



            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(modelUseCase, file);
            jaxbMarshaller.marshal(modelUseCase, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
