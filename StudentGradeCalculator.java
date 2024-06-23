import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            int totalMarks = 0;
            for (int i = 1; i <= numSubjects; i++) {
                System.out.print("Enter marks for subject " + i + ": \n");
                int marks = scanner.nextInt();
                totalMarks += marks;
            }

            double averagePercentage = (double) totalMarks / numSubjects;
            LetterGrade grade = LetterGrade.getGrade(averagePercentage);

            System.out.println("Total marks: " + totalMarks);
            System.out.println("Average percentage: " + averagePercentage + "%");
            System.out.println("Grade: " + grade);
        }
    }
}

enum LetterGrade {
    A(90, 100),
    B(80, 89),
    C(70, 79),
    D(60, 69),
    F(0, 59);

    private final int lowerBound;
    private final int upperBound;

    LetterGrade(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public static LetterGrade getGrade(double percentage) {
        for (LetterGrade grade : LetterGrade.values()) {
            if (percentage >= grade.lowerBound && percentage <= grade.upperBound) {
                return grade;
            }
        }
        throw new IllegalArgumentException("Invalid percentage: " + percentage);
    }
}
