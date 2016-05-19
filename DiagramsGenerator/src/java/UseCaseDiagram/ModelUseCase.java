package UseCaseDiagram;

import FisaCerintelor.FisaCerintelor;
import FisaCerintelor.UseCase.FCActor;
import FisaCerintelor.UseCase.FCRelationship;
import FisaCerintelor.UseCase.FCUseCase;
import FisaCerintelor.UseCase.Step;
import FisaCerintelor.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
@XmlRootElement(name = "diagram")
@XmlAccessorType(XmlAccessType.FIELD)
public class ModelUseCase {

    @XmlElement(name = "usecase")
    List<UseCase> useCases;

    public ModelUseCase() {
    }

    public void fromFisaCerintelor(FisaCerintelor fisaCerintelor) {

        List<UseCase> localUseCases = new ArrayList<>();

        int i;

        for (FCUseCase fcUseCase : fisaCerintelor.getUseCases()) {

            UseCase useCase = new UseCase();

            i = 0;

            List<Actor> actors = new ArrayList<>();

            for (FCActor fcActor : fcUseCase.getActors()) {

                actors.add(i, new Actor());
                actors.get(i).setName(fcActor.getName());

                ++i;
            }

            useCase.setActors(actors);

            i = 0;

            List<Action> actions = new ArrayList<>();

            for (Step step : fcUseCase.getSteps()) {

                actions.add(i, new Action());
                actions.get(i).setName(step.getTitleAction());
                actions.get(i).setDescription(step.getDescription());

                ++i;
            }

            useCase.setActions(actions);

            i = 0;

            List<Relationship> relationships = new ArrayList<>();

            for (FCRelationship fcRelationship : fcUseCase.getRelationships()) {

                relationships.add(i, new Relationship());
                relationships.get(i).setType(fcRelationship.getType());
                relationships.get(i).setFrom(fcRelationship.getFrom());
                relationships.get(i).setTo(fcRelationship.getTo());

                ++i;
            }

            useCase.setRelationships(relationships);

            localUseCases.add(useCase);

        }

        this.setUseCases(localUseCases);

    }

    public void setUseCases(List<UseCase> useCases) {
        this.useCases = useCases;
    }

    public List<UseCase> getUseCases() {
        return useCases;
    }

}
