package example;

import java.util.ArrayList;
import java.util.List;

public class AddElement {
	public static boolean addIndexElement(List<String> list, int index, String str) {
		List<String> check = new ArrayList<>(list);
		check.add(str);
		if (!list.contains(str)) {
			list.add(str);
			return list.size() == check.size();
		}
		return false;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		AddElement.addIndexElement(list, 2, "qwe");
		System.out.println();
		System.out.println(list);
	}
}
