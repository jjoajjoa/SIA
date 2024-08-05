package myjdbc;

public class Emp {
	int employeeId;
	String firstName;
	String lastName;
	double salary;
	String hireDate;
	
	public Emp() {}

	public Emp(int employeeId, int salary, String lastName) {
		this.employeeId = employeeId;
		this.salary = salary;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Emp [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
				+ salary + ", hireDate=" + hireDate + "]";
	}
}
