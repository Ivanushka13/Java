package davydoff.logic;

import com.fasterxml.jackson.annotation.JsonProperty;
import davydoff.console.InputHandler;
import davydoff.console.OutputHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for serializing objects to json.
 * Inside there is a Map of Strings that contains
 * field names that will be in json file as keys,
 * and values of object fields as values.
 * <p>
 * Provides method for getting all fields, that are marked as
 * JsonProperty; method for rename the fields, that will be in json file;
 * and also fields and theirs values.
 */
public final class Serializer {

    private Map<String, String> jsonFields = new HashMap<>();

    // Method for getting all object fields, that are marked as JsonProperty.
    public void getFields(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            var annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == JsonProperty.class) {
                    field.setAccessible(true);
                    jsonFields.put(field.getName(), field.get(obj).toString());
                }
            }
        }
    }

    // Method for rename the Map keys(fields) from console.
    public void getNamedFields() {
        Map<String, String> newJsonFields = new HashMap<String, String>();
        for (String name : jsonFields.keySet()) {
            OutputHandler.printToInputFieldName(name);
            String newName = InputHandler.getFieldName();
            while(newJsonFields.containsKey(newName)) {
                OutputHandler.printWrongValueError(newName);
                newName = InputHandler.getFieldName();
            }
            newJsonFields.put(newName, jsonFields.get(name));
        }
        jsonFields.clear();
        jsonFields = newJsonFields;
    }

    public Map<String, String> getJsonFields() {
        return jsonFields;
    }
}
