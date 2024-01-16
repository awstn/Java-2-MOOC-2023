import java.util.Scanner;

public class Application {
    private Scanner scanner;
    private BookDatabase bookDatabase;
    
    public Application(BookDatabase bookDatabase, Scanner scanner){
        this.scanner = scanner;
        this.bookDatabase = bookDatabase;
        
    }
    
    public void run(){
        
        while (true){
            System.out.println("Input the name of the book, empty stops: ");
            String input = scanner.nextLine();
            
            if (input.isEmpty()){
                break;
            }
            
            System.out.println("Input the age recommendation:");
            int ageRec = Integer.valueOf(scanner.nextLine());            
            Book newBook = new Book(input,ageRec);
            
            this.bookDatabase.addBook(newBook);           

        }
        
        this.bookDatabase.printContents();
        
        
    }
    
}
