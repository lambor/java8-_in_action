package ch08;

import static org.junit.Assert.*;

/**
 * Created by lambor on 17-5-6.
 */
public class PointTest {
    @org.junit.Test
    public void moveRightBy() throws Exception {
        TestLambda_8_3.Point p1 = new TestLambda_8_3.Point(5,5);
        TestLambda_8_3.Point p2 = p1.moveRightBy(10);

    }

}