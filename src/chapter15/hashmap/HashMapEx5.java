package chapter15.hashmap;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapEx5 {
	public static void main(String[] args) throws Exception {
		File file = new File("lionking.txt");
		Scanner scanner = new Scanner(file);
		Map<String, Integer> map = new HashMap<>();
		
		while (scanner.hasNext()) {
			String word = scanner.next();
			word = word.toLowerCase();
			if (word.contains("hakuna")) {
				map.compute("hakuna", (k, v) -> (v == null) ? 1 : v + 1);
			} else if (word.contains("matata")) {
				map.compute("matata", (k, v) -> (v == null) ? 1 : v + 1);
			}
//			System.out.println(scanner.next());
		}
		System.out.println(map);
//		System.out.println("파일을 찾았음.");
		
		scanner.close();
	}
}
