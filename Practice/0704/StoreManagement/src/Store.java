import java.util.ArrayList;

public class Store {
	
	static int totalPayment;
	
	String name;
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Product> products = new ArrayList<Product>();
//	ArrayList<> payList = new ArrayList<>();

	/* 매장 이름 */
	Store(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* 고객array */
	public void setCustomer(Customer customer) {
		this.customers.add(customer);
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	/* 제품array */
	public void setProduct(Product product) {
		this.products.add(product);
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	/* 제품 결제 */
	void pay(Customer customer, Product product) {
		if (products.contains(product)) {
            customer.addProduct(product);
        } else {
            System.out.println("Product not available in the store.");
        }
	}

}
