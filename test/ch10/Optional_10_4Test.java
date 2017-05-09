package ch10;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by lambor on 17-5-9.
 */
public class Optional_10_4Test {
    @Test
    public void readDuration2() throws Exception {
        Properties props = new Properties();
        props.setProperty("a","5");
        props.setProperty("b","true");
        props.setProperty("c","-3");

        assertEquals(5,Optional_10_4.readDuration2(props,"a"));
        assertEquals(0,Optional_10_4.readDuration2(props,"b"));
        assertEquals(0,Optional_10_4.readDuration2(props,"c"));
        assertEquals(0,Optional_10_4.readDuration2(props,"d"));
    }

}