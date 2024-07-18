import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class CollectionTest2 {
// Collection에는 List, Set Map 타입이 있음
	public static void main(String[] args) {
		
		/* Map: 이름을 붙여서 넣어두자 (키, 값) */
//		Map map = new Map(); // Map은 인터페이스라서 객체생성이 안됨
		Map map = new HashMap(); // 그래서 Map 인터페이스의 하위 클래스 중 하나로 생성해야함
		map.put("age", 22);
		map.put("emp", "1111:Lee:2022-02-02");
		map.put("greet", "Hi");

		int age = (int) map.get("age"); // 키로 값을 가져옴
		Object obj = map.get("emp");
		String empInfo = (String) obj;
		//타입을 분명하게 하지 않았기 때문에 강제로 형변환 진행
		
		//처음부터 타입을 명시해주자
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("id", 111);
		map2.put("price", 19900);
		int id = map2.get("id"); // 이렇게하면 형변환 안해도 됨!
		
		
		/* Set: 중복 불가하게 만들자 */
		// set가 가지고있는 키의 목록 보기
		Set<String> setList = new HashSet<String>();
		Set keyList = map.keySet();
		Iterator<String> it = keyList.iterator();
		//Iterator: 요소들을 순차적으로 접근하고, 이를 반복(iterate)하는 데 사용
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
}

}
