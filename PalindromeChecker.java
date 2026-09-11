import java.util.Scanner;

public class PalindromeChecker {

    // Method 1 - Iterative
    public static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Method 2 - Recursive
    public static boolean isPalindromeRecursive(String text) {

        return recursiveCheck(
                text,
                0,
                text.length() - 1
        );
    }

    public static boolean recursiveCheck(
            String text,
            int left,
            int right) {

        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return recursiveCheck(
                text,
                left + 1,
                right - 1
        );
    }

    // Method 3 - Array Reversal
    public static boolean isPalindromeArrayReversal(String text) {

        char[] array = text.toCharArray();

        int left = 0;
        int right = array.length - 1;

        while (left < right) {

            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }

        String reversed = new String(array);

        return text.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println(
                "Iterative: " +
                (isPalindromeIterative(text)
                        ? "Palindrome"
                        : "Not Palindrome")
        );

        System.out.println(
                "Recursive: " +
                (isPalindromeRecursive(text)
                        ? "Palindrome"
                        : "Not Palindrome")
        );

        System.out.println(
                "Array Reversal: " +
                (isPalindromeArrayReversal(text)
                        ? "Palindrome"
                        : "Not Palindrome")
        );

        sc.close();
    }
}