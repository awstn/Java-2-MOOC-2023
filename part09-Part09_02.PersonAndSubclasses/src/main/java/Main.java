import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        // write your test code here
        
        Student ollie = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
        System.out.println(ollie);
        ollie.study();
        Person olliePerson = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
        System.out.println(olliePerson);
        //olliePerson.study();
        Object ollieObject = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
        System.out.println(ollieObject);

        Object alice = new Student("Alice", "177 Stewart Ave. Farmington, ME 04938");
        System.out.println(alice);

    }
    
    public static void printPersons(ArrayList<Person> persons){
        for (Person i : persons){
            System.out.println(i);
        }
    }

}
