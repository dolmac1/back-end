package ch16;

public class Java14Switch {
	public static void main(String[] args) {
		int month = 6;
		
		int day = switch(month) {
			case 1, 3, 5, 7, 8, 10, 12 -> {
				System.out.println("한달은 31일");
				yield 31;
			}
			case 4, 6, 9, 11 -> {
				System.out.println("한달은 30일");
				yield 30;
			}
			case 2 -> {
				System.out.println("한달은 28일");
				yield 28;
			}
		}
	}
}
