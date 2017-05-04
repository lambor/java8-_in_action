package ch05;

/**
 * Created by lambor on 17-5-2.
 *
 */
public class DefaultTest {
    interface BaseInterface {
        interface ChildInterface extends BaseInterface {
            default int foo1() {
                return 1;
            }
        }

        int foo1();

        boolean foo2();
    }

    public static void main(String[] args) {
        BaseInterface.ChildInterface test = ()->false;
    }

}
