
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UseCase {

    private AppDescription appDescription;
    private List<Actor> actor;
    private List<Shareholder> shareholder;
    private Extension extension;


    public UseCase(){
    	
        actor=new ArrayList<>();
        actor.add(0,new Actor());
        actor.get(0).setName("Actor1");
        actor.add(1,new Actor());
        actor.get(1).setName("Actor2");
        
        shareholder=new ArrayList<>();
        shareholder.add(0,new Shareholder());
        shareholder.get(0).setName("Action1");
        shareholder.get(0).setDescription("description");
        shareholder.add(1,new Shareholder());
        shareholder.get(1).setName("Action2");
        shareholder.get(1).setDescription("description");
        shareholder.add(2,new Shareholder());
        shareholder.get(2).setName("Action3");
        shareholder.get(2).setDescription("description");


    }

}


