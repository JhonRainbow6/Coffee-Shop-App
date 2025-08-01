import java.util.ArrayList;
import java.util.InputMismatchException; // import for entry errors
import java.util.Scanner;

public class Cafeteria{

    // --- internal class to represent a type of coffee ---
    // encapsulation of info for each type of coffee: name and price
    static class Coffee {
        private String name;
        private double price;
        // initialize the object 'Coffee'
        public Coffee(String name, double price) {
            this.name = name;
            this.price = price;
        }
        // getter method for access to the attributes of 'Coffee'
        public String getName() {
            return name;
        }
        public double getPrice() {
            return price;
        }
        // toString() method for clear represent of the object
        @Override
        public String toString() {
            return name + " $" + String.format("%.2f", price) ;
        }
    }

    // --- variablesde principal app ---
    // arrayList store the object in 'Coffee' in the menu.
    private static ArrayList<Coffee> menu = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarMenu();
        System.out.println("Hi, Welcome");
        displayMenu();
        int SelectOption = -1; // store select option
        boolean ValidEnter = false; // authentication control
        while (!ValidEnter) { // loop for secure a valid enter
            System.out.print("What would you order today? (type a number): ");
            try {
                SelectOption = scanner.nextInt();
                // valid if the option is in the menu range
                if (SelectOption > 0 && SelectOption <= menu.size()) {
                    ValidEnter = true;
                } else {
                    System.out.println("Invalid Option. Please, type a number to 1 and " + menu.size() + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Option. Please, type a NUMBER "); // error if the option is not a number
                scanner.next();
            }
        }

        // valid option, obtein the corresponding Coffee object
        Coffee cafeOrder = menu.get(SelectOption - 1); // subtract 1 because arrayList indices are base 0

        System.out.println("Your Order " + cafeOrder.getName() + ".");
        System.out.println("The Price is: $" + String.format("%.2f", cafeOrder.getPrice()) + " US.");

        scanner.close();
        System.out.println("Comeback soon");
    }
    //  method to populate the ‘menu’ arraylist with the Coffee objects
    private static void inicializarMenu() {
        menu.add(new Coffee("Espresso", 6.00));
        menu.add(new Coffee("Americano", 6.00));
        menu.add(new Coffee("Capuchino", 8.50));
        menu.add(new Coffee("Latte", 9.00));
        menu.add(new Coffee("Mocaccino", 10.00));
        // "menu.add(new Coffee("Green Te", 70.00));"
    }

    private static void displayMenu() {
        System.out.println("\n--- Menu ---");
        // iteration over the arraylist to display each cafe
        for (int i = 0; i < menu.size(); i++) {
            // i + 1 to display the option numbers starting from 1
            System.out.println((i + 1) + ". " + menu.get(i).toString());
        }
        System.out.println("--------------------");
    }
}