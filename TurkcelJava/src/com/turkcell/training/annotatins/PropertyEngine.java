package com.turkcell.training.annotatins;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class PropertyEngine<T> {
	public T processClass(Class<T> tClass) throws Exception {
		PropertySource propertySource = tClass.getAnnotation(PropertySource.class);
		if (propertySource == null) {
			return  null;
		}
		Properties properties = new Properties();
		properties.load(new FileInputStream(propertySource.value()));
		
		T newInstance = tClass.newInstance();
		
		Field[] declaredFields = tClass.getDeclaredFields();
		for (Field field : declaredFields) {
			Property property = field.getAnnotation(Property.class);
			if (property != null) {
				field.setAccessible(true);
				String key = property.value();
				String stringValue = properties.getProperty(key);
				Class<?> typeOfField = field.getType();
				switch (typeOfField.getName()) {
				case "java.lang.String":
					field.set(newInstance, stringValue);
					break;
				case "int":
					field.setInt(newInstance, Integer.parseInt(stringValue));
					break;
				case "long":
					field.setLong(newInstance, Long.parseLong(stringValue));
					break;

				default:
					break;
				}
			}
		}
		return newInstance;
	}
}
