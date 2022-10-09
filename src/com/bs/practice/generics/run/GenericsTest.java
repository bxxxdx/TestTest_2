package com.bs.practice.generics.run;

import java.util.HashMap;

import com.bs.practice.generics.model.vo.Farm;
import com.bs.practice.generics.model.vo.Fruit;

public class GenericsTest {
	public static void main(String[] args) {
		HashMap<Farm, Integer> hMap = new HashMap<>();
		
		Farm f = new Farm("과일");
		Farm f2 = new Farm("야채");
		//hMap.put(f, 10);
		//hMap.put(f2, 20);
		//hMap.put(f, 30);
		
		Farm f3 = new Fruit("과일","사과");
		Farm f4 = new Fruit("과일", "사과");
		
		hMap.put(f3, 50);
				hMap.forEach((key,value)-> System.out.println(key + " / " + value));
		System.out.println("=============");
		//hMap.remove(f4);
		hMap.forEach((key,value)-> System.out.println(key + " / " + value));
		System.out.println(hMap.containsKey(f4));
		
		
	}
}
