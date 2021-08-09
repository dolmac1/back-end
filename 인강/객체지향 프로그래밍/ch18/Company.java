package ch18;

public class Company {
	
	static int companyNum = 100;
	static String companyName = "응애";
	private Company() {
		
	}
	
	private static Company company = new Company();
	
	public static Company getInstance() {
		return company;
	}
}
