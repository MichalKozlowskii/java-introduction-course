import java.util.Scanner;

public class Main {
    public static boolean isPalindrome(String word) {
        word = word.toLowerCase();

        String reverse = new StringBuffer(word).reverse().toString();

        return word.equals(reverse);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź słowo!");
        String word = scanner.nextLine();

        System.out.println(isPalindrome(word));
    }
}
