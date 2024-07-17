package practiceAPI;
//"iphone16:1900000:apple"
//문자열을 전달받아서 그 문자열을 파싱하여 객체로 리턴합니다.
//그 객체는 Product, model/price/maker라는 객체변수가 있습니다.
//이러한 메서드를 생성합니다.
//main 메서드가 있는 코드를 비공개 댓글로 제출합니다.
public class APIString2 {
    public static void main(String[] args) {
        // 문자열을 파싱하여 Product 객체 생성
        String input = "iphone16:1900000:apple";
        Product2 pdt = Product2.parseProduct(input);

        // 결과 출력
        System.out.println("> 제품명 " + pdt.model);
        System.out.println("> 가 격 " + pdt.price);
        System.out.println("> 제조사 " + pdt.maker);
    }
}

class Product2 {
    String model;
    int price;
    String maker;

    Product2(String model, int price, String maker) {
        this.model = model;
        this.price = price;
        this.maker = maker; 
        //앞에 maker: Product 클래스의 멤버변수 | 옆에 maker: 지역변수 매개변수
    }

    // 문자열을 파싱하여 Product 객체를 반환하는 메서드
    static Product2 parseProduct(String str) {
        String[] res = str.split(":");
        String model = res[0];
        int price = Integer.parseInt(res[1]);
        String maker = res[2];
        return new Product2(model, price, maker);
    }
}
