import java.math.BigDecimal;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.math.MathContext.DECIMAL128;

public class Main {

    public static BigDecimal calculateEuler(int num) {
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(processors);

        try {
            Future<BigDecimal>[] subtaskResults = new Future[num];

            for (int i = 0; i < num; i++) {
                final int subtaskNumber = i;
                subtaskResults[i] = executor.submit(new Callable<BigDecimal>() {
                    @Override
                    public BigDecimal call() throws Exception {
                        return calculateElement(subtaskNumber);
                    }
                });
            }

            BigDecimal result = BigDecimal.ZERO;
            for (Future<BigDecimal> subtaskResult : subtaskResults) {
                result = result.add(subtaskResult.get());
            }

            return result;

        }
        catch (Exception e) {
            throw new RuntimeException("Error calculating factorial: " + e.getMessage(), e);
        }
        finally {
            executor.shutdown();
        }
    }

    public static BigDecimal calculateElement(int k) {
        BigDecimal factorial = BigDecimal.ONE;

        for (int i = 1; i <= k; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i));
        }

        return BigDecimal.ONE.divide(factorial, DECIMAL128);
    }

    public static void main(String[] args) {
        System.out.println(calculateEuler(17));
    }
}
