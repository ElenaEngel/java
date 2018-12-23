//created by Elena Rybalkina
package lettergradecalculator;

import java.util.Scanner;

public class LetterGradeCalculator {

    public static void main(String[] args) {

        Scanner input;
        int quizScore1;
        int quizScore2;
        int examScore1;
        int examScore2;
        int bestExam;
        int bestQuiz;
        String name;
        String idNumber;
        double score;
        char letterGrade;
        input = new Scanner(System.in);
        System.out.println("Enter the student's name: ");
        name = input.nextLine();
        System.out.println("Enter the student's ID number: ");
        idNumber = input.nextLine();
        System.out.println("Enter the quiz 1 and quiz 2 scores: ");
        quizScore1 = input.nextInt();
        quizScore2 = input.nextInt();
        System.out.println("Enter the exam 1 and exam 2 scores: ");
        examScore1 = input.nextInt();
        examScore2 = input.nextInt();
        bestQuiz = max(quizScore1, quizScore2);
        bestExam = max(examScore1, examScore2);
        score = computeRawPercentage(bestQuiz, bestExam);
        letterGrade = finalGrade(score);
        System.out.print(name + " " + idNumber + " ");
        System.out.println("Final Grade: " + letterGrade);

    }

    public static int max(int n1, int n2) {
        int big;
        if (n1 > n2) {
            big = n1;
        } else {
            big = n2;
        }
        return big;
    }

    public static double computeRawPercentage(int quizScore,
            int examScore) {
        return ((quizScore * .4) + (examScore * .6));
    }

    public static char finalGrade(double score) {
        if (score >= 90.0) {
            return 'A';
        } else if (score >= 80.0) {
            return 'B';
        } else if (score >= 70.0) {
            return 'C';
        } else if (score >= 60.0) {
            return 'D';
        } else //{System.out.println("F");}
        {
            return 'F';
        }

    }
}
