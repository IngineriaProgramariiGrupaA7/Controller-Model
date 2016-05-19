/**
 * Created by root on 10.05.2016.
 */
import ActivityDiagram.ActivityXmlDiagram;
import ActivityDiagram.ModelActivity;
import FisaCerinte.FisaCerintelor;
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
            Diagram diagram = new Diagram(fisaCerintelorJson.getUsecases());
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
            System.out.println(fisaCerinte);

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
