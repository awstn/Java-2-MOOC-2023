import java.util.ArrayList;
import java.util.List;

public class MainProgram {

    public static void main(String[] args) {
        // test your classes here
        
        List<Person> communityCollege = new ArrayList<>();
        communityCollege.add(new Person("Austin", Education.BA));
        communityCollege.add(new Person("Angela", Education.MA));
        communityCollege.add(new Person("Michael", Education.BA));
        
        Employees university = new Employees();
        
        university.add(new Person("Petreus", Education.PHD));
        university.add(new Person("Arto", Education.HS));
        university.add(new Person("Elina", Education.PHD));
        university.add(communityCollege);
        
        university.print();
        
        university.fire(Education.HS);
        
        System.out.println("==");
        
        university.print();
    }
}
