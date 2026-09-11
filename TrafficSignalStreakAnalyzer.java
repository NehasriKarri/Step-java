import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {

        if (signalLog.length() == 0) {
            System.out.println("Signal log is empty.");
            return;
        }

        char longestColor = signalLog.charAt(0);

        int longestCount = 1;
        int currentCount = 1;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i)
                    == signalLog.charAt(i - 1)) {

                currentCount++;

            } else {

                currentCount = 1;
            }

            if (currentCount > longestCount) {

                longestCount = currentCount;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println(
                "Longest Streak: '"
                + longestColor
                + "' repeated "
                + longestCount
                + " times"
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log: ");
        String signalLog = sc.nextLine();

        findLongestStreak(signalLog);

        sc.close();
    }
}