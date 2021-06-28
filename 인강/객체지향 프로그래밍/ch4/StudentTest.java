package ch4;

public class StudentTest {
	public static void main(String[] args) {
		Student student = new Student();
		student.studentId = 12345;
		student.setStudentName("KIM");
		student.address = "서울시";
		String name = student.getStudentName();
		System.out.println(name);
		student.showStudentInfo();
	}
}
