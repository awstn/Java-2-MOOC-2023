import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Employees {

    private List<Person> employees;
    
    public Employees(){
        this.employees = new ArrayList<>();
    }
    
    public void add(Person personToAdd){
        this.employees.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd){
        Iterator<Person> iterator = peopleToAdd.iterator();
        
        while (iterator.hasNext()){
            Person nextInLine = iterator.next();
            this.employees.add(nextInLine);
        }
    }
    
    public void fire(Education education){
        Iterator<Person> iterator = this.employees.iterator();
        
        while (iterator.hasNext()){
            Person nextInLine = iterator.next();
            if (nextInLine.getEducation() == education){
                iterator.remove();
            }           
        }
    }
    
    public void print(){
        this.employees.stream()
                .forEach(employee -> System.out.println(employee));
    }
    
    public void print(Education education){
        Iterator<Person> iterator = this.employees.iterator();
        
        while (iterator.hasNext()){
            Person nextInLine = iterator.next();
            if (nextInLine.getEducation() == education){
                System.out.println(nextInLine);
            }
        }
    }
    
}

/*
import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;

 

public class Employees {

 

    private List<Person> employees;

 

    public Employees() {

        employees = new ArrayList<>();

    }

 

    public void add(Person personToAdd) {

        employees.add(personToAdd);

    }

 

    public void add(List<Person> peopleToAdd) {

        peopleToAdd.stream().forEach(person -> Employees.this.add(person));

    }

 

    public void print() {

        Iterator<Person> iter = employees.iterator();

 

        while (iter.hasNext()) {

            System.out.println(iter.next());

        }

 

    }

 

    public void print(Education education) {

        Iterator<Person> iter = employees.iterator();

 

        while (iter.hasNext()) {

            Person person = iter.next();

            if (person.getEducation() == education) {

                System.out.println(person);

            }

        }

    }

 

    public void fire(Education education) {

        Iterator<Person> iter = employees.iterator();

 

        while (iter.hasNext()) {

            Person person = iter.next();

            if (person.getEducation() == education) {

                iter.remove();

            }

        }

 

    }

}
*/