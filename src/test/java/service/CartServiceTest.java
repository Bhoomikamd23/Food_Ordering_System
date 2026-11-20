
package service;

import model.CartItem;
import model.MenuItem;
import service.CartService;
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
    @Test
public void testZeroQuantity() {
    CartService cart = new CartService();

    assertThrows(InvalidQuantityException.class,
            () -> cart.addItem(createMenuItem(1, "Burger", 100.0), 0));
}

@Test
public void testNegativeQuantity() {
    CartService cart = new CartService();

    assertThrows(InvalidQuantityException.class,
            () -> cart.addItem(createMenuItem(1, "Burger", 100.0), -2));
}

@Test
public void testEmptyCart() {
    CartService cart = new CartService();

    assertTrue(cart.isEmpty());
}

@Test
public void testRemoveUnavailableItem() {
    CartService cart = new CartService();

    cart.removeItem(99);

    assertTrue(cart.isEmpty());
}

@Test
public void testUpdateUnavailableItem() {
    CartService cart = new CartService();

    assertDoesNotThrow(() -> cart.updateQuantity(99, 3));
    assertTrue(cart.isEmpty());
}
@Test
public void testTotalQuantity() throws InvalidQuantityException {
    CartService cart = new CartService();

    cart.addItem(createMenuItem(1, "Burger", 100.0), 2);
    cart.addItem(createMenuItem(2, "Pizza", 200.0), 3);

    assertEquals(5, cart.getTotalQuantity());
}

@Test
public void testDistinctItemCount() throws InvalidQuantityException {
    CartService cart = new CartService();

    MenuItem burger = createMenuItem(1, "Burger", 100.0);

    cart.addItem(burger, 2);
    cart.addItem(burger, 3);
    cart.addItem(createMenuItem(2, "Pizza", 200.0), 1);

    assertEquals(2, cart.getItemCount());
}

@Test
public void testCartEmptyStatus() throws InvalidQuantityException {
    CartService cart = new CartService();

    assertTrue(cart.isEmpty());

    cart.addItem(createMenuItem(1, "Burger", 100.0), 1);

    assertFalse(cart.isEmpty());
}

@Test
public void testGetCartCopy() throws InvalidQuantityException {
    CartService cart = new CartService();

    cart.addItem(createMenuItem(1, "Burger", 100.0), 2);

    java.util.ArrayList<CartItem> copy = cart.getCartCopy();

    assertEquals(1, copy.size());
    assertEquals(2, copy.get(0).getQuantity());
}

@Test
public void testClearCart() throws InvalidQuantityException {
    CartService cart = new CartService();

    cart.addItem(createMenuItem(1, "Burger", 100.0), 2);
    cart.clearCart();

    assertTrue(cart.isEmpty());
    assertEquals(0, cart.getItemCount());
    assertEquals(0, cart.getTotalQuantity());
}
    
}
