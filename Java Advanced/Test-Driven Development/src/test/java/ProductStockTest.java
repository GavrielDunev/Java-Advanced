import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ProductStockTest {
    private ProductStock stock;

    @Before
    public void setUp() {
        stock = new Instock();
    }

    @Test
    public void testGetCountShouldReturnCorrectSize() {
        Assert.assertEquals(0, stock.getCount());
        Product product = createProduct();
        stock.add(product);
        Assert.assertEquals(1, stock.getCount());
    }

    @Test
    public void testContainsReturnCorrectBooleanForAllCases() {
        Product product = createProduct();
        Assert.assertFalse(stock.contains(product));
        stock.add(product);
        Assert.assertTrue(stock.contains(product));
        Product notExistingProduct = new Product("notExisting", 2, 2);
        Assert.assertFalse(stock.contains(notExistingProduct));
    }

    @Test
    public void testAddMethodAddsProductToStockCorrectly() {
        Product product = createProduct();
        stock.add(product);
        Assert.assertTrue(stock.contains(product));
    }

    @Test
    public void testFindReturnsFirstProductByValidGivenIndex() {
        Product product = createProduct();
        stock.add(product);
        Product foundProduct = stock.find(0);
        Assert.assertNotNull(foundProduct);
        Assert.assertEquals(foundProduct.getLabel(), product.getLabel());

    }

    @Test
    public void testFindReturnsLastProductByValidGivenIndex() {
        addProductsInStock(5);
        Product newProduct = new Product("lastProduct", 1, 1);
        stock.add(newProduct);
        Product foundProduct = stock.find(5);
        Assert.assertNotNull(foundProduct);
        Assert.assertEquals(foundProduct.getLabel(), newProduct.getLabel());
    }

    @Test
    public void testFindReturnsMiddleProductByValidGivenIndex() {
        addProductsInStock(5);
        Product newProduct = new Product("lastProduct", 1, 1);
        stock.add(newProduct);
        addProductsInStock(5);
        Product foundProduct = stock.find(5);
        Assert.assertNotNull(foundProduct);
        Assert.assertEquals(foundProduct.getLabel(), newProduct.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldReturnExceptionWhenInvalidIndex() {
        stock.find(0);
    }

    @Test
    public void testChangeQuantityOfExistingProduct() {
        Product product = createProduct();
        stock.add(product);
        stock.changeQuantity(product.getLabel(), product.getQuantity() + 1);
        Product productWithChangedQuantity = stock.find(0);
        Assert.assertNotNull(productWithChangedQuantity);
        Assert.assertEquals(2, productWithChangedQuantity.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityThrowExceptionWhenProductNonExistent() {
        stock.changeQuantity("notExisting", 5);
    }

    @Test
    public void testFindExistingProductByLabel() {
        addProductsInStock(5);
        Product product = stock.find(3);
        Assert.assertNotNull(product);
        Product productByLabel = stock.findByLabel(product.getLabel());
        Assert.assertNotNull(productByLabel);
        Assert.assertEquals(product.getLabel(), productByLabel.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindProductWithInvalidLabel() {
        stock.findByLabel("notExisting");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsCorrectNumberOfProducts() {
        addProductsInStock(10);
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(5);
        Assert.assertNotNull(iterable);
        List<Product> products = createListOfIterable(iterable);
        Assert.assertEquals(5, products.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsCorrectNumberOfProductsOrderedAlphabetically() {
        addProductsInStock(10);
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(5);
        Assert.assertNotNull(iterable);
        List<Product> products = createListOfIterable(iterable);
        Assert.assertEquals(5, products.size());

        Set<String> expectedLabels = products.stream()
                .map(Product::getLabel)
                .collect(Collectors.toCollection(TreeSet::new));

        int index = 0;
        for (String expectedLabel : expectedLabels) {
            Assert.assertEquals(expectedLabel, products.get(index++).getLabel());
        }
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsEmptyCollectionWhenParameterOutOfRange() {
        addProductsInStock(10);
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(11);
        Assert.assertNotNull(iterable);
        List<Product> products = createListOfIterable(iterable);
        Assert.assertTrue(products.isEmpty());
    }

    @Test
    public void testFindAllInPriceRangeReturnsCorrectProductInDescendingOrder() {
        Product product1 = new Product("p1", 1.0, 1);
        Product product2 = new Product("p2", 3.0, 1);
        Product product3 = new Product("p3", 6.0, 1);
        Product product4 = new Product("p4", 8.0, 1);
        Product product5 = new Product("p5", 10.0, 1);
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);

        Iterable<Product> iterable = stock.findAllInRange(5.0, 10.0);
        Assert.assertNotNull(iterable);
        List<Product> productsInRange = createListOfIterable(iterable);

        Assert.assertEquals(productsInRange.get(0).getPrice(), 10.0, 0);
        Assert.assertEquals(productsInRange.get(1).getPrice(), 8.0, 0);
        Assert.assertEquals(productsInRange.get(2).getPrice(), 6.0, 0);
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnEmptyCollectionWhenNoProductsInRange() {
        Iterable<Product> iterable = stock.findAllInRange(5, 10);
        Assert.assertNotNull(iterable);
        List<Product> listOfIterable = createListOfIterable(iterable);
        Assert.assertTrue(listOfIterable.isEmpty());
    }

    @Test
    public void testFindAllByPriceReturnsAllProductsWithGivenPrice() {
        Product product1 = new Product("p1", 1.0, 1);
        Product product2 = new Product("p2", 6.0, 1);
        Product product3 = new Product("p3", 6.0, 1);
        Product product4 = new Product("p4", 6.0, 1);
        Product product5 = new Product("p5", 10.0, 1);
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);

        Iterable<Product> allByPrice = stock.findAllByPrice(6.0);
        Assert.assertNotNull(allByPrice);
        List<Product> products = createListOfIterable(allByPrice);
        Assert.assertEquals(3, products.size());

        for (Product product : products) {
            Assert.assertEquals(6.0, product.getPrice(), 0);
        }
    }

    @Test
    public void testFindAllByPriceReturnsEmptyCollectionWhenNoProductsWithGivenPrice() {
        addProductsInStock(10);
        Product product = stock.find(0);
        Assert.assertNotNull(product);
        Iterable<Product> allByPrice = stock.findAllByPrice(product.getPrice() + 5);
        Assert.assertNotNull(allByPrice);
        List<Product> listOfIterable = createListOfIterable(allByPrice);
        Assert.assertTrue(listOfIterable.isEmpty());
    }

    @Test
    public void testFindFirstMostExpensiveProductsReturnsGivenNumberOfProductsWithHighestPrice() {
        Product product1 = new Product("p1", 1.0, 1);
        Product product2 = new Product("p2", 2.0, 1);
        Product product3 = new Product("p3", 3.0, 1);
        Product product4 = new Product("p4", 6.0, 1);
        Product product5 = new Product("p5", 10.0, 1);
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);

        Iterable<Product> firstMostExpensiveProducts = stock.findFirstMostExpensiveProducts(3);
        Assert.assertNotNull(firstMostExpensiveProducts);
        List<Product> mostExpensive = createListOfIterable(firstMostExpensiveProducts);

        Assert.assertEquals(10, mostExpensive.get(0).getPrice(), 0);
        Assert.assertEquals(6, mostExpensive.get(1).getPrice(), 0);
        Assert.assertEquals(3, mostExpensive.get(2).getPrice(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsReturnsNullWhenProductsLessThanCount() {
        addProductsInStock(10);
        stock.findFirstMostExpensiveProducts(12);
    }

    @Test
    public void testFindAllByQuantityReturnsAllProductsWithGivenQuantity() {
        Product product1 = new Product("p1", 1.0, 3);
        Product product2 = new Product("p2", 2.0, 3);
        Product product3 = new Product("p3", 3.0, 3);
        Product product4 = new Product("p4", 6.0, 1);
        Product product5 = new Product("p5", 10.0, 1);
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);

        Iterable<Product> allByQuantity = stock.findAllByQuantity(3);
        Assert.assertNotNull(allByQuantity);
        List<Product> products = createListOfIterable(allByQuantity);
        Assert.assertEquals(3, products.size());

        for (Product product : products) {
            Assert.assertEquals(3, product.getQuantity());
        }
    }

    @Test
    public void testFindAllByQuantityReturnsEmptyCollectionWhenNoProductWithGivenQuantity() {
        addProductsInStock(10);
        Iterable<Product> allByQuantity = stock.findAllByQuantity(5);
        Assert.assertNotNull(allByQuantity);
        List<Product> products = createListOfIterable(allByQuantity);
        Assert.assertTrue(products.isEmpty());
    }

    @Test
    public void testIteratorReturnsAllProductsInStock() {
        addProductsInStock(10);
        Iterator<Product> iterator = stock.iterator();
        Assert.assertNotNull(iterator);
        List<Product> products = createListOfIterator(iterator);
        Assert.assertEquals(10, products.size());
    }

    @Test
    public void testIteratorReturnsEmptyCollectionWhenNoProductsInStock() {
        Iterator<Product> iterator = stock.iterator();
        Assert.assertNotNull(iterator);
        List<Product> products = createListOfIterator(iterator);
        Assert.assertEquals(0, products.size());
    }

    private Product createProduct() {
        return new Product("label", 3.00, 1);
    }

    private List<Product> createProductsList(int count) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            products.add(new Product(("label_" + i + 1), 5.0, 1));
        }
        return products;
    }

    private void addProductsInStock(int count) {
        List<Product> products = createProductsList(count);
        for (Product product : products) {
            stock.add(product);
        }
    }

    private <T> List<T> createListOfIterable(Iterable<T> products) {
        List<T> listOfProducts = new ArrayList<>();
        for (T product : products) {
            listOfProducts.add(product);
        }
        return listOfProducts;
    }

    private <T> List<T> createListOfIterator(Iterator<T> products) {
        List<T> listOfProducts = new ArrayList<>();

        while (products.hasNext()) {
            listOfProducts.add(products.next());
        }

        return listOfProducts;
    }
}
