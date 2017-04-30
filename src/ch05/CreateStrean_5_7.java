package ch05;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by dcnh on 17-4-30.
 */
public class CreateStrean_5_7 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java 8","Lambda ","In ","Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        int[] numberes = {2,3,5,7,11,13};
        int sum = Arrays.stream(numberes).sum();

        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line->Arrays.stream(line.split(" "))).distinct().count();
        }catch (IOException e) {

        }

        Stream.iterate(0,n->n+2).limit(10).forEach(System.out::print);
        System.out.println();
        Stream.iterate(new int[] {0,1},iter->new int[]{iter[1],iter[0]+iter[1]}).limit(10).forEach(iter->System.out.print(iter[0]+" "));

        System.out.println();
        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        IntStream ones = IntStream.generate(()->1);

        IntSupplier fib = new IntSupplier() {

            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.current;
                this.previous = this.current;
                this.current = oldPrevious + nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::print);
    }
}
