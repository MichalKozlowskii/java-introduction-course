import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<List<Integer>> perm(List<Integer> lst) {
        if (lst.isEmpty()) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());

            return result;
        }

        return lst.stream()
                .flatMap(element -> {
                    List<Integer> rest = new ArrayList<>(lst);
                    rest.remove(element);

                    return perm(rest).stream().map(subPerm -> {
                        List<Integer> permWithFirst = new ArrayList<>(subPerm);
                        permWithFirst.add(0, element);

                        return permWithFirst;
                    });
                })
                .toList();
    }

    public static void main(String[] args) {
        System.out.println(perm(List.of(1, 2, 3)));
    }
}