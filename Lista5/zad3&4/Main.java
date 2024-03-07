import java.util.*;

public class Main {

    public static ArrayList<Pair<CostType, Integer>> getCarCosts(String carName) { // zadanie 3
        Car car = DataProvider.getCars().stream()
                .filter(car1 -> carName.equalsIgnoreCase(car1.getName()))
                .findAny()
                .orElse(null);

        if (car == null) {
            throw new IllegalArgumentException("Car not found");
        }

        ArrayList<Cost> carCosts = car.getCosts();

        Map<CostType, Integer> costMap = new HashMap<>();

        for (Cost cost : carCosts) {
            costMap.put(cost.getType(), costMap.getOrDefault(cost.getType(), 0) + cost.getAmount());
        }

        ArrayList<Pair<CostType, Integer>> result = new ArrayList<>();

        for (Map.Entry<CostType, Integer> entry : costMap.entrySet()) {
            result.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        int totalSum = costMap.values().stream().mapToInt(Integer::intValue).sum();
        result.add(new Pair<>(CostType.TOTAL, totalSum));

        result.sort((o1, o2) -> Integer.compare(o2.value(), o1.value()));

        return result;
    }

    public static void printCarCosts(ArrayList<Pair<CostType, Integer>> costList) { // zadanie 3
        for (Pair<CostType, Integer> cost : costList) {
            System.out.println(cost.key() + " " + cost.value() + " zł");
        }
    }

    public static HashMap<CostType, Integer> getFullCosts(ArrayList<Car> carsList) { // zadanie 4
        HashMap<CostType, Integer> result = new HashMap<>();

        for (Car car : carsList) {
            for (Cost cost : car.getCosts()) {
                CostType costType = cost.getType();
                result.put(costType,  result.getOrDefault(costType, 0) + cost.getAmount());
            }
        }

        return result;
    }

    public static void printFullCost(HashMap<CostType, Integer> costsMap) { // zadanie 4
        for (Map.Entry<CostType, Integer> entry : costsMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        //System.out.println(getCarCosts("Domowy"));
        System.out.println("Zadanie 3");
        System.out.println("Dla: samochód 'Domowy'");
        printCarCosts(getCarCosts("Domowy"));

        System.out.println("Zadanie 4");
        //System.out.println(getFullCosts(DataProvider.getCars()));
        printFullCost(getFullCosts(DataProvider.getCars()));
    }
}
