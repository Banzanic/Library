import java.util.LinkedList;

public class Catalog {
    private LinkedList<Book> listOfAllBooks=new LinkedList<>();
    void addBook(String title,int isbn, Author author){
        listOfAllBooks.add(new Book(title, isbn, author));
    }
}
