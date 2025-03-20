import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {

    private static ResourceBundle rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select language: 1. English  2. Finnish  3. Swedish 4. Japanese");
        int choice = scanner.nextInt();

        Locale locale = switch (choice) {
            case 2 -> new Locale("fi", "FI");
            case 3 -> new Locale("sv", "SE");
            case 4 -> new Locale("ja", "JP");
            default -> new Locale("en", "US");
        };

        rb = ResourceBundle.getBundle("messages", locale); // Store in class-level variable

        double totalCost = calculateTotalCost(scanner);

        System.out.printf(rb.getString("total") + " %.2f\n", totalCost);
        scanner.close();
    }


    public static double calculateTotalCost(Scanner scanner) {
        System.out.println(rb.getString("items"));
        int itemCount = scanner.nextInt();
        double totalCost = 0;

        for (int i = 1; i <= itemCount; i++) {
            System.out.println(rb.getString("price") + " " + i + ":");
            double price = scanner.nextDouble();
            System.out.println(rb.getString("quantity") + " " + i + ":");
            int quantity = scanner.nextInt();
            totalCost += calculateItemTotal(price, quantity);
        }
        return totalCost;
    }

    public static double calculateItemTotal(double price, int quantity) {
        return price * quantity;
    }
}
