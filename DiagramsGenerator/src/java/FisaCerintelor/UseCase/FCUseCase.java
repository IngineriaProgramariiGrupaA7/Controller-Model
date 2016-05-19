package FisaCerintelor.UseCase;

import java.util.List;

/**
 *
 * @author Daniel
 */
public class FCUseCase {

    String title;
    String objectiveAndContext;
    List<FCActor> actors;
    List<Step> steps;
    List<Extension> extensions;
    List<FCRelationship> relationships;

    public FCUseCase() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setObjectiveAndContext(String objectiveAndContext) {
        this.objectiveAndContext = objectiveAndContext;
    }

    public void setActors(List<FCActor> actors) {
        this.actors = actors;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public void setExtensions(List<Extension> extensions) {
        this.extensions = extensions;
    }

    public void setRelationships(List<FCRelationship> relationships) {
        this.relationships = relationships;
    }

    public String getTitle() {
        return title;
    }

    public String getObjectiveAndContext() {
        return objectiveAndContext;
    }

    public List<FCActor> getActors() {
        return actors;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public List<Extension> getExtensions() {
        return extensions;
    }

    public List<FCRelationship> getRelationships() {
        return relationships;
    }

}
