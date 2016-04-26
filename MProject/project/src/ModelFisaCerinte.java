import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by m on 4/26/16.
 */
public class ModelFisaCerinte {
    public ActionariInterese actionariInterese;
    public Domeniu domeniu;
    public Descriere descriere;
    public ActoriObiective actoriObiective;

    public ModelFisaCerinte(Descriere descriere,Domeniu domeniu,ActionariInterese actionariInterese,ActoriObiective actoriObiective){
        this.descriere=descriere;
        this.domeniu=domeniu;
        this.actionariInterese=actionariInterese;
        this.actoriObiective=actoriObiective;
    }

    public void makeXML(){
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement =doc.createElement("FisaCerinte");
            doc.appendChild(rootElement);

            Element descriereElement=doc.createElement("Descriere");
            descriereElement.appendChild(doc.createTextNode(descriere.getPlaintext()));
            rootElement.appendChild(descriereElement);

            Element domeniuElement=doc.createElement("Domeniu");
            domeniuElement.appendChild(doc.createTextNode(domeniu.getPlaintext()));
            rootElement.appendChild(domeniuElement);


            Element actionariIntereseElement=doc.createElement("ActionariInterese");

            Element actionarInteresElement[]=new Element[actionariInterese.getActionarInteresList().size()];
            Attr attrActionarNume[]=new Attr[actionariInterese.getActionarInteresList().size()];

            Element actoriObiectiveElement=doc.createElement("ActoriObiective");
            Element actorObiectivElement[]=new Element[actoriObiective.getActorObiectivList().size()];
            Attr attrActoriNume[]=new Attr[actoriObiective.getActorObiectivList().size()];

            for(int i=0;i<actoriObiective.getActorObiectivList().size();i++){
                actorObiectivElement[i]=doc.createElement("ActorObiectiv"+i);
                attrActoriNume[i]=doc.createAttribute("numeActor");
            }

            for(int i=0;i<actionariInterese.getActionarInteresList().size();i++){
                actionarInteresElement[i]=doc.createElement("ActionarInteres"+i);
                attrActionarNume[i]=doc.createAttribute("numeActionar");
            }

            for(int i=0;i<actoriObiective.getActorObiectivList().size();i++){
                attrActoriNume[i].setValue(actoriObiective.getActorObiectivList().get(i).getNumeActor());
                actorObiectivElement[i].setAttributeNode(attrActoriNume[i]);
                actorObiectivElement[i].appendChild(doc.createTextNode(actoriObiective.getActorObiectivList().get(i).getTextObiectiv()));
                actoriObiectiveElement.appendChild(actorObiectivElement[i]);
            }


            for(int i=0;i<actionariInterese.getActionarInteresList().size();i++){
                attrActionarNume[i].setValue(actionariInterese.getActionarInteresList().get(i).getNumeActionar());
                actionarInteresElement[i].setAttributeNode(attrActionarNume[i]);
                actionarInteresElement[i].appendChild(doc.createTextNode(actionariInterese.getActionarInteresList().get(i).getTextInteres()));
                actionariIntereseElement.appendChild(actionarInteresElement[i]);
            }


            rootElement.appendChild(actionariIntereseElement);

            rootElement.appendChild(actoriObiectiveElement);



            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/home/m/unixstuff/IP/Project/project/FisaCerinte.xml"));
            transformer.transform(source, result);
            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}

