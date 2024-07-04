import java.util.ArrayList;

public class Customer {
	String name;
	int age;
	String phone;

	ArrayList<Product> products;

	Customer(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.products = new ArrayList<Product>();
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
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
    public int calculateTotalPrice() {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

	@Override
	public String toString() {
		return ">>> 고객성함: " + name + " || 나이: " + age + " || 전화번호: " + phone;
	}
	
	

}
