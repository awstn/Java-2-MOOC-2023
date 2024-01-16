import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class BookDatabase {
    private List<Book> database;
    
    public BookDatabase(){
        this.database = new ArrayList<>();
    }
    
    public void addBook(Book book){
        this.database.add(book);
    }
    
    public void sortContents(){
        Comparator<Book> comparator = Comparator
                .comparing(Book::getAgeRec)
                .thenComparing(Book::getName);
        
        Collections.sort(database, comparator);
    }
    
    public void printContents(){
        
        sortContents();  
        System.out.println(this.database.size() + " books in total.");
        System.out.println("\nBooks:");
    
        this.database.stream()
                .map(book -> book)                
                .forEach(book -> System.out.println(book));
    }
}
