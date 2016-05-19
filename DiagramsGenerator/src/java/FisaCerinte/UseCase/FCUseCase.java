package FisaCerinte.UseCase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FCUseCase {

    String title;
    String objective;
    List<String> actors = new ArrayList<>();
    List<Step> steps = new ArrayList<>();
    List<Extension> extensions = new ArrayList<>();
    List<FCRelationship> relationships = new ArrayList<>();

    public FCUseCase() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public List<Extension> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<Extension> extensions) {
        this.extensions = extensions;
    }

    public List<FCRelationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<FCRelationship> relationships) {
        this.relationships = relationships;
    }
}
