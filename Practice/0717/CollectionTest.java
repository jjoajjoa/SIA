// Collection에는 List, Set Map 타입이 있음
// 그 중 List: 동적배열(크기변경가능), 인덱스로 참조함(0번째, 1번째)

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
		int[] list1 = new int[5];
		List<Integer> list2 = new ArrayList<Integer>();
		List list3 = new ArrayList();

//		list2.add("Hello"); // Integer 타입만 넣을 수 있도록 한정시켰기 때문에 에러

		list3.add(44);
		list3.add("Hello");
		list3.add(new String());

		System.out.println(list3.size());

		for (Object obj : list3) {
			System.out.println(obj);
		}

		for (int i = 0; i < list3.size(); i++) {
			Object obj = list3.get(i);
			System.out.println(obj);
		}
	}

}
