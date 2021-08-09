package ch17;

public class Employee {
	private static int serialNum = 100;
	private int employeeId;
	
	private String employeeName;
	private String department;
	public static int getSerialNum() {
		int i=0;
		
		return serialNum;
	}
	public Employee() {
		employeeId = serialNum;
		serialNum++;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
