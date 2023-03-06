import davydoff.file.JsonWriter;
import davydoff.logic.Serializer;
import davydoff.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileTest {

    @Test
    @DisplayName("Json file on object with not null fields")
    void test_json_file_on_object_with_not_null_fields() throws IllegalAccessException, IOException {
        Person person = new Person("Nickolay", "Chuikin", 25);
        String result = "{  \"name\" : \"Nickolay\",  \"sureName\" : \"Chuikin\",  \"age\" : 25}";
        Serializer serializer = new Serializer();

        serializer.getFields(person);
        JsonWriter.printResultToFile(serializer.getJsonFields());

        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/example.json"));
        String res = "";
        String curr;
        while ((curr = br.readLine()) != null) {
            res += curr;
        }

        Assertions.assertEquals(res, result);
    }

    @Test
    @DisplayName("Json file on object with one null field")
    void test_json_file_on_object_with_one_null_field() throws IllegalAccessException, IOException {
        Person person = new Person("Nickolay", null, 25);
        String result = "{  \"name\" : \"Nickolay\",  \"sureName\" : null,  \"age\" : 25}";

        Serializer serializer = new Serializer();

        serializer.getFields(person);
        JsonWriter.printResultToFile(serializer.getJsonFields());

        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/example.json"));
        String res = "";
        String curr;
        while ((curr = br.readLine()) != null) {
            res += curr;
        }

        Assertions.assertEquals(res, result);
    }

    @Test
    @DisplayName("Json file on null object")
    void test_json_file_on_null_object() throws IOException {
        Person person = null;
        Serializer serializer = new Serializer();

        JsonWriter.printResultToFile(serializer.getJsonFields());

        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/example.json"));
        String res = "";
        String curr;
        while ((curr = br.readLine()) != null) {
            res += curr;
        }

        Assertions.assertEquals(res, "{ }");
    }

    @Test
    @DisplayName("Json file on object with null fields")
    void test_json_file_on_object_with_null_fields() throws IllegalAccessException, IOException {
        Person person = new Person(null, null, 0);
        String result = "{  \"name\" : null,  \"sureName\" : null,  \"age\" : 0}";

        Serializer serializer = new Serializer();

        serializer.getFields(person);
        JsonWriter.printResultToFile(serializer.getJsonFields());

        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/example.json"));
        String res = "";
        String curr;
        while ((curr = br.readLine()) != null) {
            res += curr;
        }

        Assertions.assertEquals(res, result);
    }
}
