package com.cjr.java8.practice.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 集合过滤示例: 实践 java 8 的 "行为参数化"思想， lambda的类型推断
 * @author cjr
 * @date 2018-12-25
 *
 */
public class FilteringApples {
	
	public static void main(String ...args) {
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple(100, "green"));
		inventory.add(new Apple(200, "green"));
		inventory.add(new Apple(300, "red"));
		
		//1. 过滤绿色的苹果： 传统做法，写一个方法循环遍历并判断
		List<Apple> greenApples = filterGreenApples(inventory);
		System.out.println(greenApples);
		
		//2. 过滤绿色的苹果： 传统做法，使用匿名内部内传递过滤行为
		greenApples = filterGreenApples(inventory, new IFilterApple() {
			@Override
			public boolean test(Apple apple) {
				return "green".equals(apple.getColor());
			}
		});
		System.out.println(greenApples);
		
		//3. 过滤绿色的苹果： 使用lambda表达式
		greenApples = filterApples(inventory, (Apple t) -> "green".equals(t.getColor()));
		System.out.println(greenApples);

		//4. 过滤绿色的苹果： 使用lambda表达式
		greenApples = filterApples(inventory, t -> "green".equals(t.getColor()));
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
	
	public static List<Apple> filterGreenApples(List<Apple> inventory, IFilterApple iFilterApple){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory) {
			if(iFilterApple.test(apple)) {
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
