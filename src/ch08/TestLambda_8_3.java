package ch08;

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
    }
}
