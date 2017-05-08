package ch09;

/**
 * Created by lambor on 17-5-8.
 */
public class RhombusProblem_9_4 {
    //多继承菱形问题

    public interface A {
        default void hello() {
            System.out.println("Hello from A");
        }
    }

    public interface B extends A {
        default void hello() {
            System.out.println("Hello from B");
        }
    }

    public static class C implements A {

    }

    static class Test extends C implements A,B {

    }



    public interface B1 extends A {
        @Override
        default void hello() {
            System.out.println("Hello from B1");
        }
    }

    public interface B2 extends A {
        @Override
        default void hello() {
            System.out.println("Hello from B2");
        }
    }

    public static class C1 implements B1,B2 {
        @Override
        public void hello() {
            B1.super.hello();
        }
    }

    public static void main(String[] args) {
        new Test().hello();

        new C1().hello();
    }
}
