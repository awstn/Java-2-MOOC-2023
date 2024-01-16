
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // you may try out your class here

        Hideout<Integer> dens = new Hideout<>();
        System.out.println(dens.isInHideout());
        dens.putIntoHideout(1);
        System.out.println(dens.isInHideout());
        System.out.println(dens.isInHideout());
        System.out.println(dens.takeFromHideout());
        System.out.println(dens.isInHideout());
        


    }
}
