package com.DSA;
import java.util.*;

public class hashmap {
   public static void main(String args[]) {
       //Creation
       HashMap<String, Integer> map = new HashMap<>();
 
       //Insertion
       map.put("India", 120);
       map.put("US", 30);
       map.put("China", 150);
 
       System.out.println(map);
 
       map.put("China", 180);
       System.out.println(map);
 
 
       //Searching
       if(map.containsKey("Indonesia")) {
           System.out.println("key is present in the map");
       } else {
           System.out.println("key is not present in the map");
       }
 
       System.out.println(map.get("China")); //key exists
       System.out.println(map.get("Indonesia")); //key doesn't exist
 
       int arr[]= {12,15,20};
       for(int i=0;i<arr.length;i++) {
    	   System.out.print(arr[i]+" ");
       }
       System.out.println();
       
       for(int val : arr) {
    	   System.out.print(val+" ");
       }
       System.out.println();
       
       //Iteration (1)
       for( Map.Entry<String, Integer> e : map.entrySet()) {
           System.out.print(e.getKey()+" ");
           System.out.print(e.getValue());
           System.out.println();
       }
 
       //Iteration (2)
       Set<String> keys = map.keySet();
       for(String key : keys) {
           System.out.println(key+ " " + map.get(key));
       }
       
//       Collection<Integer> values = map.values();
       for(int val : map.values()) {
           System.out.print(val +" ");
       }
       System.out.println();
 
       //Removing
       map.remove("China");
       System.out.println(map);
 
   }
}
