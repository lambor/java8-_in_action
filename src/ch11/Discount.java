package ch11;

import static ch11.Shop.delay;

/**
 * Created by lambor on 17-5-10.
 */
public class Discount {
    public enum Code {
        NONE(0),
        SILVER(5),
        GOLD(10),
        PLATINUM(15),
        DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + apply(quote.getPrice(),quote.getDiscountCode());
    }

    private static double apply(double price,Code code) {
        delay();
        return format(price,code);
    }

    private static double format(double price,Code code) {
        return price * (100.0-code.percentage)/100.0;
    }
}
