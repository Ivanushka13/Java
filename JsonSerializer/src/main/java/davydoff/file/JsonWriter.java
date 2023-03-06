package davydoff.file;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Class to write the result fields and values of an object to json file.
 */
public final class JsonWriter {

    private static final ObjectMapper MAPPER = new ObjectMapper();


    public static void printResultToFile(Map<String, Object> fields) throws IOException {
        MAPPER.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/example.json"), fields);
    }

    public static String getResultAsString(Map<String, Object> fields) throws JsonProcessingException {
        return MAPPER.writeValueAsString(fields);
    }
}
