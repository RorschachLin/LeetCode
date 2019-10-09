package legacy.test;

import java.lang.reflect.Method;

public class Father extends People {
	private String name = "fatherlisi";
	
	
	
	public static void main(String[] args) {
		Father father = new Father();
		String reString = father.getName();
		System.out.println(reString);
		Class fatherClass = father.getClass();
		Method[] methods = fatherClass.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}
}
