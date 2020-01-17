package chapter15.hashset;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HashMapEx2 {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		Map<Integer,Integer> map = new HashMap<>();
		
		
		
		
		
		
		for(int i=0;i<5;i++) {
			int ran = random.nextInt(5);
			System.out.println(ran);
			if (map.containsKey(ran)) {
				int newvalue = map.get(ran) + 1;
				map.put(ran, newvalue);
			}else {
				map.put(ran, 1);
			}
		}
		
		System.out.println(map);
		
	}
	
	
}
