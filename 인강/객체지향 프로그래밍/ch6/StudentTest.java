package ch6;

public class StudentTest {
	public static void main(String[] args) {
		Student studentKim = new Student(9717984,"dolmac", 2);
		//기본생성자가 구현 되있으니까
//		Student studentKim = new Student();
//		studentKim.studentName = "dolmac";
//		studentKim.studentNumber = 9717984;
//		studentKim.grade = 2;
		
		System.out.println(studentKim.showStudentInfo());
	}
}
