import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public record Pair<K, V>(K key, V value) {
    }

    public static Pair<Integer, Integer> findNumberWithMostDivisors(int num) {
        if (num < 1 || num > 100000) {
            throw new IllegalArgumentException("The number must be in the range <1, 100000>");
        }

        ExecutorService executor = Executors.newFixedThreadPool(num);

        try {
            Future<Pair<Integer, Integer>>[] subtaskResults = new Future[num];

            for (int i = 0; i < num; i++) {
                final int subtaskNumber = i;
                subtaskResults[i] = executor.submit(new Callable<Pair<Integer, Integer>>() {
                    @Override
                    public Pair<Integer, Integer> call() throws Exception {
                        return getDivisorsAmount(subtaskNumber);
                    }
                });
            }

            Pair<Integer, Integer> mostDivisorsPair = new Pair<>(0, 0);
            for (Future<Pair<Integer, Integer>> subtaskResult : subtaskResults) {
                if (subtaskResult.get().value() > mostDivisorsPair.value()) {
                    mostDivisorsPair = subtaskResult.get();
                }
            }

            return mostDivisorsPair;
        }
        catch (Exception e) {
            throw new RuntimeException("Error calculating factorial: " + e.getMessage(), e);
        }
        finally {
            executor.shutdown();
        }
    }

    public static Pair<Integer, Integer> getDivisorsAmount(int num) {
        int divisorsAmount = 0 ;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                divisorsAmount++;
            }
        }

        return new Pair<>(num, divisorsAmount);
    }

    public static void main(String[] args) {
        int num = 1000;
        Pair<Integer, Integer> output = findNumberWithMostDivisors(num);
        System.out.println("For the range <1," + num +">:");

        System.out.println("Number = " + output.key());
        System.out.println("Number of divisors = " + output.value());
    }
}
