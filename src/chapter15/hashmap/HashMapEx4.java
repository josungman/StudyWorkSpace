package chapter15.hashmap;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapEx4 {
	public static void main(String[] args) throws Exception {
		File file = new File("lionking.txt");
		Scanner scanner = new Scanner(file);
		Map<String, Integer> map = new HashMap<>();
		
		while (scanner.hasNext()) {
			String word = scanner.next();
			word = word.toLowerCase();
			if (word.contains("hakuna")) {
				
				if (map.containsKey("hakuna")) {
					map.put("hakuna", map.get("hakuna") + 1);
				} else {
					map.put("hakuna", 1);
				}
			} else if (word.contains("matata")) {
				if (map.containsKey("matata")) {
					map.put("matata", map.get("matata") + 1);
				} else {
					map.put("matata", 1);
				}
			}
//			System.out.println(scanner.next());
		}
		System.out.println(map);
//		System.out.println("파일을 찾았음.");
		
		scanner.close();
	}
}
