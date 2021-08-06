package ch8;

public class OrderTest {
	public static void main(String[] args) {
		Order order = new Order(123456, 1096802005, "서울시 강서구", 20210806, 2242, 10000, 1000);
		
		System.out.println(order.OrderInfo());
	}
}
