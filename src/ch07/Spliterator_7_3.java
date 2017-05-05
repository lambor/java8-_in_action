package ch07;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by dcnh on 17-5-4.
 */
public class Spliterator_7_3 {
    static final String SENTENCE = "    Nel mezzo  del cammin  di    nostra vita" +
            " mi ritrovai in una   selva oscura" +
            " che la dritta   via era   smarrita ";

    public static int countWordsIteratively() {
        int count = 0;
        boolean lastIsSpace = true;
        for(Character c:SENTENCE.toCharArray()){
            if(Character.isWhitespace(c))
                lastIsSpace = true;
            else {
                if(lastIsSpace) count++;
                lastIsSpace =false;
            }
        }
        return count;
    }

    static class WordCounter {
        private final int count;
        private final boolean lastSpace;

        public WordCounter(int count, boolean lastSpace) {
            this.count = count;
            this.lastSpace = lastSpace;
        }

        public WordCounter accumulate(Character c) {
            if(Character.isWhitespace(c))
                return lastSpace?this:new WordCounter(count,true);
            else
                return lastSpace?new WordCounter(count+1,false):this;
        }

        public WordCounter combine(WordCounter wordCounter) {
            return new WordCounter(count+wordCounter.count,wordCounter.lastSpace);
        }
    }

    public static  int countWords(Stream<Character> stream) {
        return stream.reduce(new WordCounter(0,true),WordCounter::accumulate,WordCounter::combine).count;
    }

    public static void main(String[] args) {
        System.out.println("iter count:"+countWordsIteratively());
        System.out.println("sequent count:"+countWords(IntStream.range(0,SENTENCE.length()).mapToObj(SENTENCE::charAt)));
    }

}
