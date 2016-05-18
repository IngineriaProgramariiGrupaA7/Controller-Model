/**
 * Created by root on 10.05.2016.
 */
import ActivityDiagram.ActivityXmlDiagram;
import PdfGenerator.PdfGenerator;
import UseCaseDiagram.ModelUseCase;
import UseCaseDiagram.XmlDocument;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.eclipse.jetty.http.HttpStatus;
import FisaCerintelor.FisaCerintelor;

import javax.servlet.http.HttpServletResponse;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import static spark.Spark.*;

public class Main {
    public static void main (String[] args) {
        port(Configuration.PORT);
        threadPool(Configuration.MAX_THREAD_COUNT, Configuration.MIN_THREAD_COUNT, Configuration.IDLE_TIMEOUT);
        staticFileLocation("/site");
        PdfGenerator gen = new PdfGenerator(new FisaCerintelor(true));
        gen.generatePdf("E:\\FisaCerinte.pdf");

        get("/", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });

        get("/JSON", ((request, response) -> {
            FisaCerintelor fisaCerinte = new FisaCerintelor(true);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, fisaCerinte);

            response.type("application/json");
            response.status(HttpStatus.OK_200);
            return sw.toString();
        }));

        get("/UseCaseXML", ((request, response) -> {
            FisaCerintelor fisaCerinte = new FisaCerintelor(true);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, fisaCerinte);

            response.type("application/xml");
            response.status(HttpStatus.OK_200);

            fisaCerinte = new FisaCerintelor(true);
            ModelUseCase model = new ModelUseCase();
            model.fromFisaCerintelor(fisaCerinte);
            return (new XmlDocument(model).toString());
        }));

        get("/ActivityXML", ((request, response) -> {
            FisaCerintelor fisaCerinte = new FisaCerintelor(true);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, fisaCerinte);

            response.type("application/xml");
            response.status(HttpStatus.OK_200);

            fisaCerinte = new FisaCerintelor(true);
            return (new ActivityXmlDiagram(fisaCerinte.getModelActivity()).toString());
        }));

        get("/PDF", ((request, response) -> {
            FisaCerintelor fisaCerinte = new FisaCerintelor(true);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, fisaCerinte);

            response.type("application/pdf");
            response.status(HttpStatus.OK_200);

            byte[] bytes = Files.readAllBytes(Paths.get("E:\\FisaCerinte.pdf"));
            HttpServletResponse raw = response.raw();

            raw.getOutputStream().write(bytes);
            raw.getOutputStream().flush();
            raw.getOutputStream().close();


            return response.raw();
        }));

        post("/fisaCerinte", (request, response) -> {
            FisaCerintelor fisaCerinte = null;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                fisaCerinte = objectMapper.readValue(request.body(), FisaCerintelor.class);
            } catch (JsonParseException e) {
                response.status(HttpStatus.BAD_REQUEST_400);
                return e.toString();
            }

            String responseBody = null;
            System.out.println(responseBody);

            if (responseBody.equals("failed")) {
                response.status(HttpStatus.INTERNAL_SERVER_ERROR_500);
                return "XML transformation failed";
            }

            response.body("application/xml");
            response.status(HttpStatus.OK_200);
            fisaCerinte = new FisaCerintelor(true);
            ModelUseCase model = new ModelUseCase();
            model.fromFisaCerintelor(fisaCerinte);
            return (new XmlDocument(model).toString());
        });
    }
}
