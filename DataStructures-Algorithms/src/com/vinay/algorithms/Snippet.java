package com.vinay.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Snippet {
	public static void main(String[] args) {
		
//		int[] A = {};
//        int longest_run = 0;
//        int count = 0;
//        for( int i = 0; i < A.length -1; i++){
//           
//           if( Math.abs(A[i] - A[i+1]) == 1 )
//        	   count++;
//           else {
//        	   
//        	   longest_run = Math.max(count, longest_run);
//        	   count = 0;
//           }
//        }
        
//        String S = "1At";
//        String T = "1a1";
//        boolean value = solution(S,T);
//        
//        System.out.println(" Strings are : "+value);
		
        String x1 = String.format("%8s", Integer.toBinaryString(0xFF & 1)).replaceAll(" ", "0");
        String y1 = Integer.toBinaryString(0xFF & 3);
        int count = 0;
        for(int i = 0; i < x1.length(); i++){
            
            if( x1.charAt(i) != y1.charAt(i))
            	count++;
        }
        System.out.println(count);
    //    return count;

	}
	
    public static boolean solution(String S, String T) {
    	
    	boolean equal = false;


    	String sStr = expandString(S);
    	String tStr = expandString(T);
    	
    	if( sStr.length() != tStr.length())
    		return equal;
    	else {
    		
    		for(int i = 0; i <sStr.length(); i++) {
    			char s = sStr.charAt(i);
    			char t = tStr.charAt(i);
    			if(s != '?' && t != '?' && s != t) {
    				equal = false;
    				break;
    			}
    		}
    	}

    	return equal;
    }
   
//   Given two integers tomatoSlices and cheeseSlices. The ingredients of different burgers are as follows:
//
//    	Jumbo Burger: 4 tomato slices and 1 cheese slice.
//    	Small Burger: 2 Tomato slices and 1 cheese slice.
//   Return [total_jumbo, total_small] so that the number of remaining tomatoSlices equal to 0 
//   and the number of remaining cheeseSlices equal to 0. 
//   If it is not possible to make the remaining tomatoSlices and cheeseSlices equal to 0 return [].
    private static String expandString(String S) {
    	
    	String sStr = "";
    	
    	Map<String, String> map = new HashMap<String, String>();
      	map.put("1", "?");
    	map.put("2", "??");
    	map.put("3", "???");
    	map.put("4", "????");
    	map.put("5", "?????");
    	map.put("6", "??????");
    	map.put("7", "???????");
    	map.put("8", "????????");
    	map.put("9", "????????");
    	
    	for(int i = 0; i < S.length(); i++) {
    		if( Character.isDigit(S.charAt(i))) {
    			 String value = map.get(S.charAt(i)+"");
    			 sStr = sStr + value;
    		}
    		else
    			sStr = sStr + S.charAt(i);
    	} 
    	return sStr;
    }
    
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        List<Integer> totalBurgers = new ArrayList<Integer>();
            
        int mini = 0;
        int big = 0;
        int remaining = 0;
        
        if( tomatoSlices == 0 || cheeseSlices == 0){
            totalBurgers.add(big);    
            totalBurgers.add(mini);
            
        }
        
        else if( tomatoSlices <= cheeseSlices){
                 mini = -1;
                 big = -1;
        }
        else { 
            int total = mini+big;
            if(tomatoSlices % 2 == 1){
                 mini = -1;
                 big = -1;                
            }
            else{
                mini = tomatoSlices / 2;
                total = mini;
                while ( total != cheeseSlices){
                    if( mini > cheeseSlices){
                        mini -= 2;
                        big++;
                    }
                    total = mini+big;    
                }
                totalBurgers.add(big);       
                totalBurgers.add(mini);
            }            
        }
        return totalBurgers;
    }
    
	/*
	 * 4x + 2y = tomato x + y = cheese => 2x = tomato - 2 * cheese x = (tomato - 2 *
	 * cheese) / 2 y = cheese - x
	 */
    
    public List<Integer> numOfBurgers100Percent(int tomatoSlices, int cheeseSlices) {
        int twoX = tomatoSlices - 2 * cheeseSlices;
        int x = twoX / 2;
        int y = cheeseSlices - x;
        return twoX >= 0 && twoX % 2 == 0 && y >= 0 ? Arrays.asList(x, y) : new ArrayList<>();
    }
}

