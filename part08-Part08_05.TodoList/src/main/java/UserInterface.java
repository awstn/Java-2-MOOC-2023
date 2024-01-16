import java.util.Scanner;

public class UserInterface {
    private Scanner scan;
    private TodoList todoList;
    
    public UserInterface(TodoList todoList, Scanner scan){
        this.scan = scan;
        this.todoList = todoList;
    }
    
    public void start(){
        while (true){
            System.out.println("Command:");
            String command = this.scan.nextLine();
            
            if (command.equals("stop")){
                break;
            }
            
            if (command.equals("add")){
                System.out.println("To add:");
                String task = this.scan.nextLine();
                this.todoList.add(task);
            }
            
            if (command.equals("list")){
                this.todoList.print();
            }
            
            if (command.equals("remove")){
                System.out.println("Which one is removed?");
                int index = Integer.valueOf(this.scan.nextLine());
                this.todoList.remove(index);
            }
        }
    }
    
    
    
}
