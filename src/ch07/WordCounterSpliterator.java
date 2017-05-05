package ch07;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collector;

/**
 * Created by lambor on 17-5-5.
 */
public class WordCounterSpliterator implements Spliterator<Character> {

    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if(currentSize < 10) {
            return null;
        }
        for(int splitPos = currentSize / 2 + currentChar;splitPos < string.length();splitPos++) {
            Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar,splitPos));

            currentChar = splitPos;
            return spliterator;
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
