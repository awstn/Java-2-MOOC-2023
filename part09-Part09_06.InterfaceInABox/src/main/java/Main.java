
public class Main {

    public static void main(String[] args) {
        // test your classes here
        Box box = new Box(10);
        Box smallerBox = new Box(5);

        box.add(new Book("Fyodor Dostoevsky", "Crime and Punishment", 2)) ;
        box.add(new Book("Robert Martin", "Clean Code", 1));
        box.add(new Book("Kent Beck", "Test Driven Development", 0.7));

        box.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        box.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
        box.add(new CD("Rendezvous Park", "Closer to Being Here", 2012));
        
        smallerBox.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        
        box.add(smallerBox);
        box.add(new Box(0.1));

        System.out.println(box);
    }

}
                                                                                                    