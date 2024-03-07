import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.*;

public class Main {

    public static Map<Month, List<Cost>> groupedCostMap(ArrayList<Cost> list) { // zadanie 1
        Map<Month, List<Cost>> result = new TreeMap<>(); // treemap posortuje nam wyniki względem miesiąca

        for (Cost cost : list) {
            Month month = cost.getDate().getMonth();

            List<Cost> val = new ArrayList<>();

            if (result.containsKey(month)) {
                val = result.get(month);
            }

            val.add(cost);

            result.put(month, val);
        }

        return result;
    }

    public static void printGroupedCosts(Map<Month, List<Cost>> costMap) { // zadanie 2
        for (Map.Entry<Month, List<Cost>> entry : costMap.entrySet()) {
            System.out.println(entry.getKey());

            entry.getValue().sort(new Comparator<Cost>() {
                @Override
                public int compare(Cost o1, Cost o2) {
                    return Integer.compare(o1.getDate().getDayOfMonth(), o2.getDate().getDayOfMonth());
                }
            });

            for (Cost val : entry.getValue()) {
                System.out.println(val.getDate().getDayOfMonth() + " " + val.getType() + " " + val.getAmount() + " zł");
            }
        }
    }

    public static void main(String[] args) {
        Map<Month, List<Cost>> costMap = groupedCostMap(DataProvider.getGeneralCosts());

        System.out.println("Zadanie 1");

        for (Map.Entry<Month, List<Cost>> entry : costMap.entrySet()) { // zadanie 1
            System.out.println(entry.getKey() + " = " + entry.getValue().toString());
        }

        System.out.println("Zadanie 2");

        printGroupedCosts(costMap); // zadanie 2
    }
}