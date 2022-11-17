public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Java Developer Course", "Chochuck", 1);
        Book book2 = new Book("Java for Begginers", "Aleksandr", 2);
        Book book3 = new Book("Java for Intermediate", "Aleksandrovich", 3);

        Book[] books = new Book[]{book1, book2, book3};

        Library library = new Library(books);

        library.getBookById(1);
        library.getBookById(3);

        library.getBookByTitle("Java for Begginers");
        library.getBookByTitle("Java for Noobs");

        library.getAllBooks();
    }
}
