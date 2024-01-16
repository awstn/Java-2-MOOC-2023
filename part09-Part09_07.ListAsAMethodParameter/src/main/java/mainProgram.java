import java.util.List;
import java.util.ArrayList;
import static java.util.Collections.list;

public class mainProgram {

    public static void main(String[] args) {
        // test your method here
        List<String> names = new ArrayList<>();
        names.add("First");
        names.add("Second");
        names.add("Third");

        System.out.println(returnSize(names));

    }

    // Implement here a method returnSize
    // which returns the size of the list given to it
    //as a parameter
    
    public static int returnSize(List list){
        return list.size();
    }
    
}
