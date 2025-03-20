import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.io.ByteArrayInputStream;

class ShoppingCartTest {

    ResourceBundle rb;

    @Test
    void testCalculateItemTotal() {
        assertEquals(20.0, ShoppingCart.calculateItemTotal(10.0, 2), 0.1);
        assertEquals(0.0, ShoppingCart.calculateItemTotal(0.0, 5), 0.1);
        assertEquals(50.0, ShoppingCart.calculateItemTotal(25.0, 2), 0.1);
    }

    @Test
    void testCalculateTotalCost() {
        String input = "2\n10.0\n2\n5.0\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        double totalCost = ShoppingCart.calculateTotalCost(scanner);

        assertEquals(35.0, totalCost);
    }

}
