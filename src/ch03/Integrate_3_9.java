package ch03;

import java.util.function.DoubleFunction;

/**
 * Created by lambor on 17-4-28.
 *
 */
public class Integrate_3_9 {

    private static final double STEP = 0.01;

    public static double integrate(DoubleFunction<Double> f,double start,double end) {
        double result = 0;
        double nextEnd = start + STEP;
        while(nextEnd <= end) {
            result += integrade_iter(f,start,nextEnd);
            start = nextEnd;
            nextEnd = start + STEP;
        }
        result += integrade_iter(f,start,end);
        return result;
    }

    private static double integrade_iter(DoubleFunction<Double> f,double start,double end) {
        return (f.apply(start) + f.apply(end)) * (end-start) * 0.5;
    }

    public static void main(String[] args) {
        System.out.println(integrate(x->x,0,20)); //200.0
        System.out.println(integrate(x->2*x,0,10)); //100.0
        System.out.println(integrate(Math::sin,0,2*Math.PI)); //0.0
    }
}
