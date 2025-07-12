import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Hello and welcome!");
        System.out.println("Menu:");
        System.out.println();
        System.out.println("1. Expresso");
        System.out.println("2. Americano Tipe");
        System.out.println("3. Capuchino");
        System.out.println("4. Latte");
        System.out.println("5. Mocaccino");
        System.out.println();
        System.out.print("What would you order today: ");

        int order = scanner.nextInt();
        switch(order) {
            case 1 -> System.out.print("Your Order a Expresso");
            case 2 -> System.out.println("Your Order a Americano Tipe");
            case 3 -> System.out.println("Your Order a Capuchino");
            case 4 -> System.out.println("Your Order a Latte");
            case 5 -> System.out.println("Your Order a Mocaccino");
            default -> System.out.println(order + "Goodbye");
        }
        scanner.close();
    }
}