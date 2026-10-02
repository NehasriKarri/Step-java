import java.util.*;
import java.util.regex.*;

abstract class Question {
    protected String correct, student;
    protected int points;
    Question(String correct, String student, int points) {
        this.correct = correct; this.student = student; this.points = points;
    }
    abstract double evaluate();
    abstract String getType();
}

class MCQQuestion extends Question {
    MCQQuestion(String c, String s, int p) { super(c, s, p); }
    double evaluate() { return student.equalsIgnoreCase(correct) ? points : 0; }
    String getType() { return "MCQ"; }
}

class TFQuestion extends Question {
    TFQuestion(String c, String s, int p) { super(c, s, p); }
    double evaluate() { return student.equalsIgnoreCase(correct) ? points : 0; }
    String getType() { return "TF"; }
}

class EssayQuestion extends Question {
    EssayQuestion(String c, String s, int p) { super(c, s, p); }
    double evaluate() {
        String ans = student.toLowerCase();
        int count = 0;
        for (String k : correct.split(",")) {
            String key = k.trim().toLowerCase();
            if (!key.isEmpty() && ans.contains(key)) count++;
        }
        if (count >= 2) return points * 0.75;
        if (count == 1) return points * 0.50;
        return 0;
    }
    String getType() { return "ESSAY"; }
}

public class ExamQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Pattern pat = Pattern.compile("^(\\w+)\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+(\\d+)$");
        List<Question> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Matcher m = pat.matcher(sc.nextLine().trim());
            if (!m.matches()) continue;
            String type = m.group(1).toUpperCase();
            String correct = m.group(3), student = m.group(4);
            int pts = Integer.parseInt(m.group(5));
            switch (type) {
                case "MCQ": list.add(new MCQQuestion(correct, student, pts)); break;
                case "TF": list.add(new TFQuestion(correct, student, pts)); break;
                default: list.add(new EssayQuestion(correct, student, pts));
            }
        }
        double total = 0;
        for (Question q : list) {
            double s = q.evaluate();
            total += s;
            System.out.println(q.getType() + ": " + String.format(Locale.US, "%.2f", s));
        }
        System.out.println("Total Score: " + String.format(Locale.US, "%.2f", total));
        sc.close();
    }
}