package com.turkcell.training.annotatins.project;

import java.lang.reflect.Field;
import java.util.UUID;

public class RandomEngine {
	public Object proces(Object obj) throws Exception{
		Class<?> class1 = obj.getClass();
		Field[] declaredFields = class1.getDeclaredFields();
		for (Field field : declaredFields) {
			Random randAnnotation = field.getAnnotation(Random.class);
			if (randAnnotation != null) {
				field.setAccessible(true);
				Class<?> type = field.getType();
				switch (type.getName()) {
				case "java.lang.String":
					field.set(obj, UUID.randomUUID().toString());
					break;
				case "int":
					field.setInt(obj, new java.util.Random().nextInt(randAnnotation.max()));
					break;

				default:
					break;
				}
			}
		}
		return obj;
	}
	
	public static void main(String[] args) throws Exception {
		RandomEngine engine = new RandomEngine();
		MyObject proces = (MyObject) engine.proces(new MyObject());
		System.out.println(proces);
	}
}
