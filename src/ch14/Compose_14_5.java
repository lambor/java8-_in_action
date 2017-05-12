package ch14;

import java.util.function.Function;

/**
 * Created by lambor on 17-5-12.
 */
public class Compose_14_5 {
    static <A,B,C> Function<A,C> compose(Function<B,C> g, Function<A,B> f) {
        return (a)->g.apply(f.apply(a));
    }

    //repeat(2,x->2*x) => x->2*(2*x)
    //f(f(g(x))) g(x)=x
    //repeat是高阶方法,且其实现方式使用了迭代
    static Function<Integer,Integer> repeat(int n,Function<Integer,Integer> f) {
        return n >0? compose(f,repeat(n-1,f)):x->x;
    }

    public static void main(String[] args) {
        int result = repeat(2,x->2*x).apply(10);
        System.out.println(result);
    }
}
