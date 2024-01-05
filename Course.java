package lab10;
/**
 * <p>Title: The Course Class</p>
 * 
 * <p>Description: This class models a Course and is capable of storing references 
 * to Student objects. Students can be inserted in the course and the number of students
 * in the course can be determined. The average for a given exam can be calculated, the 
 * position of the Student with the lowest score for a given exam can be determined and 
 * the students at a given position can be returned.</p>
 *
 * @author
 *
 */
public class Course 
{
    //instance variables
	private Student[] students;
	private int numStudents;


	/**
	 * Default constructor --
	 * Creates storage for at most 30 students and sets the number of
	 * students in the course to 0.
	 */
	public Course() {
		students = new Student[30];
		numStudents = 0;
	}
	

	/**
	 * getNumStudents --
	 * Returns the number of students currently in the course.
	 * @return numStudents
	 */
	public int getNumStudents() {
		return numStudents;
	}
	
	
	/**
	 * addStudentAtAnyPosition --
	 * Adds a student to the course if there's room.  If the course is full, 
	 * it doesn't do anything.  Appropriate elements should be shifted and the student 
	 * should be added at the position specified in the parameter.  The position parameter 
	 * should be validated first; if it's negative or more than the number of students, 
	 * the student should be placed immediately to the right of the other objects.
	 * @param newStudent - a reference to the student to be added 
	 * @param pos - an integer indicating where the new Student should be added
	 */
	
	public void addStudentAtAnyPosition(Student newStudent, int pos) {
		if (numStudents < students.length) {
	        if (pos >= 0 && pos <= numStudents) {
	            for (int i = numStudents; i > pos; --i) {
	                students[i] = students[i - 1];
	            }
	            students[pos] = newStudent;
	        } else {
	            students[numStudents] = newStudent;
	        }
            numStudents++;
		}
	}
	

	/**
	 * calcExamAverage --
	 * Calculates the average for a particular exam.
	 * @param examNum - the exam number to calculate the average for
	 * @return the average for the specified exam
	 */
	
	public double calcExamAverage(int examNum) {
		double sum = 0;
		if(examNum >= 1 && examNum <= 4) {
			for(int i = 0; i < numStudents; ++i) {
				sum += students[i].getExams()[examNum - 1];
			}
			}
		else {
			return -1;
		}
		return sum / numStudents;
		}


	/**
	 * findLowestExam --
	 * Determines the index of the student in the students array with the lowest score 
	 * for a particular exam. 
	 * 
	 * @param examNum - an integer representing the exam number to find the lowest 
	 * exam score for 
	 * @return the index of the student with the lowest exam score for the 
	 * specified exam
	 */
	public int findLowestExam(int examNum) {	
		int lowIndex = 0;
		
		if(examNum >= 1 && examNum <= 4) {
			double lowTest = students[0].getExams()[examNum - 1];
			
			for(int i = 1; i < numStudents; ++i) {
				if(students[i].getExams()[examNum - 1] < lowTest) {
					lowTest = students[i].getExams()[examNum - 1];
					lowIndex = i;
				}
			}
		}
		else {
			lowIndex = -1;
		}
		return lowIndex;
	}
	
	public int findStudent(Student newStudent) {
		for(int i = 0; i < numStudents; ++i) {
			if(students[i].getStudentId().compareTo(newStudent.getStudentId()) == 0) {
				return i;
			}
			
		}
		return -1;
	}
	

	public boolean deleteStudent(Student newStudent) {
		int pos = this.findStudent(newStudent);
		if(pos == -1) {
			return false;
		}
		else {
			for(int i = pos; i < numStudents - 1; ++i) {
				students[i] = students[i + 1];
			}
			students[numStudents - 1] = null;
			numStudents--;
			return true;
		}
		
	}
	/**
	 * toString method -- 
	 * Returns a String representing the state of the Course.
	 * @return a reference to a string containing all the students in
	 * the course
	 */
	
	public String toString() {
		String str = "";
		for(int i = 0; i < numStudents; ++i) {
			str += students[i] + "\n";
		}
		return str;

	}
}
