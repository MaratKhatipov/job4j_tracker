package ru.job4j.ex;

public class FindEl {

	public static int indexOf(String[] value, String key) throws ElementNotFoundException {
		int result = -1;
		for (int index = 0; index < value.length; index++) {
				if (value[index].equals(key)) {
					result = index;
					break;
				}
		}
		if (result == -1) {
			throw new ElementNotFoundException("index not found ");
		}
		return result;
	}

	public static void main(String[] args) {
		String[] value = new String[]{"a", "b", "c", "d", "e"};
		String key = "a";
		try {
			int res = indexOf(value, key);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
