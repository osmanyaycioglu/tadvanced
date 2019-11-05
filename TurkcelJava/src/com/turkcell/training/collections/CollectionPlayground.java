package com.turkcell.training.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionPlayground {
	public static void main(String[] args) {
		
		List<String> strings = new ArrayList<>(1_000_000);
		strings.add("osman");
		strings.add("yay");
		
		List<String> synchronizedList = Collections.synchronizedList(strings);
		Vector<String> vdc;
		
		CopyOnWriteArrayList<String> str = null;
		
		Iterator<String> cr = str.iterator();
		
		for (String string : str) {
			
		}
		
		Set<String> set = new HashSet<>();
		
		Map<String, String> map = new HashMap<>();

		Map<String, String> map2 = new ConcurrentHashMap<>(1_000_000,0.9f,1_000);

	} 
}
