package store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Predicate;

public class StoreTests {
    private Store store;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() {
        this.store = new Store();
        this.product1 = new Product("Krastavitsa", 10, 5.00);
        this.product2 = new Product("Domati", 6, 2.00);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetProducts() {
        store.addProduct(product1);
        store.getProducts().add(product2);
    }

    @Test
    public void testGetCount() {
        store.addProduct(product1);
        store.addProduct(product2);
        int expected = store.getCount();
        Assert.assertEquals(expected, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullProduct() {
        store.addProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductWithNullQuantity() {
        store.addProduct(new Product("Banani", 0, 50));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyNonExistingProduct() {
        store.addProduct(product1);
        store.addProduct(product2);
        store.buyProduct("notExisting", 2);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductNotEnoughQuantity() {
        store.addProduct(product1);
        store.addProduct(product2);
        store.buyProduct(product1.getName(), 100);
    }

    @Test
    public void testBuyProductCorrectly() {
        store.addProduct(product1);
        store.addProduct(product2);
        double expected = store.buyProduct(product1.getName(), 2);
        Assert.assertEquals(expected, 10, 0);
        Assert.assertEquals(product1.getQuantity(), 8);
    }

    @Test
    public void testGetTheMostExpensiveProduct() {
        store.addProduct(product1);
        store.addProduct(product2);
        Product mostExpensiveProduct = store.getTheMostExpensiveProduct();
        Assert.assertEquals(mostExpensiveProduct.getName(), product1.getName());
    }
}