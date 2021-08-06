package ch8;

public class Order {
	public int orderNum;
	public int phoneNum;
	public String address;
	public int date;
	public int time;
	public int price;
	public int menuNum;
	
	public Order(int orderNumber, int phoneNumber, String add, int date, int time, int price, int menuNum) {
		this.orderNum = orderNumber;
		this.phoneNum = phoneNumber;
		this.address = add;
		this.date = date;
		this.time = time;
		this.price = price;
		this.menuNum = menuNum;
	}
	
	public String OrderInfo() {
		return "주문 접수 번호 : " + orderNum + "\n 폰번호 : " + phoneNum + 
				"\n 주소 : " + address + "\n 날짜 : " + date + " " + time +
				"\n 가격 : " + price + "\n 메뉴 번호 : " + menuNum;
	}
}
