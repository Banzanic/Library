import java.util.LinkedList;

public class Book {
    private final String title;
    private final Author author;
    private final int isbn;
    private static int numberOfAllCopies=0;
    private LinkedList<Copy> listOfAllCopies=new LinkedList<>();

    public Book(String title, int isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author=author;
    }

    public String getTitle() {
        return title;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getNumberOfAllCopies(){
        return numberOfAllCopies;
    }

    public void addCopy(){
        numberOfAllCopies++;
        listOfAllCopies.add(new Copy(numberOfAllCopies, CopyStatus.AVAILABLE));
    }

}
