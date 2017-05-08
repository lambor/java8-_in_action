package ch09;

/**
 * Created by lambor on 17-5-8.
 */
public class DefaultMethod_9_3 {
    public interface Rotatable {
        void setRotationAngle(int angleInDegree);
        int getRotationAngle();
        default void rotateBy(int angleInDegree) {
            setRotationAngle((getRotationAngle() + angleInDegree)%360);
        }
    }

    public interface Moveable {
        int getX();
        int getY();
        void setX(int x);
        void setY(int y);

        default void moveHorizentally(int distance) {
            setX(getX() + distance);
        }

        default void moveVertically(int distance) {
            setY(getY() + distance);
        }
    }

    public interface Resizable {
        int getWidth();
        int getHeight();
        void setWidth(int width);
        void setHeight(int height);

        void setAbsoluteSize(int width,int height);
        default void setRelativeSize(int wFactor,int hFactor) {
            setAbsoluteSize(getWidth()/wFactor,getHeight()/hFactor);
        }
    }
}
