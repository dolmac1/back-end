package ch14;

public class Train {
	String trainName;
	int passengerCount;
	int money;
	
	public Train(String trainName) {
		this.trainName = trainName;
		this.passengerCount = 0;
		this.money = 0;
	}
	
	public void take(int money) {
		this.money+=money;
		passengerCount++;
	}
	public void showTrainInfo() {
		System.out.println(trainName+"의 승객수는 "+passengerCount+"이고, 수익은 "+money);
	}
}
