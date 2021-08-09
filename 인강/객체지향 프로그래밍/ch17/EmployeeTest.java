package ch17;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee dolmac = new Employee();
		
		dolmac.setEmployeeName("dolmac");
		System.out.println(dolmac.getSerialNum());
		
		Employee chovy = new Employee();
		chovy.setEmployeeName("chovy");
//		chovy.serialNum++;
		
		System.out.println(dolmac.getSerialNum());
		System.out.println(chovy.getSerialNum());
	}
}
