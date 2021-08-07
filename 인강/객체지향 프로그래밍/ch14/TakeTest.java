package ch14;

public class TakeTest {
	public static void main(String[] args) {
		Student dolmac = new Student("dolmac",5000);
		Student chovy = new Student("chovy",11000);
		
		Bus bus100 = new Bus(100);
		Bus bus500 = new Bus(500);
		Train traingreen = new Train("green");
		Train trainblue = new Train("blue");
		
		dolmac.takeBus(bus100);
		chovy.takeTrain(traingreen);
		
		dolmac.showInfo();
		chovy.showInfo();
		
		bus100.showBusInfo();
		bus500.showBusInfo();
		
		traingreen.showTrainInfo();
		trainblue.showTrainInfo();
		
	}
}
