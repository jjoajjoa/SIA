import java.util.ArrayList;

public class listTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("admin");
		list.add("guest");
		list.add("world");
		
		list.remove("hello");
		list.remove(0);
		
		for(String name : list) {
			System.out.println(name);
		}
		
		for (int i=0 ; i<list.size(); i++) {
			if(list.get(i).equals("admin")) {
				list.remove(i);
				break;
			}
		}
		for(String name : list) {
			if(name.equals("guest")) {
				list.remove("guest");
				break;
			}
		}
	}

}
