package lab10;
import java.util.Scanner;


public class Lab10App {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		//Instantiating the Course object
		Course test1 = new Course();
		
		//Calling the accessor method
		System.out.println("The number of students is: " + test1.getNumStudents());	
		
		//Making a new array and instantiating the Student object
		double[] grades = {78.0, 93.5, 91.0, 88.5};
		Student student1 = new Student("1234", "Barack", "Obama", grades);
		
		//Calling the addStudentAtAnyPostion method
		test1.addStudentAtAnyPosition(student1, 0);
		
		//Making a new array and instantiating the Student object
		double[] grades2 = {82.0, 67.5, 90.0, 85.0};
		Student student2 = new Student("2345", "George", "Bush", grades2);
		
		//Calling the addStudentAtAnyPostion method
		test1.addStudentAtAnyPosition(student2, 5);
		System.out.println("The number of students is: " + test1.getNumStudents());
		
		System.out.println();
		System.out.println(test1);
		
		//Calling the calcExamAverage method
		System.out.println("The exam average for exam 1 is: " + test1.calcExamAverage(1));
		System.out.println("The exam average for exam 2 is: " + test1.calcExamAverage(2));
		System.out.println("The exam average for exam 3 is: " + test1.calcExamAverage(3));
		System.out.println("The exam average for exam 4 is: " + test1.calcExamAverage(4));
		System.out.println();
		
		double[] grades3 = new double[4]; 
		int count = 0;
		double userGrades = 0.0;
		while(count < grades3.length) {
			System.out.println("Enter a grade for exam " + (count  + 1) + ": ");
			userGrades = scan.nextDouble();
			if(userGrades >= 0 && userGrades <=100) {
				grades3[count] += userGrades;
				count++;
			}
		}
		
		System.out.println();
		Student student3 = new Student("3456", "Bill", "Clinton", grades3);
		test1.addStudentAtAnyPosition(student3, 1);
		System.out.println(test1);
		
		//Calling the calcaExamAverage method
		System.out.println("The exam average for exam 1 is: " + test1.calcExamAverage(1));
		System.out.println("The exam average for exam 2 is: " + test1.calcExamAverage(2));
		System.out.println("The exam average for exam 3 is: " + test1.calcExamAverage(3));
		System.out.println("The exam average for exam 4 is: " + test1.calcExamAverage(4));
		System.out.println();
		
		//calling the findLowestExam method
		System.out.println("The position of the student with the lowest exam 1 is: " + test1.findLowestExam(1));
		System.out.println("The position of the student with the lowest exam 2 is: " + test1.findLowestExam(2));
		System.out.println("The position of the student with the lowest exam 3 is: " + test1.findLowestExam(3));
		System.out.println("The position of the student with the lowest exam 4 is: " + test1.findLowestExam(4));
		System.out.println("The position of the student with the lowest exam 0 is: " + test1.findLowestExam(0));
		System.out.println("The position of the student with the lowest exam 5 is: " + test1.findLowestExam(5));

	}
}
