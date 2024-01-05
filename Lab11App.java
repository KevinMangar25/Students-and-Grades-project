package lab10;
import java.util.Scanner;
import java.io.File;

public class Lab11App {
	public static void main(String [] args) throws Exception {
		//4. instantiate a course object
		Course theCourse = new Course();
		
		//5. Instantiate a scanner object
		Scanner fileScan = new Scanner(new File("courseData.txt"));
		
		int numPeople;
		String studentId;
		String firstName;
		String lastName;
		double exams;
		double[] examArray = new double[4];
		
		//6. gets the first input for the amount of people
		numPeople = Integer.parseInt(fileScan.nextLine());
		
		//7. and 8. iterates through students and stores them into the variables
		for(int i = 0; i < numPeople; ++i) {
			studentId = fileScan.nextLine();
			lastName = fileScan.nextLine();
			firstName = fileScan.nextLine();
			
			//9. reads the four exam grades and stores them into an array
			for(int j = 0; j < 4; ++j) {
				exams = Double.parseDouble(fileScan.nextLine());
				examArray[j] = exams;
			}
			Student newStudent = new Student(studentId, firstName, lastName, examArray);
			theCourse.addStudentAtAnyPosition(newStudent, i);
		}
		
		System.out.println("Students in the course:\n" + theCourse);
		Student newStudent2 = new Student();
		newStudent2.setStudentId("123-45-6789");
		System.out.println("Position of the student with id 123-45-6789: " + theCourse.findStudent(newStudent2));
		newStudent2.setStudentId("765-43-2100");
		System.out.println("Position of the student with id 765-43-2100: " + theCourse.findStudent(newStudent2));
		newStudent2.setStudentId("999-99-9999");
		System.out.println("Position of the student with id 999-99-9999: " + theCourse.findStudent(newStudent2));
		newStudent2.setStudentId("666-66-6666");
		System.out.println("Position of the student with id 666-66-6666: " + theCourse.findStudent(newStudent2));
		
		Student newStudent3 = new Student();
		newStudent3.setStudentId("765-43-2100");
		if(theCourse.deleteStudent(newStudent3)) {
			numPeople --;
			System.out.println("\nDelete student 765-43-2100. Number of students in the course: " + numPeople);
		}
		
		newStudent3.setStudentId("999-99-9999");
		if(theCourse.deleteStudent(newStudent3)) {
			numPeople --;
			System.out.println("Delete student 999-99-9999. Number of students in the course: " + numPeople);
		}
		
		newStudent3.setStudentId("123-45-6789");
		if(theCourse.deleteStudent(newStudent3)) {
			numPeople--;
			System.out.println("Delete student 123-45-6789. Number of students in the course: " + numPeople);
		}
		
		newStudent3.setStudentId("666-66-6666");
		if(theCourse.deleteStudent(newStudent3)) {
			numPeople--;
			System.out.println("Delete student 666-66-6666. Number of students in the course: " + numPeople);
		}
		else {
			System.out.println("Delete student 666-66-6666. Number of students in the course: " + numPeople);
		}

		System.out.println("\nStudents in the course:\n" + theCourse);

	}
	

}
