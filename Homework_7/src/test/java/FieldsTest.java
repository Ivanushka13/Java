import davydoff.console.InputHandler;
import davydoff.logic.Serializer;
import davydoff.models.Person;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldsTest {

    @Test
    void gettingFieldsTest() {
        Person person = new Person("Ivan", "Davydov", 23);
        Serializer serializer = new Serializer();
        Map<String, String> fields = serializer.getJsonFields();
        try {
            serializer.getFields(person);
            for (var key : fields.keySet()) {
                if (Objects.equals(key, "name")) {
                    assertEquals("Ivan", fields.get(key));
                } else if (Objects.equals(key, "sureName")) {
                    assertEquals("Davydov", fields.get(key));
                } else {
                    assertEquals("23", fields.get(key));
                }
            }
        } catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }

    @Test
    void gettingNamedFields() {
        Person person = new Person("Ivan", "Davydov", 23);
        Serializer serializer = new Serializer();
        try {
            serializer.getFields(person);
            String name = InputHandler.getFieldName();
            String sureName = InputHandler.getFieldName();
            String age = InputHandler.getFieldName();
            serializer.getNamedFields();
            Map<String, String> fields = serializer.getJsonFields();
            for (var key : fields.keySet()) {
                if (Objects.equals(key, name)) {
                    assertEquals("Ivan", fields.get(key));
                } else if (Objects.equals(key, sureName)) {
                    assertEquals("Davydov", fields.get(key));
                } else {
                    assertEquals("23", fields.get(key));
                }
            }
        } catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
