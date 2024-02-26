import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> evenPositiveSquare(List<Integer> lst) {
        List<Integer> result = new ArrayList<>();

        int counter = 0;

        for (int num : lst) {
            if (counter % 2 != 0 && num > 0) {
                result.add(num*num);
            }
            counter++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbersList = List.of(1, 2, 3, 5, -6, -1, -1, 2, 3);

        System.out.println(evenPositiveSquare(numbersList));
    }
}
