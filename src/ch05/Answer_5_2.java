package ch05;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by dcnh on 17-4-29.
 */
public class Answer_5_2 {

    static Trader raoul = new Trader("Raoul","Cambridge");
    static Trader mario = new Trader("Mario","Milan");
    static Trader alan = new Trader("Alan","Cambridge");
    static Trader brain = new Trader("Brian","Cambridge");

    static List<Transaction> transactions = Arrays.asList(
            new Transaction(brain,2011,300),
            new Transaction(raoul,2012,1000),
            new Transaction(raoul,2011,400),
            new Transaction(mario,2012,710),
            new Transaction(mario,2012,700),
            new Transaction(alan,2012,950)
    );

    public static void main(String[] args) {
        List<Transaction> tr2011 = transactions.stream().filter(x->x.getYear()==2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        List<String> cities = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList());
        List<Trader> traders = transactions.stream().map(Transaction::getTrader).filter(x->"Cambridge".equals(x.getCity()))
                .distinct().sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        String traderStr = transactions.stream().map(transaction -> transaction.getTrader().getName()).sorted(String::compareTo)
                .reduce("",(a,b)->a+b);
        boolean milanBased = transactions.stream().anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
        transactions.stream().filter(transaction -> "Milan".equals(transaction.getTrader().getCity())).map(Transaction::getValue).forEach(System.out::println);
        Optional<Integer> highestValue = transactions.stream().map(Transaction::getValue).reduce((a,b)->{
            System.out.println("a:"+a+",b:"+b);
            return Integer.max(a,b);
        });
        Optional<Transaction> smallestTransaction = transactions.stream().reduce((x,y)->x.getValue()<y.getValue()?x:y);
    }
}
