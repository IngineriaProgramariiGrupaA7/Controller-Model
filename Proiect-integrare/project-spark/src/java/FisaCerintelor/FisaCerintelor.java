
package FisaCerintelor;

import FisaCerintelor.UseCase.*;

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
public class FisaCerintelor {

    public String title;
    public List<Author> authors;
    public Description description;
    public Domain domain;
    public List<StakeholderAndInterest> stakeholders;
    public List<ActorAndObjective> actors;
    public List<FCUseCase> useCases;


    public FisaCerintelor(boolean sample){

        title="un titlu";

        this.authors=new ArrayList<Author>();
        authors.add(new Author("Autor1"));
        authors.add(new Author("Autor2"));

        description=new Description("description text");

        domain=new Domain("domain text");

        stakeholders=new ArrayList<>();
        stakeholders.add(0,new StakeholderAndInterest());
        stakeholders.get(0).setName("stakeholders");
        stakeholders.get(0).setInterest("description");
        stakeholders.add(1,new StakeholderAndInterest());
        stakeholders.get(1).setName("stakeholders");
        stakeholders.get(1).setInterest("description");

        actors=new ArrayList<>();
        actors.add(0,new ActorAndObjective());
        actors.get(0).setName("stakeholders1");
        actors.get(0).setObjective("description1");
        actors.add(1,new ActorAndObjective());
        actors.get(1).setName("stakeholders2");
        actors.get(1).setObjective("description2");

        this.useCases = new ArrayList<>();

        FCUseCase fcUseCase;

        // UseCase 1:
        fcUseCase = new FCUseCase();

        fcUseCase.setTitle("title");
        fcUseCase.setObjectiveAndContext("objectiveAndContext");

        List<FCActor> actors = new ArrayList<>();
        actors.add(0, new FCActor());
        actors.get(0).setName("Student");
        actors.add(1, new FCActor());
        actors.get(1).setName("Secretariat");
        fcUseCase.setActors(actors);

        List<Step> steps = new ArrayList<>();
        steps.add(0, new Step());
        steps.get(0).setTitleAction("Actualizare note");
        steps.get(0).setDescription("Secretariatul actualizeaza notele studentilor");
        steps.add(1, new Step());
        steps.get(1).setTitleAction("Vizualizare note");
        steps.get(1).setDescription("Studentul vizualizeaza notele");
        steps.add(2, new Step());
        steps.get(2).setTitleAction("Logare");
        steps.get(2).setDescription("Vizitatorul incearca sa se logheze");
        fcUseCase.setSteps(steps);

        List<Extension> extensions = new ArrayList<>();
        extensions.add(0, new Extension());
        extensions.get(0).setExtensionTitle("O extensie");
        extensions.get(0).setDescription("Aceasta este o descriere a unei extensii");
        extensions.get(0).setStepTitle("Titlul pasului");
        extensions.add(1, new Extension());
        extensions.get(1).setExtensionTitle("O extensie");
        extensions.get(1).setDescription("Aceasta este o descriere a unei extensii");
        extensions.get(1).setStepTitle("Titlul pasului");
        fcUseCase.setExtensions(extensions);

        List<FCRelationship> relationships = new ArrayList<>();
        relationships.add(0, new FCRelationship());
        relationships.get(0).setType("association");
        relationships.get(0).setFrom("Secretariat");
        relationships.get(0).setTo("Logare");
        relationships.add(1, new FCRelationship());
        relationships.get(1).setType("association");
        relationships.get(1).setFrom("Student");
        relationships.get(1).setTo("Logare");
        relationships.add(2, new FCRelationship());
        relationships.get(2).setType("association");
        relationships.get(2).setFrom("Student");
        relationships.get(2).setTo("Vizualizare note");
        relationships.add(3, new FCRelationship());
        relationships.get(3).setType("association");
        relationships.get(3).setFrom("Secretariat");
        relationships.get(3).setTo("Actualizare note");
        relationships.add(4, new FCRelationship());
        relationships.get(4).setType("include");
        relationships.get(4).setFrom("Vizualizare note");
        relationships.get(4).setTo("Logare");
        relationships.add(5, new FCRelationship());
        relationships.get(5).setType("include");
        relationships.get(5).setFrom("Actualizare note");
        relationships.get(5).setTo("Logare");
        fcUseCase.setRelationships(relationships);

        this.useCases.add(fcUseCase);

        // UseCase 2:
        fcUseCase = new FCUseCase();

        fcUseCase.setTitle("title");
        fcUseCase.setObjectiveAndContext("objectiveAndContext");

        actors = new ArrayList<>();
        actors.add(0, new FCActor());
        actors.get(0).setName("Student");
        actors.add(1, new FCActor());
        actors.get(1).setName("Secretariat");
        fcUseCase.setActors(actors);

        steps = new ArrayList<>();
        steps.add(0, new Step());
        steps.get(0).setTitleAction("Actualizare note");
        steps.get(0).setDescription("Secretariatul actualizeaza notele studentilor");
        steps.add(1, new Step());
        steps.get(1).setTitleAction("Vizualizare note");
        steps.get(1).setDescription("Studentul vizualizeaza notele");
        steps.add(2, new Step());
        steps.get(2).setTitleAction("Logare");
        steps.get(2).setDescription("Vizitatorul incearca sa se logheze");
        fcUseCase.setSteps(steps);

        extensions = new ArrayList<>();
        extensions.add(0, new Extension());
        extensions.get(0).setExtensionTitle("O extensie");
        extensions.get(0).setDescription("Aceasta este o descriere a unei extensii");
        extensions.get(0).setStepTitle("Titlul pasului");
        fcUseCase.setExtensions(extensions);

        relationships = new ArrayList<>();
        relationships.add(0, new FCRelationship());
        relationships.get(0).setType("association");
        relationships.get(0).setFrom("Secretariat");
        relationships.get(0).setTo("Logare");
        relationships.add(1, new FCRelationship());
        relationships.get(1).setType("association");
        relationships.get(1).setFrom("Student");
        relationships.get(1).setTo("Logare");
        relationships.add(2, new FCRelationship());
        relationships.get(2).setType("association");
        relationships.get(2).setFrom("Student");
        relationships.get(2).setTo("Vizualizare note");
        relationships.add(3, new FCRelationship());
        relationships.get(3).setType("association");
        relationships.get(3).setFrom("Secretariat");
        relationships.get(3).setTo("Actualizare note");
        relationships.add(4, new FCRelationship());
        relationships.get(4).setType("include");
        relationships.get(4).setFrom("Vizualizare note");
        relationships.get(4).setTo("Logare");
        relationships.add(5, new FCRelationship());
        relationships.get(5).setType("include");
        relationships.get(5).setFrom("Actualizare note");
        relationships.get(5).setTo("Logare");
        fcUseCase.setRelationships(relationships);

        this.useCases.add(fcUseCase);
    }

    public void setUseCases(List<FCUseCase> useCases) {
        this.useCases = useCases;
    }

    public List<FCUseCase> getUseCases() {
        return useCases;
    }
}

