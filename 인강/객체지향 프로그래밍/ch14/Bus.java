package ch14;

public class Bus {
	int busNum;
	int passengerCount;
	int money;
	
	public Bus(int busNum) {
		this.busNum = busNum;
		this.passengerCount = 0;
		this.money = 0;
	}
	
	public void take(int money) {
		this.money+=money;
		passengerCount++;
	}
	public void showBusInfo() {
		System.out.println(busNum+"의 승객수는 "+passengerCount+"이고, 수익은 "+money);
	}
}
