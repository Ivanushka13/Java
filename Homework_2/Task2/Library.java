public class Library {
    private final Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public void getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                System.out.print("Title: " + book.getTitle() + "\n");
                System.out.print("Author: " + book.getAuthor() + "\n");
                System.out.println("Id: " + book.getId() + "\n");
                return;
            }
        }
        System.out.println("The is no book with such id.\n");
    }

    public void getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle() == title) {
                System.out.print("Title: " + book.getTitle() + "\n");
                System.out.print("Author: " + book.getAuthor() + "\n");
                System.out.println("Id: " + book.getId() + "\n");
                return;
            }
        }
        System.out.println("The is no book with such title.\n");
    }

    public void getAllBooks() {
        System.out.println("----------------------------");
        for (Book book : books) {
            System.out.print("Title: " + book.getTitle() + "\n");
            System.out.print("Author: " + book.getAuthor() + "\n");
            System.out.println("Id: " + book.getId());
            System.out.println("----------------------------");
        }
    }
}
