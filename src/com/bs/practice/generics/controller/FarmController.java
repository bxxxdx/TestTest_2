package com.bs.practice.generics.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.bs.practice.generics.model.vo.Farm;
import com.bs.practice.generics.model.vo.Fruit;
import com.bs.practice.generics.model.vo.Nut;
import com.bs.practice.generics.model.vo.Vegetable;

public class FarmController {
	HashMap<Farm, Integer> hMap = new HashMap<>();
	ArrayList<Farm> list = new ArrayList<>();
	public FarmController() {
		hMap.put(new Fruit("과일", "사과"), 20);
		hMap.put(new Fruit("과일","배"), 30);
		hMap.put(new Fruit("과일","귤"), 500);
		hMap.put(new Vegetable("채소","양배추"), 10);
		hMap.put(new Nut("견과","땅콩"), 50);
		hMap.put(new Nut("견과","호두"), 4);
	}

	public boolean addNewKind(Farm f, int amount) {
		boolean ret = false;
		if (!hMap.containsKey(f) && !f.getKind().equals("") && amount > 0) {
			hMap.put(f, amount);
			ret = true;
		}
		return ret;
	}

	public boolean removeKind(Farm f) {
		boolean ret = false;
		if (hMap.containsKey(f)) {
			hMap.remove(f);
			ret = true;
		}
		return ret;//
	}

	public boolean changeAmount(Farm f, int amount) {
		boolean ret = false;
		if (hMap.containsKey(f) && !f.getKind().equals("") && amount > 0) {
			hMap.put(f, amount);
			ret = true;
		}
		return ret;//
	}

	public HashMap<Farm, Integer> printFarm() {
		return hMap;
	}

	public boolean buyFarm(Farm f) {
		boolean ret = false;
		if(hMap.containsKey(f) && hMap.get(f) > 0) {
			list.add(f);
			hMap.put(f, hMap.get(f)-1);
			ret = true;
		}
		return ret;//
	}

	public boolean removeFarm(Farm f) {
		boolean ret = false;
		if(hMap.containsKey(f) && list.contains(f)) {
			list.remove(f);
			hMap.put(f, hMap.get(f)+1);
			ret = true;
		}
		return ret;//
	}

	public ArrayList<Farm> printBuyFarm() {
		return list;
	}

}
