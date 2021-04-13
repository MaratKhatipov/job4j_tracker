package example;

import ru.job4j.lambda.Attachment;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

	public class Outer {

		public static void main(String[] args) {
			String s1 = "aaa";
			String s2 = "a";
			Comparator<String> cmpSize = (left, right)
					-> right.length() - left.length();
			int rsl = cmpSize.compare(s1, s2);
			System.out.println(cmpSize.compare(s1, s2));
			}

	}
