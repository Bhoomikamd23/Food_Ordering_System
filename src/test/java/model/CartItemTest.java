
package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartItemTest {

    private MenuItem createMenuItem() {
        return new MenuItem(1, "Burger", 100.0) {
            @Override
            public void displayDetails() {
            }
        };
    }

    @Test
    public void testGetItem() {
        MenuItem menuItem = createMenuItem();
        CartItem cartItem = new CartItem(menuItem, 2);

        assertSame(menuItem, cartItem.getItem());
    }

    @Test
    public void testGetQuantity() {
        CartItem cartItem = new CartItem(createMenuItem(), 2);

        assertEquals(2, cartItem.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        CartItem cartItem = new CartItem(createMenuItem(), 2);

        cartItem.setQuantity(5);

        assertEquals(5, cartItem.getQuantity());
    }

    @Test
    public void testGetAmount() {
        CartItem cartItem = new CartItem(createMenuItem(), 3);

        assertEquals(300.0, cartItem.getAmount(), 0.001);
    }

    @Test
    public void testAmountAfterQuantityUpdate() {
        CartItem cartItem = new CartItem(createMenuItem(), 2);

        cartItem.setQuantity(4);

        assertEquals(400.0, cartItem.getAmount(), 0.001);
    }
}
