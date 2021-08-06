package ch9;

public class Student {
	int studentId;
	String studentName;
	
	Subject korea = new Subject();
	Subject math = new Subject();
	
	Student(int studentId, String studentName){
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public void setKorea(String name, int score) {
		this.korea.subjectName = name;
		this.korea.score = score;
	}
	
	public void setMath(String name, int score) {
		this.math.subjectName = name;
		this.math.score = score;
	}
	
	public void showTotalScore() {
		int totalScore = korea.score + math.score;
		System.out.println("총점은 : "+ totalScore);
	}
}
