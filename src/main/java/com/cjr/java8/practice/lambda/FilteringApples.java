package com.cjr.java8.practice.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {
	
	public static void main(String ...args) {
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple(100, "green"));
		inventory.add(new Apple(200, "green"));
		inventory.add(new Apple(300, "red"));
		
		List<Apple> greenApples = filterGreenApples(inventory);
		System.out.println(greenApples);
		
		greenApples = filterApples(inventory, (Apple t) -> "red".equals(t.getColor()));
		System.out.println(greenApples);
		
	}
	
	public static List<Apple> filterGreenApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory) {
			if("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
