
public class Cat extends Animal implements NoiseCapable{
    
    public Cat(){
        super("Cat");
    }
    
    public Cat(String name){
        super(name);
    }
    
    public void makeNoise(){
        System.out.println(getName() + " purrs");
    }
    
    public void purr(){
        System.out.println(getName() + " purrs");
    }
    
}
/*
public class Cat extends Animal implements NoiseCapable {

 

    public Cat() {

        this("Cat");

    }

 

    public Cat(String name) {

        super(name);

    }

 

    public void purr() {

        System.out.println(getName() + " purrs");

    }

 

    @Override

    public void makeNoise() {

        this.purr();

    }

 

}
*/