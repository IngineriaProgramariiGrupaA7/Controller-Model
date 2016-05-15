
package src;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by m on 4/26/16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ModelFisaCerinte {

    private AppDescription appDescription;
    private Domain domain;
    private List<Shareholder> shareholder;
    private List<Actor> actor;
    private UsageScenario usageScenario;
    private Extension extension;
    private ObjectiveContext objectiveContext;
    private ScenarioStep scenarioStep;


    public ModelFisaCerinte(){

        appDescription=new AppDescription();
        appDescription.setDescription("description text");

        domain=new Domain();
        domain.setDescription("domain text");

        shareholder=new ArrayList<>();
        shareholder.add(0,new Shareholder());
        shareholder.get(0).setName("shareholder");
        shareholder.get(0).setDescription("description");
        shareholder.add(1,new Shareholder());
        shareholder.get(1).setName("shareholder");
        shareholder.get(1).setDescription("description");

        actor=new ArrayList<>();
        actor.add(0,new Actor());
        actor.get(0).setName("actor");
        actor.get(0).setDescription("description");
        actor.add(1,new Actor());
        actor.get(1).setName("actor");
        actor.get(1).setDescription("description");


    }

}

