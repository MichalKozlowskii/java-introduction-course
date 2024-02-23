public class zad3 {
    public static String printPascal(int height) {
        StringBuilder solution = new StringBuilder();
        int[] lastRow = new int[height];

        for (int i = 1; i <= height; i++) {
            int[] currRow = new int[i];
            solution.append(" ".repeat(height - i));

            for (int k = 0; k < i; k++) {
                if (k != 0 && k != i - 1) {
                    int digit = lastRow[k] + lastRow[k-1];
                    currRow[k] = digit;
                    solution.append(Integer.toString(digit) + " ");
                }
                else {
                    currRow[k] = 1;
                    solution.append("1 ");
                }
            }

            lastRow = currRow;
            solution.append("\n");
        }

        return solution.toString();
    }

    public static void main(String[] args) {
        System.out.print(printPascal(4));
    }
}
