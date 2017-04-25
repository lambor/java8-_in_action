package ch02;

/**
 * Created by dcnh on 17-4-25.
 */
public class Runnable_2_3 {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("hello java8")).start();
    }
}
