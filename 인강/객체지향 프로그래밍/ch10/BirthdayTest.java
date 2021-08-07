package ch10;

public class BirthdayTest {
	public static void main(String[] args) {
		Birthday birthday = new Birthday();
		
		birthday.setDay(7);
		birthday.setMonth(13);
		birthday.setYear(2021);
		
		birthday.showDate();
	}
}
