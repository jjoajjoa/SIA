package test.vo;

public class Emp {
	public int employeeId;
	public double salary;
	public String lastName;

	public Emp(int salary, String lastName) {
		this.salary = salary;
		this.lastName = lastName;
	}

	public Emp() {

	}

	@Override
	public String toString() {
		return "Emp [employeeId=" + employeeId + ", salary=" + salary + ", lastName=" + lastName + "]";
	}

}
