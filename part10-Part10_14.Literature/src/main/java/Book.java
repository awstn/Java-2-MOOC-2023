
public class Book {
    private String name;
    private int ageRec;
    
    public Book(String name, int ageRec){
        this.name = name;
        this.ageRec = ageRec;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAgeRec(){
        return this.ageRec;
    }
    
    public String toString(){
        return this.getName() + " (recommended for " + this.getAgeRec() + " year-olds or older)"; 
    }
}


/*
public class Book implements Comparable<Book> {

 

    private String name;

    private int age;

 

    public Book(String name, int age) {

        this.name = name;

        this.age = age;

    }

 

    public String getName() {

        return name;

    }

 

    public void setName(String name) {

        this.name = name;

    }

 

    public int getAge() {

        return age;

    }

 

    public void setAge(int age) {

        this.age = age;

    }

 

    @Override

    public String toString() {

        return this.name + " (recommended for " + this.age + " year-olds or older)";

    }

 

    @Override

    public int compareTo(Book o) {

        if (this.age == o.age) {

            return this.name.compareTo(o.name);

        }

 

        return this.age - o.age;

    }

 

}
*/