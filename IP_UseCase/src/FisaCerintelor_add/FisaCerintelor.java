package FisaCerintelor_add;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class FisaCerintelor {

    //    List<FCUseCase> useCases; - trebuie adaugat Fisei Cerintelor (clasei ModelFisaCerinte) impreuna cu toate clasele ce le foloseste.
    //    Note: Prefixul 'FC' (de la FisaCerintelor) din numele unor clase din acest pachet (FisaCerintelor_add) este pentru a nu confunda
    // clasele cu acelasi nume din pachetul UseCaseDiagram, desi unele clase sunt exact la fel.
    List<FCUseCase> useCases;

    public FisaCerintelor() {
    }

    public FisaCerintelor(int test) {

        // Constructor folosit la crearea unei Fise a Cerintelor dupa modelul de XML cerut de la Echipa - View2 (Use Case Diagram);
        // Scop: TESTARE;
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
