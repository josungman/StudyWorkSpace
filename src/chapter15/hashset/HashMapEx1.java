package chapter15.hashset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapEx1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(3);
		list.add(4);
		
		
		
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0, 1);
		map.put(2, 3);
		map.put(3, 4);
		map.put(0, 3);
		System.out.println(map.size());
		
		System.out.println(map.get(0));
		System.out.println(map.get(3));
		
		Set<Integer> keys =  map.keySet();
		
		for (Integer i : keys) {
			System.out.println("key : " + i  + " Value : " + map.get(i));
		}
		
		
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Map.Entry<Integer, Integer>> iter = set.iterator();
		
		while(iter.hasNext()) {
			Map.Entry<Integer, Integer> entry = iter.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
			
		}
		
	}
}
