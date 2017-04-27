package ch03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lambor on 17-4-27.
 */
public class ProcessFile_3_3 {
    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

//    @FunctionalInterface
//    public interface BufferedReaderProcessor_NoIOException {
//        String process(BufferedReader b);
//    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

//    public static String processFile_noIOException(BufferedReaderProcessor_NoIOException p) throws FileNotFoundException {
//        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
//            return p.process(br);
//        }
//    }


    public static void main(String[] args) {
        try {
            String oneLine = processFile((BufferedReader b)->b.readLine());
            String twoLines = processFile((BufferedReader b)->b.readLine()+b.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
