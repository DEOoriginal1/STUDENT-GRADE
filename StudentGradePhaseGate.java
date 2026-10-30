/*
Create Methods for:
1. Validating Scores
2. Calculating Total
3. Average
4. Class Average
5. Finding Highest
6. Finding Lowest
7. Displaying Scores
8. Printing Header
9. Student Positions
10. Summary


*/
import java.util.Arrays;
import java.util.ArrayList;
public class StudentGradePhaseGate{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("How many students do you have? ");
        int student = input.nextInt();

        System.out.print("How many subjects do they offer? ");
        int subject = input.nextInt();

        int[][] scores = new int[student][subject];

        ArrayList<Integer> studentTotals = new ArrayList<>();
        ArrayList<Integer> subjectTotals = new ArrayList<>();
        ArrayList<Integer> subjectPasses = new ArrayList<>();
        ArrayList<Integer> subjectFails = new ArrayList<>();

        for (int index = 0; index < student; index++){
            for (int count = 0; count < subject; count++){

                System.out.println("Entering score for student " + (index + 1));
                System.out.print("Enter score for subject " + (count + 1) + ": ");

                int studentScores = input.nextInt();

                while (isScores(studentScores)){
                    System.out.println("Invalid score! Score must be between 0 and 100.");
                    System.out.print("Enter score again: ");
                    studentScores = input.nextInt();
                }

                scores[index][count] = studentScores;

                System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>");
                System.out.println("Saved successfully");
            }

            studentTotals.add(calculateTotal(scores[index]));
        }

        for (int index = 0; index < subject; index++){
            int total = 0;
            int passes = 0;
            int fails = 0;

            for (int count = 0; count < student; count++){
                total += scores[count][index];

                if (scores[count][index] >= 50){
                    passes++;
                } else {
                    fails++;
                }
            }

            subjectTotals.add(total);
            subjectPasses.add(passes);
            subjectFails.add(fails);
        }

        System.out.println("\nSaved successfully >>>>>>>>>>>>>>>>>>>>>");

        displayScores(scores, student, subject, studentTotals);

        int classTotal = 0;

        for (int total : studentTotals){
            classTotal += total;
        }

        double classAverage = calculateClassAverage(studentTotals);

        int highest = scores[0][0];
        int lowest = scores[0][0];

        int highestStudent = 0;
        int highestSubject = 0;
        int lowestStudent = 0;
        int lowestSubject = 0;

        for (int index = 0; index < student; index++){
            for (int count = 0; count < subject; count++){

                if (scores[index][count] > highest){
                    highest = scores[index][count];
                    highestStudent = index;
                    highestSubject = count;
                }

                if (scores[index][count] < lowest){
                    lowest = scores[index][count];
                    lowestStudent = index;
                    lowestSubject = count;
                }
            }
        }

        int hardestSubject = 0;
        int easiestSubject = 0;

        for (int index = 0; index < subject; index++){

            if (subjectFails.get(index) > subjectFails.get(hardestSubject)){
                hardestSubject = index;
            }

            if (subjectPasses.get(index) > subjectPasses.get(easiestSubject)){
                easiestSubject = index;
            }
        }

        System.out.println("\n");

        for (int index = 0; index < subject; index++){

            int highestScore = findHighest(scores, index);
            int lowestScore = findLowest(scores, index);

            int highestPosition = 0;
            int lowestPosition = 0;

            for (int count = 0; count < student; count++){

                if (scores[count][index] == highestScore){
                    highestPosition = count;
                    break;
                }
            }

            for (int count = 0; count < student; count++){

                if (scores[count][index] == lowestScore){
                    lowestPosition = count;
                    break;
                }
            }

            System.out.println("SUBJECT SUMMARY");
            System.out.println("Subject " + (index + 1));

            System.out.println("Highest scoring student is: Student "
                    + (highestPosition + 1) + " scoring " + highestScore);

            System.out.println("Lowest scoring student is: Student "
                    + (lowestPosition + 1) + " scoring " + lowestScore);

            System.out.println("Total Score is: " + subjectTotals.get(index));

            System.out.printf("Average score is: %.2f%n",
                    (double) subjectTotals.get(index) / student);

            System.out.println("Number of passes: " + subjectPasses.get(index));
            System.out.println("Number of Fails: " + subjectFails.get(index));

        }

        System.out.println("The hardest subject is Subject "
                + (hardestSubject + 1) + " with "
                + subjectFails.get(hardestSubject) + " failures");

        System.out.println("The easiest subject is Subject "
                + (easiestSubject + 1) + " with "
                + subjectPasses.get(easiestSubject) + " passes");

        System.out.println("The overall Highest score is scored by Student "
                + (highestStudent + 1) + " in subject "
                + (highestSubject + 1) + " scoring " + highest);

        System.out.println("The overall Lowest score is scored by Student "
                + (lowestStudent + 1) + " in subject "
                + (lowestSubject + 1) + " scoring " + lowest);

        System.out.println("\nCLASS SUMMARY");

        System.out.println("Class total score is: " + classTotal);

        System.out.println("Class Average score is: " + classAverage);
    }

    public static boolean isScores(int scores){
        if (scores < 0 || scores > 100) return true;
        return false;
    }

    public static int calculateTotal(int[] scores){
        int total = 0;

        for (int score : scores){
            total += score;
        }

        return total;
    }

    public static double calculateClassAverage(ArrayList<Integer> scores){
        int total = 0;

        for (int score : scores){
            total += score;
        }

        return (double) total / scores.size();
    }

    public static int findHighest(int[][] scores, int subject){
        int highest = scores[0][subject];

        for (int index = 0; index < scores.length; index++){
            if (scores[index][subject] > highest){
                highest = scores[index][subject];
            }
        }

        return highest;
    }

    public static int findLowest(int[][] scores, int subject){
        int lowest = scores[0][subject];

        for (int index = 0; index < scores.length; index++){
            if (scores[index][subject] < lowest) {
                lowest = scores[index][subject];
            }
        }

        return lowest;
    }

    public static void displayScores(int[][] scores, int student,
                                     int subject, ArrayList<Integer> totals){

        System.out.println("\nSTUDENT SCORES");

        for (int index = 0; index < student; index++){

            double average = (double) totals.get(index) / subject;

            System.out.println("\nStudent " + (index + 1));

            for (int count = 0; count < subject; count++){
                System.out.println("Subject " + (count + 1) + ": "
                        + scores[index][count]);
            }

            System.out.println("Total: " + totals.get(index));
            System.out.printf("Average: %.2f%n", average);
        }
    }
}
