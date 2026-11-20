
package service;

import model.CartItem;
import model.MenuItem;
import exceptions.InvalidQuantityException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {

    private MenuItem createMenuItem(int id, String name, double price) {
        return new MenuItem(id, name, price) {
            @Override
            public void displayDetails() {
            }
        };
    }

    @Test
    public void testAddItem() throws InvalidQuantityException {
        CartService cart = new CartService();

        cart.addItem(createMenuItem(1, "Burger", 100.0), 2);

        assertEquals(1, cart.getItemCount());
        assertEquals(2, cart.getTotalQuantity());
        assertEquals(200.0, cart.getTotal(), 0.001);
    }

    @Test
    public void testAddDuplicateItem() throws InvalidQuantityException {
        CartService cart = new CartService();

        MenuItem item = createMenuItem(1, "Burger", 100.0);

        cart.addItem(item, 2);
        cart.addItem(item, 3);

        assertEquals(1, cart.getItemCount());
        assertEquals(5, cart.getTotalQuantity());
        assertEquals(500.0, cart.getTotal(), 0.001);
    }

    @Test
    public void testRemoveItem() throws InvalidQuantityException {
        CartService cart = new CartService();

        cart.addItem(createMenuItem(1, "Burger", 100.0), 2);
        cart.removeItem(1);

        assertTrue(cart.isEmpty());
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void testUpdateQuantity() throws InvalidQuantityException {
        CartService cart = new CartService();

        cart.addItem(createMenuItem(1, "Burger", 100.0), 2);
        cart.updateQuantity(1, 4);

        assertEquals(4, cart.getTotalQuantity());
        assertEquals(400.0, cart.getTotal(), 0.001);
    }

    @Test
    public void testCalculateCartTotal() throws InvalidQuantityException {
        CartService cart = new CartService();

        cart.addItem(createMenuItem(1, "Burger", 100.0), 2);
        cart.addItem(createMenuItem(2, "Pizza", 200.0), 1);

        assertEquals(400.0, cart.getTotal(), 0.001);
    }
}
