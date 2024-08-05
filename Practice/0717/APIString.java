package practiceAPI;
//	"iphone16:1900000:apple"
//	문자열을 전달받아서 그 문자열을 파싱하여 객체로 리턴합니다.
//	그 객체는 Product, model/price/maker라는 객체변수가 있습니다.
//	이러한 메서드를 생성합니다.
//	main 메서드가 있는 코드를 비공개 댓글로 제출합니다.
public class APIString {
	public static void main(String[] args) {
		// 변수를 선언하고 메서드 호출결과를 저장한다.
		String info = "iphone16:1900000:apple";
		Product product = makeProduct(info);
		// 객체의 변수에 저장된 값을 출력한다.
		System.out.println(product);
		System.out.println(product.price);
	}

	// 문자열을 전달받아서 파싱해서 객체를 리턴한다.
	private static Product makeProduct(String info) {
		// 객체를 생성한다.
		Product res = new Product();
		// 전달받은 문자열을 파싱한다.
		String[] splitStr = info.split(":");
		// 생성된 객체의 변수에 값을 할당한다.
		res.model = splitStr[0];
		res.price = Integer.parseInt(splitStr[1]);
		res.maker = splitStr[2];
//		String model = splitStr[0];
//		int price = Integer.parseInt(splitStr[1]);
//		String maker = splitStr[2];
//		Product resres = new Product(model, price, maker);
		
		// 생성된 객체를 리턴한다.
		return res;
	}
}

// 클래스를 정의한다.
class Product {
	// 클래스의 멤버변수를 선언한다.
	public String maker;
	public int price;
	public String model;

//	public Product(String model2, int price2, String maker2) {
//		// TODO Auto-generated constructor stub
//	}

	// 클래스의 멤버변수의 값을 출력하는 메서드를 정의한다.
	@Override
	public String toString() {
		return "Product [maker=" + maker + ", price=" + price + ", model=" + model + "]";
	}
}