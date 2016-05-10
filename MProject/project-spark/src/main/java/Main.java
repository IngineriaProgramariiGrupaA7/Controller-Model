/**
 * Created by root on 10.05.2016.
 */
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.*;
import org.eclipse.jetty.http.HttpStatus;
import spark.Filter;

import javax.servlet.http.Part;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static spark.Spark.*;

public class Main {
    public static void main (String[] args) {
        port(Configuration.PORT);
        threadPool(Configuration.MAX_THREAD_COUNT, Configuration.MIN_THREAD_COUNT, Configuration.IDLE_TIMEOUT);
        staticFileLocation("/site");

        get("/", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });

        get("/fisaCerinte", ((request, response) -> {
            ModelFisaCerinte fisaCerinte = new ModelFisaCerinte(
                new Descriere(),
                new Domeniu(),
                new ActionariInterese(),
                new ActoriObiective(),
                new ScenariiDeUtilizare()
            );

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, fisaCerinte);

            response.type("application/json");
            response.status(HttpStatus.OK_200);
            return sw.toString();
        }));

        post("/fisaCerinte", (request, response) -> {
            ModelFisaCerinte fisaCerinte = null;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                fisaCerinte = objectMapper.readValue(request.body(), ModelFisaCerinte.class);
            } catch (JsonParseException e) {
                response.status(HttpStatus.BAD_REQUEST_400);
                return e.toString();
            }

            String responseBody = fisaCerinte.makeXML();

            if (responseBody.equals("failed")) {
                response.status(HttpStatus.INTERNAL_SERVER_ERROR_500);
                return "XML transformation failed";
            }

            response.body("application/xml");
            response.status(HttpStatus.OK_200);
            return responseBody;
        });
    }
}
