import java.util.ArrayList;
 
public class Customer {
	String name;
	int age;
	String phone;

	ArrayList<Product> purchase = new ArrayList<>(); // 한 고객이 산 제품리스트
	int buyPrice;

	Customer(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/* 한사람 한개 구매중*/
	public ArrayList<Product> getPurchase() {
		return purchase;
	}
	
	public void setPurchase(ArrayList<Product> purchase) {
		this.purchase = purchase;
	}
	
	@Override
	public String toString() {
		return ">>> 고객성함: " + name + " || 나이: " + age + " || 전화번호: " + phone;
	}

}
