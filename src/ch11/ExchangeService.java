package ch11;

import java.util.Random;

import static ch11.Shop.delay;

/**
 * Created by lambor on 17-5-11.
 */
public class ExchangeService {

    public enum Money{
        EUR,
        USD;
    }

    public static double getRate(Money from,Money to) {
        delay();
        return new Random().nextDouble();
    }

    public static double getRate() {
        return getRate(Money.EUR,Money.USD);
    }
}
