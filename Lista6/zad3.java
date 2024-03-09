import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {

    public static List<Number> square(List<Number> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new ArrayList<>();
        }

        List<Number> result = new ArrayList<>();

        int index = 0;
        for (Number num : numbers) {
            if (index % 2 != 0 && num.doubleValue() > 0) {
                if (num.doubleValue() - (double) num.intValue() == 0) {
                    result.add((int) Math.pow(num.intValue(), 2));
                }
                else {
                    result.add(Math.pow(num.doubleValue(), 2));
                }
            }

            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(square(Arrays.asList(1, 2, 3.5, 5, -6, 1, 1)));
    }
}