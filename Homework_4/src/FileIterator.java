import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

public class FileIterator implements Iterator<String> {
    private final String path;
    Scanner scanner;

    public FileIterator(String path) {
        this.path = path;

        try {
            scanner = new Scanner(new FileReader(path));
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot find such file or directory");
        }
    }

    @Override
    public boolean hasNext() {
        return scanner != null && scanner.hasNextLine();
    }

    @Override
    public String next() {
        if (hasNext()) {
            return scanner.nextLine();
        }
        throw new RuntimeException("No such element");
    }
}
