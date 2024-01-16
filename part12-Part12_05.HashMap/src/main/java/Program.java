
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // You can test the class here
        
        HashMap hashMap = new HashMap();
        
        hashMap.add(10,15);
        hashMap.add(9,10);
        hashMap.add(23, 35);
        hashMap.add(24, 55);
        
        System.out.println(hashMap.get(24));
        hashMap.remove(24);
        System.out.println(hashMap.get(24));
        
       

    }

}
