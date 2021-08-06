package ch9;

public class StudentTest {
	public static void main(String[] args) {
		Student studentKim = new Student(100,"dolmac");
		
		studentKim.setKorea("국어", 100);
		studentKim.setMath("수학", 100);
		
		studentKim.showTotalScore();
	}
}
