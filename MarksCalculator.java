import java.util.Scanner;

public class MarksCalculator {

    // Method to calculate grade based on percentage
    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method to get valid marks input
    public static double getValidMarks(Scanner sc, String subject) {
        double marks;
        do {
            System.out.print("Enter marks obtained in " + subject + " (out of 100): ");
            marks = sc.nextDouble();
            if (marks < 0 || marks > 100) {
                System.out.println("Wrong input! Marks must be between 0 and 100. Please enter again.");
            }
        } while (marks < 0 || marks > 100);
        return marks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = sc.nextInt();
        double totalMarks = 0;

        // Loop to input marks for each subject
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter name of subject " + i + ": ");
            String subject = sc.next();
            double marks = getValidMarks(sc, subject);
            totalMarks += marks;
        }

        // To calculate average percentage
        double averagePercentage = totalMarks / numberOfSubjects;

        // To calculate grade based on average percentage
        String grade = calculateGrade(averagePercentage);

        // For displaying results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
