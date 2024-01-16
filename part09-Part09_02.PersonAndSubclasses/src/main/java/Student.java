
public class Student extends Person{
    private int studyCredit;
    
    public Student(String name, String address){
        super(name, address);
        this.studyCredit = 0;
    }
    
    public void study(){
        this.studyCredit++;
    }
    
    public int credits(){
        return this.studyCredit;
    }
    
    //@Override
    public String toString(){
        return super.toString() + 
                "\n  Study credits " + this.credits();
    }
}
