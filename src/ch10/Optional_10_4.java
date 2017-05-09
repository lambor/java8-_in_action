package ch10;

import java.util.Optional;
import java.util.Properties;

/**
 * Created by lambor on 17-5-9.
 */
public class Optional_10_4 {
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        stringToInt("");
        stringToInt(null);
    }

    public static int readDuration(Properties props,String name) {
        String value = props.getProperty(name);
        if(value != null) {
            try{
                int i = Integer.parseInt(value);
                if(i>0) return i;
            } catch (NumberFormatException e) {

            }
        }
        return 0;
    }

    public static int readDuration2(Properties props,String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(Optional_10_4::stringToInt)
                .filter(i->i>0)
                .orElse(0);
    }
}
