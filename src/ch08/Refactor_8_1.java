package ch08;

/**
 * Created by lambor on 17-5-6.
 */
public class Refactor_8_1 {

    interface Task {
        public void execute();
    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task t) {
        t.execute();
    }

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        Runnable r2 = ()-> System.out.println("hello");

        //compile error
//        int a = 10;
//        Runnable r3 = ()->{
//            int a = 2;
//            System.out.println(a);
//        };

        doSomething((Task) () -> System.out.println("Dagger dager!!"));
    }
}
