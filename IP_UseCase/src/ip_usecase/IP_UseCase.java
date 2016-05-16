package ip_usecase;

import FisaCerintelor_add.FisaCerintelor;
import UseCaseDiagram.ModelUseCase;
import UseCaseDiagram.XmlDocument;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Daniel
 */
public class IP_UseCase {
    
    public static void main(String[] args) {
        
        FisaCerintelor fisaCerintelor = new FisaCerintelor(0);
        
        ModelUseCase modelUseCase = new ModelUseCase();
        modelUseCase.fromFisaCerintelor(fisaCerintelor);

        // to_XML:
        XmlDocument xmlDocument = null;
        
        try {
            xmlDocument = new XmlDocument(modelUseCase);
        } catch (JAXBException ex) {
            Logger.getLogger(IP_UseCase.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        
        System.out.println(xmlDocument.toString());
    }
    
}
