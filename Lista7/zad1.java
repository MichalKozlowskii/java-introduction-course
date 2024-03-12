import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(processors);

        try {
            Future<BigInteger>[] subtaskResults = new Future[n];

            for (int i = 0; i < n; i++) {
                final int subtaskNumber = i;
                subtaskResults[i] = executor.submit(new Callable<BigInteger>() {
                    @Override
                    public BigInteger call() throws Exception {
                        return calculatePartialFactorial(subtaskNumber + 1);
                    }
                });
            }

            BigInteger result = BigInteger.ONE;
            for (Future<BigInteger> subtaskResult : subtaskResults) {
                result = result.multiply(subtaskResult.get());
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

    private static BigInteger calculatePartialFactorial(int k) {
        return BigInteger.valueOf(k);
    }

    public static void main(String[] args) {
        int n = 10;
        BigInteger result = factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }
}
