import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a : ");
        double a = scanner.nextDouble();
        System.out.println("Enter b : ");
        double b = scanner.nextDouble();
        System.out.println("Enter c : ");
        double c = scanner.nextDouble();

        QuadraticEquation q = new QuadraticEquation(a, b, c);

        double delta = q.getDiscriminant();

        if(delta == 0){
            System.out.print("The equation has one root : " + q.getRoot1());
        }else if(delta > 0){
            System.out.print("The equation has two roots : " + q.getRoot1() + " and " + q.getRoot2());
        }else{
            System.out.print("The equation has no roots");
        }
    }
}