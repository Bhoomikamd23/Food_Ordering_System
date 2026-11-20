# Project Details

Food Ordering System is a Java console application. Customers can view and search menu items, manage a cart, place orders, print a bill and view order history.

It uses OOP concepts, ArrayList, HashMap, two custom exceptions and an array-based queue.
## Cart Management Functionality

The Cart Management module handles items selected by customers during the ordering process.

### 1. Cart Item Storage
Cart items are stored using an ArrayList in the CartService class. Each CartItem contains a menu item and its selected quantity.

### 2. Adding Items
Customers can add menu items to their cart. If an item already exists, its quantity is increased instead of creating a duplicate entry.

### 3. Updating Quantity
Customers can update the quantity of an existing cart item. Invalid quantities, including zero and negative values, are rejected using InvalidQuantityException.

### 4. Removing Items
Customers can remove items from their cart using the menu item ID.

### 5. Cart Total Calculation
The total amount is calculated by adding the individual amounts of all cart items. Each item's amount is calculated using its price multiplied by its quantity.

### 6. Cart Status and Management
The system provides methods to check whether the cart is empty, count distinct items, calculate total quantity, retrieve a copy of the cart, and clear all cart items.

### 7. Cart Testing
JUnit 5 is used to test cart functionality, including adding items, removing items, updating quantities, calculating totals, and validating incorrect quantities.