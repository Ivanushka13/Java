import com.fasterxml.jackson.core.JsonProcessingException;
import davydoff.file.JsonWriter;
import davydoff.logic.Serializer;
import davydoff.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SerializeTest {

    @Test
    @DisplayName("Serialization object with not null fields")
    void test_serialization_object_with_not_null_fields() throws IllegalAccessException, IOException {
        Person person = new Person("Nickolay", "Chuikin", 25);
        String result = "{\"name\":\"Nickolay\",\"sureName\":\"Chuikin\",\"age\":25}";
        Serializer serializer = new Serializer();

        serializer.getFields(person);
        String res = JsonWriter.getResultAsString(serializer.getJsonFields());

        Assertions.assertEquals(res, result);
    }

    @Test
    @DisplayName("Serialization object with null object")
    void test_serialization_object_with_null_object() throws JsonProcessingException {
        Person person = null;
        Serializer serializer = new Serializer();

        Assertions.assertThrows(IllegalAccessException.class, () -> serializer.getFields(person));
        Assertions.assertEquals(JsonWriter.getResultAsString(serializer.getJsonFields()), "{}");
    }

    @Test
    @DisplayName("Serialization object with one null field")
    void test_serialization_object_with_one_null_field() throws IllegalAccessException, JsonProcessingException {
        Person person = new Person("Nickolay", null, 25);
        String result = "{\"name\":\"Nickolay\",\"sureName\":null,\"age\":25}";

        Serializer serializer = new Serializer();

        serializer.getFields(person);
        String res = JsonWriter.getResultAsString(serializer.getJsonFields());

        Assertions.assertEquals(res, result);
    }

    @Test
    @DisplayName("Serialization object with null fields")
    void test_serialization_object_with_null_fields() throws IllegalAccessException, JsonProcessingException {
        Person person = new Person(null, null, 0);
        String result = "{\"name\":null,\"sureName\":null,\"age\":0}";

        Serializer serializer = new Serializer();

        serializer.getFields(person);
        String res = JsonWriter.getResultAsString(serializer.getJsonFields());

        Assertions.assertEquals(res, result);
    }
}
