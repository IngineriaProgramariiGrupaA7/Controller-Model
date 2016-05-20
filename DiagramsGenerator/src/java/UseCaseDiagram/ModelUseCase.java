package UseCaseDiagram;

import FisaCerinte.FisaCerintelor;
import FisaCerinte.UseCase.FCRelationship;
import FisaCerinte.UseCase.FCUseCase;
import FisaCerinte.UseCase.Step;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Daniel
 *
 * Class that models the diagram root tag in usecase xml
 * Contains objects of type usecase
 *
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

        for ( FCUseCase fcUseCase : fisaCerintelor.getUsecases()) {

            UseCase useCase = new UseCase();

            i = 0;

            List<String> actors = fcUseCase.getActors().stream().collect(Collectors.toList());

            useCase.setActors(actors);

            i = 0;

            List<Action> actions = new ArrayList<>();

            for (Step step : fcUseCase.getSteps()) {
                actions.add(i, new Action());
                actions.get(i).setName(step.getTitle());
                actions.get(i).setDescription(step.getDescription());
            }

            useCase.setActions(actions);

            i = 0;

            List<Relationship> relationships = new ArrayList<>();

            for (FCRelationship fcRelationship : fcUseCase.getRelationships()) {

                relationships.add(i, new Relationship());
                relationships.get(i).setType(fcRelationship.getRelation());
                relationships.get(i).setFrom(fcRelationship.getEntity_1());
                relationships.get(i).setTo(fcRelationship.getEntity_2());

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
