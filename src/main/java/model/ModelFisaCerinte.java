package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;

/**
 * Created by m on 4/26/16.
 */
public class ModelFisaCerinte {
    public ActionariInterese actionariInterese;
    public Domeniu domeniu;
    public Descriere descriere;
    public ActoriObiective actoriObiective;
    public ScenariiDeUtilizare scenariiDeUtilizare;

    public ModelFisaCerinte(Descriere descriere,Domeniu domeniu,ActionariInterese actionariInterese,ActoriObiective actoriObiective,ScenariiDeUtilizare scenariiDeUtilizare){
        this.descriere=descriere;
        this.domeniu=domeniu;
        this.actionariInterese=actionariInterese;
        this.actoriObiective=actoriObiective;
        this.scenariiDeUtilizare=scenariiDeUtilizare;
    }

    public String makeXML(){
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement =doc.createElement("FisaCerinte");
            doc.appendChild(rootElement);

            Element descriptionElement;
            Element nameElement;

            Element descriereElement=doc.createElement("descriptionApplication");
            descriptionElement=doc.createElement("description");
            descriptionElement.setTextContent(descriere.getPlaintext());
            descriereElement.appendChild(descriptionElement);
            rootElement.appendChild(descriereElement);

            Element domeniuElement=doc.createElement("domain");
            descriptionElement=doc.createElement("description");
            descriptionElement.setTextContent(domeniu.getPlaintext());
            domeniuElement.appendChild(descriptionElement);
            rootElement.appendChild(domeniuElement);


            Element actionariIntereseElement=doc.createElement("shareholders");
            Element actionarInteresElement[]=new Element[actionariInterese.getActionarInteresList().size()];

            Element actoriObiectiveElement=doc.createElement("actors");
            Element actorObiectivElement[]=new Element[actoriObiective.getActorObiectivList().size()];

            for(int i=0;i<actoriObiective.getActorObiectivList().size();i++){
                actorObiectivElement[i]=doc.createElement("actor");
            }

            for(int i=0;i<actionariInterese.getActionarInteresList().size();i++){
                actionarInteresElement[i]=doc.createElement("shareholder");
            }

            for(int i=0;i<actoriObiective.getActorObiectivList().size();i++){
                descriptionElement=doc.createElement("description");
                descriptionElement.setTextContent("description actor"+i);
                nameElement=doc.createElement("name");
                nameElement.setTextContent("actor"+i);
                actorObiectivElement[i].appendChild(nameElement);
                actorObiectivElement[i].appendChild(descriptionElement);
                actoriObiectiveElement.appendChild(actorObiectivElement[i]);
            }


            for(int i=0;i<actionariInterese.getActionarInteresList().size();i++){
                descriptionElement=doc.createElement("description");
                descriptionElement.setTextContent("description shareholder"+i);
                nameElement=doc.createElement("name");
                nameElement.setTextContent("shareholder"+i);
                actionarInteresElement[i].appendChild(nameElement);
                actionarInteresElement[i].appendChild(descriptionElement);
                actionariIntereseElement.appendChild(actionarInteresElement[i]);
            }

            rootElement.appendChild(actionariIntereseElement);

            rootElement.appendChild(actoriObiectiveElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);

            return writer.toString();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }

        return "failed";
    }
}

