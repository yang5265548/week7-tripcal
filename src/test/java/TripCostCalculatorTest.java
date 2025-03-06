import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripCostCalculatorTest {

    @Test
    void calculateCost() {
        assertEquals(40, TripCostCalculator.calculateCost(400, 10, 1));
        //在写两个测试，分别大，或者小的
        assertEquals(0.5, TripCostCalculator.calculateCost(10, 20, 1));

    }
}