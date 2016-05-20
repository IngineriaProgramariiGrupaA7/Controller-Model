package UseCaseDiagram;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 *
 * Class that models usecases tags in usecase xml
 * Contains actors, actions, relationships
 *
 */
@XmlRootElement(name = "usecase")
@XmlAccessorType(XmlAccessType.FIELD)
public class UseCase {

    @XmlElement(name = "actor")
    List<String> actors;

    @XmlElement(name = "action")
    List<Action> actions;

    @XmlElement(name = "relationship")
    List<Relationship> relationships;

    public UseCase() {
    }

    public UseCase(int test) {

        this.actors = new ArrayList<>();
        this.actions = new ArrayList<>();
        this.relationships = new ArrayList<>();

        this.actors.add("Student");

        this.actors.add("Secretariat");

        this.actions.add(0, new Action());
        this.actions.get(0).setName("Actualizare note");
        this.actions.get(0).setDescription("Secretariatul actualizeaza notele studentilor");

        this.actions.add(1, new Action());
        this.actions.get(1).setName("Vizualizare note");
        this.actions.get(1).setDescription("Studentul vizualizeaza notele");

        this.actions.add(2, new Action());
        this.actions.get(2).setName("Logare");
        this.actions.get(2).setDescription("Vizitatorul incearca sa se logheze");

        this.relationships.add(0, new Relationship());
        this.relationships.get(0).setType("association");
        this.relationships.get(0).setFrom("Secretariat");
        this.relationships.get(0).setTo("Logare");

        this.relationships.add(1, new Relationship());
        this.relationships.get(1).setType("association");
        this.relationships.get(1).setFrom("Student");
        this.relationships.get(1).setTo("Logare");

        this.relationships.add(2, new Relationship());
        this.relationships.get(2).setType("association");
        this.relationships.get(2).setFrom("Student");
        this.relationships.get(2).setTo("Vizualizare note");

        this.relationships.add(3, new Relationship());
        this.relationships.get(3).setType("association");
        this.relationships.get(3).setFrom("Secretariat");
        this.relationships.get(3).setTo("Actualizare note");

        this.relationships.add(4, new Relationship());
        this.relationships.get(4).setType("include");
        this.relationships.get(4).setFrom("Vizualizare note");
        this.relationships.get(4).setTo("Logare");

        this.relationships.add(5, new Relationship());
        this.relationships.get(5).setType("include");
        this.relationships.get(5).setFrom("Actualizare note");
        this.relationships.get(5).setTo("Logare");
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    public List<String> getActors() {
        return actors;
    }

    public List<Action> getActions() {
        return actions;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

}
