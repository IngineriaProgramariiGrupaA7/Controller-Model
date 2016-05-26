/**
 * Created by root on 10.05.2016.
 */
import ActivityDiagram.ActivityXmlDiagram;
import ActivityDiagram.ModelActivity;
import FisaCerinte.FisaCerintelor;
import FisaCerinte.UseCase.Extension;
import FisaCerinte.UseCase.FCRelationship;
import FisaCerinte.UseCase.FCUseCase;
import FisaCerinte.UseCase.Step;
import PdfGenerator.PdfGenerator;
import UseCaseDiagram.ModelUseCase;
import UseCaseDiagram.XmlDocument;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.eclipse.jetty.http.HttpStatus;
import view2.diagramgenerator.DiagramGenerator;
import view2.model.Diagram;

import javax.servlet.http.HttpServletResponse;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static spark.Spark.*;

public class Main {
    private static FisaCerintelor fisaCerintelorJson = null;

    public static void main (String[] args) {
        port(Configuration.PORT);
        threadPool(Configuration.MAX_THREAD_COUNT, Configuration.MIN_THREAD_COUNT, Configuration.IDLE_TIMEOUT);
        staticFileLocation("/site");

        get("/", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });

        get("/json", ((request, response) -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, fisaCerintelorJson);

            response.type("application/json");
            response.status(HttpStatus.OK_200);
            return sw.toString();
        }));

        get("/xml/useCase", ((request, response) -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, fisaCerintelorJson);

            response.type("application/xml");
            response.status(HttpStatus.OK_200);

            ModelUseCase model = new ModelUseCase();
            model.fromFisaCerintelor(fisaCerintelorJson);
            return (new XmlDocument(model).toString());
        }));

        get("/xml/activity", ((request, response) -> {
            response.type("application/xml");
            response.status(HttpStatus.OK_200);

            return (new ActivityXmlDiagram(new ModelActivity()).toString());
        }));

        get("/xml/download", ((request, response) -> {
            HttpServletResponse raw = response.raw();
            response.header("Content-Disposition", "attachment; filename=FisaCerinte.xml");
            response.type("application/force-download");

            byte[] bytes = (new XmlDocument(fisaCerintelorJson).toString().getBytes());

            try {
                raw.getOutputStream().write(bytes);
                raw.getOutputStream().flush();
                raw.getOutputStream().close();
            } catch (Exception e) {
                response.status(HttpStatus.INTERNAL_SERVER_ERROR_500);
                response.body(e.getMessage());
                return null;
            }

            response.status(HttpStatus.OK_200);
            return raw;
        }));

        get("/pdf", ((request, response) -> {
            PdfGenerator gen = new PdfGenerator(fisaCerintelorJson);
            gen.generatePdf("FisaCerinte.pdf");

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            response.type("application/pdf");
            response.status(HttpStatus.OK_200);

            byte[] bytes = Files.readAllBytes(Paths.get("FisaCerinte.pdf"));
            HttpServletResponse raw = response.raw();

            raw.getOutputStream().write(bytes);
            raw.getOutputStream().flush();
            raw.getOutputStream().close();

            return response.raw();
        }));

        get("/diagram", (request, response) -> {
            List<FCUseCase> usecases = fisaCerintelorJson.getUsecases();
            List<FCUseCase> useCasesForGraph = new LinkedList<FCUseCase>();

            usecases.forEach(usecase -> {
                FCUseCase useCase = new FCUseCase();

                useCase.setTitle(usecase.getTitle());
                useCase.setObjective(usecase.getObjective());

                List<String> actors = new ArrayList<String>();
                usecase.getActors().forEach(actor -> {
                    actors.add(fisaCerintelorJson.getActorsAndObjectives().get(Integer.parseInt(actor)).getName());
                });
                useCase.setActors(actors);

                List<Extension> extensions = new ArrayList<Extension>();
                usecase.getExtensions().forEach(extension -> {
                    if (extension.getStep() != null) {
                        Extension ex = new Extension();
                        ex.setDescription(extension.getDescription());
                        ex.setTitle(extension.getTitle());
                        ex.setStep(usecase.getSteps().get(Integer.parseInt(extension.getStep())).getTitle());

                        extensions.add(ex);
                    }
                });
                useCase.setExtensions(extensions);

                List<Step> steps = new ArrayList<Step>();
                usecase.getSteps().forEach(steps::add);
                useCase.setSteps(steps);

                List<FCRelationship> relationships = new ArrayList<FCRelationship>();
                usecase.getRelationships().forEach(relationship -> {
                    FCRelationship rl = new FCRelationship();
                    rl.setRelation(relationship.getRelation());

                    String[] rel = relationship.getEntity_1().split("_");
                    rl.setEntity_1(
                            rel[0].equals("step") ?
                                usecase.getSteps().get(Integer.parseInt(rel[1])).getTitle()
                                    : actors.get(Integer.parseInt(rel[1]))
                    );

                    rel = relationship.getEntity_2().split("_");
                    rl.setEntity_2(
                            rel[0].equals("step") ?
                                    usecase.getSteps().get(Integer.parseInt(rel[1])).getTitle()
                                    : actors.get(Integer.parseInt(rel[1]))
                    );
                    relationships.add(rl);
                });
                useCase.setRelationships(relationships);

                useCasesForGraph.add(useCase);
            });

            Diagram diagram = new Diagram(useCasesForGraph);
            DiagramGenerator generator = new DiagramGenerator();
            generator.generateDiagram(diagram, "site/diagram/index.html");

            response.redirect("/diagram/index.html");
            return null;
        });

        post("/fisaCerinte", (request, response) -> {
            FisaCerintelor fisaCerinte = null;
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                fisaCerinte = objectMapper.readValue(request.body(), FisaCerintelor.class);
            } catch (JsonParseException e) {
                response.status(HttpStatus.BAD_REQUEST_400);
                return e.toString();
            }

            fisaCerintelorJson = fisaCerinte;
            String responseBody = objectMapper.writeValueAsString(fisaCerinte);
            System.out.println(responseBody);

            if (responseBody.equals("failed")) {
                response.status(HttpStatus.INTERNAL_SERVER_ERROR_500);
                return "XML transformation failed";
            }

            response.type("application/json");
            response.status(HttpStatus.OK_200);
            return responseBody;
        });
    }
}
