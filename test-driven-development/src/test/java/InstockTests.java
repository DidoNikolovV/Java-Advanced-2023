import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class InstockTests {

    private Instock products;
    private Product dummy;
    private static final String DEFAULT_LABEL = "Label Name";
    private static final int DEFAULT_QUANTITY = 5;
    @Before
    public void setUp() {
        this.products = new Instock();
        this.dummy = new Product(DEFAULT_LABEL, 0.0, DEFAULT_QUANTITY);
    }

    @Test
    public void testAdd() {
        products.add(dummy);
        int actualCount = products.getCount();
        int expectedCount = 1;

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testAddShouldNotAddExistentProduct() {
        products.add(dummy);
        products.add(dummy);

        int actualCount = products.getCount();
        int expectedCount = 1;

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testContainsWithNonExistentProduct() {
        products.add(dummy);
        Product product = new Product("Label 1", 0.0, 10);

        boolean actual = products.contains(product);
        assertFalse(actual);
    }

    @Test
    public void testContainsWithExistentProduct() {
        products.add(dummy);
        products.add(new Product("Label 1", 0.0, 10));

        boolean actual = products.contains(dummy);
        assertTrue(actual);
    }

    @Test
    public void testGetCount() {
        products.add(dummy);

        for (int i = 1; i < 20; i++) {
            products.add(new Product("Label" + i, 0.0, 10));
        }

        int actual = products.getCount();
        int expected = 20;

        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithIndexOutOFBoundsShouldThrow() {
        products.find(1);
    }

    @Test
    public void testFindShouldReturnNthProduct() {

        products.add(new Product("Label 1", 0.0, 10));
        products.add(new Product("Label 2", 0.0, 10));

        int index = 1;
        String actual = products.find(index).getLabel();
        String expected = "Label 2";

        assertEquals(expected, actual);
    }

    @Test
    public void testChangeQuantityOfGivenProductByNAmount() {
        int n = 4;

        products.add(dummy);
        products.add(new Product("Label 1", 0.0, 10));

        String product = "Label 1";
        products.changeQuantity(product, n);

        int actual = products.find(1).getQuantity();

        assertEquals(n, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityOfNonExistentProductShouldThrow() {
        int n = 4;
        products.add(dummy);

        String product = "Label 1";
        products.changeQuantity(product, n);
    }

}
