import java.util.Arrays;

public class Main {

    public static int missingNumber(int[] arr) {
        Arrays.sort(arr); // sortujemy otrzymany array od najmniejszej

        int N = arr.length;
        int max = arr[N-1];

        int lastNum = arr[0];
        int index = 0;
        int solution = 0;
        int gapCount = 0;

        for (int num : arr) {
            if (num < 0) {
                System.out.println("Wszystkie elementy tablicy muszą być liczbami naturalnymi!");
                return 0;
            }
            if (index > 0 && num == lastNum) {
                System.out.println("Wszystkie elementy tablicy muszą być unikalne!");
                return 0;
            }
            if (num - lastNum > 2) {
                System.out.println("W tablicy brakuje więcej niż jednego elementu!");
                return 0;
            }

            if (num - lastNum == 2) {
                solution = num - 1;
                gapCount++;
            }

            if (num == arr[N-1] && num < N) { // jeśli nie znaleźliśmy jeszcze braku, a to ostatni element.
                if (gapCount >= 1) {
                    System.out.println("W tablicy brakuje więcej niż jednego elementu!");
                    return 0;
                }

                solution = num + 1;
            }

            lastNum = num;
            index++;
        }

        return solution;
    }

    public static void main(String[] args) {
        int[] tab = new int[]{2, 4, 5, 3, 0, 6}; // N = 6

        System.out.println(missingNumber(tab));
    }
}