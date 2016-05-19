
package FisaCerinte;

import ActivityDiagram.ModelActivity;
import FisaCerinte.UseCase.FCUseCase;

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
    public List<String> authors = new ArrayList<>();
    public String description;
    public String domain;
    public List<StakeholderAndInterest> stakeholdersAndInterests = new ArrayList<>();
    public List<ActorAndObjective> actorsAndObjectives = new ArrayList<>();
    public List<FCUseCase> usecases = new ArrayList<>();
    //public ModelActivity activities = new ModelActivity();

 /*   public FisaCerintelor(boolean sample){

        title="Title";

        this.authors=new ArrayList<Author>();
        authors.add(new Author("Autor1"));
        authors.add(new Author("Autor2"));

        String desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tincidunt vehicula sapien quis molestie. Nunc interdum purus eget interdum consectetur. Aenean ac dolor sapien. Vivamus tempus ante vitae sem malesuada, quis malesuada sem placerat. In eget nibh nisl. Praesent porttitor dolor nec velit cursus ultrices. Aliquam vitae dignissim nisi. Praesent imperdiet, arcu ac semper luctus, dolor purus viverra libero, sit amet rutrum felis quam ut magna. Aliquam blandit lorem non ex gravida vulputate ut vitae nulla. Donec in sollicitudin nisl, at scelerisque risus.";
        description=new Description(desc);

        domain=new Domain("Sed tempus diam et tellus gravida dictum. Vivamus nec dictum risus. Praesent ac porta tellus. Nunc in facilisis justo, et pretium nisl. Nam sed nunc mollis, euismod orci eget, scelerisque ante. Fusce at augue non nisl condimentum venenatis in vel nisi. Praesent vulputate augue est, in laoreet lorem dignissim non. Praesent eleifend diam nibh, eget efficitur lectus tincidunt nec. Morbi hendrerit elit sit amet ex rutrum, sed tincidunt metus mattis. Donec varius libero eget lectus condimentum gravida. Suspendisse molestie ac ligula finibus sodales.");

        stakeholders=new ArrayList<>();
        stakeholders.add(0,new StakeholderAndInterest());
        stakeholders.get(0).setName("stakeholders");
        stakeholders.get(0).setInterest("Nam iaculis sagittis gravida. Mauris in elementum nisi. Nulla rutrum, odio non blandit laoreet, quam me");
        stakeholders.add(1,new StakeholderAndInterest());
        stakeholders.get(1).setName("stakeholders");
        stakeholders.get(1).setInterest("Nam iaculis sagittis gravida. Mauris in elementum nisi. Nulla rutrum, odio non blandit laoreet, quam me");

        actors=new ArrayList<>();
        actors.add(0,new ActorAndObjective());
        actors.get(0).setName("stakeholder1");
        actors.get(0).setObjective("Nunc fermentum cursus maximus. Nulla at tellus dapibus, cursus lacus at, tristique mauris. Nam eu mauris et tortor congue tincidunt. Vivamus semper nunc a diam iaculis sodales. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus dapibus, leo ut auctor dictum, nulla felis lacinia nisi, et posuere sem odio a nisi. Maecenas ac fermentum lorem, nec lobortis dui. Nam tellus elit, ultrices eu accumsan eu, consequat id elit. In a quam sodales ipsum aliquam blandit. Curabitur placerat sapien pulvinar imperdiet lacinia.");
        actors.add(1,new ActorAndObjective());
        actors.get(1).setName("stakeholder2");
        actors.get(1).setObjective("Nam iaculis sagittis gravida. Mauris in elementum nisi. Nulla rutrum, odio non blandit laoreet, quam metus feugiat sapien, ac rhoncus nisi diam vel ligula. Sed eget velit eget erat tempus egestas quis nec magna. Nulla maximus venenatis tincidunt. Vivamus dolor nulla, convallis a nisi non, rhoncus scelerisque leo. Mauris eget dignissim augue.");

        this.useCases = new ArrayList<>();

        FCUseCase fcUseCase;

        // UseCase 1:
        fcUseCase = new FCUseCase();

        fcUseCase.setTitle("A title");
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

        activities = new ModelActivity();
    }    */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<StakeholderAndInterest> getStakeholdersAndInterests() {
        return stakeholdersAndInterests;
    }

    public void setStakeholdersAndInterests(List<StakeholderAndInterest> stakeholdersAndInterests) {
        this.stakeholdersAndInterests = stakeholdersAndInterests;
    }

    public List<ActorAndObjective> getActorsAndObjectives() {
        return actorsAndObjectives;
    }

    public void setActorsAndObjectives(List<ActorAndObjective> actorsAndObjectives) {
        this.actorsAndObjectives = actorsAndObjectives;
    }

    public List<FCUseCase> getUsecases() {
        return usecases;
    }

    public void setUsecases(List<FCUseCase> usecases) {
        this.usecases = usecases;
    }

    /*public ModelActivity getActivities() {
        return activities;
    }

    public void setActivities(ModelActivity activities) {
        this.activities = activities;
    }*/
}

