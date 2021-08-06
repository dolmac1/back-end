package ch6;

public class Student {
	public int studentNumber;
	public String studentName;
	public int grade;
	public Student(int num, String name, int grade) {//기본 생성자
		this.studentNumber = num;
		this.studentName = name;
		this.grade = grade;
	}
	public String showStudentInfo() {
		return studentName + " " + studentNumber + " " + grade;
	}
}
