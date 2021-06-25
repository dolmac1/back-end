package ch10;

public class TypeConversionTest {
	public static void main(String[] args) {
		byte bnum = 125;
		int inum = bnum;
		float fnum = inum;
		int inum2 = (int)fnum;
		
		System.out.println(inum);
		System.out.println(fnum);
		System.out.println(inum2);
	}
}
