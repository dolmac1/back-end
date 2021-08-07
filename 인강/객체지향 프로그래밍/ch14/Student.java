package ch14;

public class Student {
	String studentName;
	int money;
	
	public Student(String stdentName, int money) {
		this.studentName = stdentName;
		this.money = money;
	}
	
	public void takeBus(Bus bus) {
		bus.take(1000);
		this.money -=1000;
	}
	
	public void takeTrain(Train train) {
		train.take(1200);
		this.money -= 1200;
	}
	
	public void showInfo() {
		System.out.println(studentName+="의 잔돈 : "+money);
	}
}
