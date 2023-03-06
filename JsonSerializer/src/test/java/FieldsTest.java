import davydoff.logic.Serializer;
import davydoff.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FieldsTest {

    @Test
    @DisplayName("Get not null fields of serializable object")
    void test_not_null_fields_of_serializable_object() throws IllegalAccessException {
        Person person = new Person("Nikolay", "Chuikin", 25);
        Serializer serializer = new Serializer();

        Map<String, Object> mp = new HashMap<>();
        mp.put("name", "Nikolay");
        mp.put("sureName", "Chuikin");
        mp.put("age", 25);

        serializer.getFields(person);
        Assertions.assertEquals(mp, serializer.getJsonFields());
    }

    @Test
    @DisplayName("Get fields of serializable null object")
    void test_fields_of_serializable_object_if_object_is_null() throws IllegalAccessException {
        Person person = null;
        Serializer serializer = new Serializer();

        Assertions.assertThrows(IllegalAccessException.class, () -> serializer.getFields(person));
    }

    @Test
    @DisplayName("Get fields of serializable object with one null field")
    void test_fields_of_serializable_object_if_one_of_them_is_null() throws IllegalAccessException {
        Person person = new Person("Nikolay", null, 25);

        Map<String, Object> mp = new HashMap<>();
        mp.put("name", "Nikolay");
        mp.put("sureName", null);
        mp.put("age", 25);

        Serializer serializer = new Serializer();

        serializer.getFields(person);
        Assertions.assertEquals(serializer.getJsonFields(), mp);
    }

    @Test
    @DisplayName("Get null fields of serializable object")
    void test_fields_of_serializable_object_if_they_are_null() throws IllegalAccessException {
        Person person = new Person(null, null, 0);

        Map<String, Object> mp = new HashMap<>();
        mp.put("name", null);
        mp.put("sureName", null);
        mp.put("age", 0);

        Serializer serializer = new Serializer();

        serializer.getFields(person);
        Assertions.assertEquals(serializer.getJsonFields(), mp);
    }
}
