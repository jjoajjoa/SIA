// Collection에는 List, Set Map 타입이 있음
// 그 중 List: 동적배열(크기변경가능), 인덱스로 참조함(0번째, 1번째)

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
		/* 배열 */
		int[] list1 = new int[5];
		/* List와 ArrayList */
		List<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Integer> list222 = new ArrayList<Integer>();
		List list3 = new ArrayList();
		// 만약 어떤 메서드가 있고 벡터를 리턴한다면 어레이리스트는 사용할 수 없다
		// 내부에서는 좀 더 자유롭게(벡터든 어레이든) 알아서 허용하는 측면을 만들기위해 List를 사용 권장

//		list2.add("Hello"); // Integer 타입만 넣을 수 있도록 한정시켰기 때문에 에러

		list3.add(44);
		list3.add("Hello");
		list3.add(new String());

//		String str = list3.get(1); //Error
		String str = (String) list3.get(1);
		// list3은 정해준게 없는 오브젝트 타입이라서 캐스팅을 해줘야함
		
		list2.add(44);
		int result = list2.get(0);
		// list2는 Integer로 정해줬기 때문에 int로 바로 받을 수 있다

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
