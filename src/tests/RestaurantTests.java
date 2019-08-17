import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestaurantTests {
    private Restaurant testRestaurant;
    @Before
    public void create() {
        testRestaurant = new Restaurant();
    }

    @Test
    public void testQuality() {
        assertEquals(0, testRestaurant.getRestaurantQuality(), 0.1);
        testRestaurant.increaseQuality(0.2);
        assertEquals(0.2, testRestaurant.getRestaurantQuality(), 0.1);
    }
}
