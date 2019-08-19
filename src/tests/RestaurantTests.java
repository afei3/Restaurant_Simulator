import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestaurantTests {
    private Restaurant testRestaurant;
    @Before
    public void create() {
        testRestaurant = new Restaurant();
        Customer.setIdGenerator(0);
    }

    @Test
    public void testQuality() {
        assertEquals(0, testRestaurant.getRestaurantQuality(), 0.1);
        testRestaurant.increaseQuality(0.2);
        assertEquals(0.2, testRestaurant.getRestaurantQuality(), 0.1);
    }

    @Test
    public void testCustomer() {
        assertEquals(0, Customer.getIdGenerator());
        for (int i = 0; i < 10; i++) {
            Customer.generateCustomer();
        }
        assertEquals(10, Customer.getIdGenerator());
    }

    @Test
    public void testDay() {
        testRestaurant.runDay();
        assertEquals(12, testRestaurant.getHour());
    }
}
