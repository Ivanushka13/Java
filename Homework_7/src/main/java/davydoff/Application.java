package davydoff;

import com.fasterxml.jackson.core.JsonProcessingException;
import davydoff.console.OutputHandler;
import davydoff.file.JsonWriter;
import davydoff.logic.Serializer;

import java.io.IOException;

/**
 * Class contains all cycle of the program from
 * start to end.
 */
public class Application {

    public static void run(Object obj) {

        OutputHandler.printIntro();

        Serializer serializer = new Serializer();

        try {
            // Getting all fields of an object.
            serializer.getFields(obj);

            // Print all fields with their values to condole.
            OutputHandler.printObjFields(obj, serializer.getJsonFields());

            // Getting from user new names for fields.
            serializer.getNamedFields();

            // Print new user named fields with their values.
            OutputHandler.printFinalObject(serializer.getJsonFields());

            // Print the result in json file (example.json)
            JsonWriter.printResultToFile(serializer.getJsonFields());

            // Print that result is recorded to file
            OutputHandler.printSuccess();

        } catch (IllegalAccessException ex) {

            System.out.println("Object with uninitialized fields cannot be serialized.");
            System.exit(1);

        } catch (NullPointerException ex) {
            System.out.println("Fields of an object for serializing cannot be null.");
        } catch (JsonProcessingException ex) {

            System.out.println("Something went wrong.");
            System.exit(1);

        } catch (IOException ex) {
            System.out.println("Wrong way to file.");
            System.exit(1);
        }
    }
}
