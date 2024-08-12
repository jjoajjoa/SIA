package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class FileTest {	
	public static void main(String[] args) throws Exception {
		//product_list.txt 파일을 읽어온다.
		//BufferedReader class사용
		List<String> list = new ArrayList<String>();
		Reader file = new FileReader("C:/Users/LX/eclipse-workspace/myweb/product_list.txt");
		BufferedReader br = new BufferedReader(file);
		String line = br.readLine(); // line이라는 변수가 뭐냐? 컴퓨터에서 변수라는 것은 메모리를 할당받고 거기에 이름붙인 것.
		while(line!=null) {
			System.out.println(line);
			list.add(line);
			line = br.readLine();
		}
		System.out.println(list);
		// file을 읽어서 그 파일에 저장된 제품 정보 목록을 리턴받는다.
		List<Product> productList = readProductList();
	}

	private static List<Product> readProductList() {
		// TODO Auto-generated method stub
		return null;
		
	}
	
}
// input -> line -> output
// input은 file이 될 수도 있고, 키보드나 마우스가 될수도 있음. 이런것이 IO임.
