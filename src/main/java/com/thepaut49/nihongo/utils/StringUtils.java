package com.thepaut49.nihongo.utils;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

	public static boolean isEmpty(String string) {
		return string == null ? true : string.isEmpty() ;
	}
	
	// Function to convert String to List of Characters 
    public static List<Character> convertStringToCharList(String str) 
    { 
      // Create an empty List of character 
      List<Character> chars = str 
      // Convert to String to IntStream 
      .chars() 
      // Convert IntStream to Stream<Character> 
      .mapToObj(e -> (char)e) 
      // Collect the elements as a List Of Characters 
      .collect(Collectors.toList()); 
  
      // return the List 
      return chars; 
    } 
}
