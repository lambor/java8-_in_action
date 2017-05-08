package ch08;

import ch08.TestLambda_8_3.Point;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lambor on 17-5-8.
 */
public class PointTest {
    @Test
    public void moveRightBy() throws Exception {
        Point p1 = new Point(5,5);
        Point p2 = p1.moveRightBy(10);
        assertEquals(15,p2.getX());
        assertEquals(5,p2.getY());
    }

    @Test
    public void testComparingTwoPoints() throws Exception {
        Point p1 = new Point(10,15);
        Point p2 = new Point(10,20);
        int result = Point.compareByXAndThenY.compare(p1,p2);
        assertEquals(-1,result);
    }

    @Test
    public void testMoveAllPointsRightBy() throws Exception {
        List<Point> points = Arrays.asList(new Point(5,5),new Point(10,15));
        List<Point> expectedPoints = Arrays.asList(new Point(15,5),new Point(20,15));
        List<Point> newPoints = Point.moveAllPointsRightBy(points,10);
        assertEquals(expectedPoints,newPoints);
    }
}