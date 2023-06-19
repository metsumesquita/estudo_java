
import java.util.*;
public class Condicional {

	public static void main(String[] args) {
		double labWork, seEvaluation, finalExam;
		Scanner sc = new Scanner(System.in);
		System.out.println("what is your score in work of the lab");
		labWork = sc.nextDouble();
		System.out.println("what is your score on the mid-year review");
		seEvaluation = sc.nextDouble();
		System.out.println("what is your score on the final assessment");
		finalExam = sc.nextDouble();

		double finalscore = (((labWork * 2 + seEvaluation * 3) + finalExam * 5) / 10);
		if (finalscore >= 8 && finalscore <= 10) {
			System.out.println("the highest score is A, congratulations on the performance");
		} else if (finalscore >= 7 && finalscore < 8) {
			System.out.println("the score is B, congratulations on the performance");

		} else if (finalscore >= 6 && finalscore < 7) {
			System.out.println("the score is C,keep studying")

			;
		} else if (finalscore >= 5 && finalscore < 6) {
			System.out.println("the score is D,u need to study more")

			;
		} else {

			System.out.println("the score is F,\nyou had a very low grade, you have to repeat the year");
		}

	}
}
