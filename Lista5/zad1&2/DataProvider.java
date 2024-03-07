import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public final class DataProvider {
    private DataProvider() {
    }

    public static ArrayList<Cost> getGeneralCosts() {
        ArrayList<Cost> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(new Cost(
                    CostType.values()[new Random().nextInt(CostType.values().length)],
                    LocalDate.of(
                            2022,
                            new Random().nextInt(12) + 1,
                            new Random().nextInt(28) + 1),
                    new Random().nextInt(5000)));
        }
        return items;
    }
}