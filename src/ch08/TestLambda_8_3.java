package ch08;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lambor on 17-5-6.
 */
public class TestLambda_8_3 {
    public static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Point moveRightBy(int x) {
            return new Point(this.x+x,this.y);
        }

        public final static Comparator<Point> compareByXAndThenY = Comparator.comparing(Point::getX).thenComparing(Point::getY);

        public static List<Point> moveAllPointsRightBy(List<Point> points,int x) {
            return points.stream().map(p->new Point(p.getX()+x,p.getY())).collect(Collectors.toList());
        }

        @Override
        public boolean equals(Object obj) {
            return obj == this ||
                    obj instanceof Point && ((Point) obj).getX() == x && ((Point) obj).getY() == y;
        }
    }
}
