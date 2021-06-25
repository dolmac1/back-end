package ch13;

public class BitTest {
	public static void main(String[] args) {
		int num1 = 8;
		int num2 = 17;
		
		System.out.println(num1 | num2);
		System.out.println(num1 & num2);
		System.out.println(~num1);
		System.out.println(num1 ^ num2);
		System.out.println(num1 << 2);
		System.out.println(-num2 >> 2);
		System.out.println(-num2 >>> 2);
	}
}
