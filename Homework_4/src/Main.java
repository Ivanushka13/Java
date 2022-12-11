public class Main {
    public static void main(String[] args) {
        FileIterator fileIterator = new FileIterator("input.txt");

        System.out.println(fileIterator.hasNext());
        System.out.println(fileIterator.next());

        while (fileIterator.hasNext()) {
            System.out.println(fileIterator.next());
        }

        System.out.println(fileIterator.hasNext());
    }
}
