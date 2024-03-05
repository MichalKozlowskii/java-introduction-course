import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static int check(int N, List<Integer> lst) {
        if (lst.stream().anyMatch(num -> num < 0)) {
            throw new IllegalArgumentException();
        }

        Set<Integer> noDuplicates = new HashSet<>(lst);
        if (noDuplicates.size() != lst.size()) {
            throw new IllegalArgumentException();
        }

        boolean found = false;

        for (int i = N; i < lst.size(); i++) {
            List<Integer> preamble  = new ArrayList<>();

            for (int j = i - N; j < i; j++) {
                preamble.add(lst.get(j));
            }

            while (!found) {
                if (preamble.isEmpty()) {
                    return lst.get(i);
                }

                int checkedNum = preamble.get(0);

                for (int num : preamble) {
                    if (num != checkedNum && !found) {
                        if (checkedNum + num == lst.get(i)) {
                            found = true;
                        }
                    }
                }

                preamble.remove(0);
            }

            found = false;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(check(2, List.of(1, 2, 3, 4, 5, 6)));
        System.out.println(check(5, List.of(35, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)));
    }
}
