package davydoff.file;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Class to write the result fields and values of an object to json file.
 */
public final class JsonWriter {

    public static void printResultToFile(Map<String, String> fields) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/example.json"), fields);
    }
}
