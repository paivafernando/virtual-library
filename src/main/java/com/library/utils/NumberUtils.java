package com.library.utils;

import java.util.Objects;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NumberUtils {

	
	
	public static boolean isValid(Object num) {
		return Objects.nonNull(num);
	}

	public static Long parseToLong(Object num) {
		try{
			StringBuilder sb = new StringBuilder();
			sb.append(num.toString());
			
			return Long.valueOf(sb.toString());
	
		}
		catch(SecurityException ex){
			throw new SecurityException("Error to parse Objetct to Long: " + num  + ". Error Message: {}.", ex);
		}
				
	}
	
	public static Long additionOperate(final Long one, final Long two) {
		return Math.addExact(one, two);
	}

}
