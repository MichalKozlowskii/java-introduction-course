import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Integer, Boolean>  addToBoolean() {
        Map<Integer, Boolean> result = new HashMap<>();

        for (int i = 1; i <= 20; i++) {
            result.put(i, i % 2 == 0);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(addToBoolean());
    }
}
