package davydoff.console;

import java.util.Map;

public class OutputHandler {

    public static void printIntro() {
        System.out.println();
        System.out.println("<--------- Welcome to Serializer --------->");
        System.out.println();
    }

    public static void printObjFields(Object obj, Map<String, String> fields) {
        System.out.println("Serialize object " + obj.getClass().getName() +
                " with fields:");
        for (String name : fields.keySet()) {
            System.out.println("\"" + name + "\"" + ": " + fields.get(name));
        }
    }

    public static void printWrongInputError() {
        System.out.println("Wrong input, please write only one word.");
        System.out.print("--> ");
    }

    public static void printWrongValueError(String value) {
        System.out.println("The field " + "\"" + value + "\"" + " is already used, please write different names of fields.");
        System.out.print("--> ");
    }

    public static void printToInputFieldName(String name) {
        System.out.println();
        System.out.println("Write a json field name for a object name: " + "\"" + name + "\"");
        System.out.print("--> ");
    }

    public static void printFinalObject(Map<String, String> fields) {
        System.out.println();
        System.out.println("Final json file will contain these fields:");
        for (String key : fields.keySet()) {
            System.out.println(key + ": " + fields.get(key));
        }
        System.out.println();
    }

    public static void printSuccess() {
        System.out.println("Object was recorded in file example.json.");
        System.out.println("Thank you for using my Serializer!");
    }
}
