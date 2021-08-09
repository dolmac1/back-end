package 인강.ch16;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee dolmac = new Employee();
		
		dolmac.setEmployeeName("dolmac");
		System.out.println(dolmac.serialNum);
		
		Employee chovy = new Employee();
		chovy.setEmployeeName("chovy");
//		chovy.serialNum++;
		
		System.out.println(dolmac.serialNum);
		System.out.println(chovy.serialNum);
	}
}
