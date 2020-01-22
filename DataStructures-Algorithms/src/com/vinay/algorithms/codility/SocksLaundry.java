/**
 * 
 */
package com.vinay.algorithms.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



/**
 * @author VINAY
 *
 */
public class SocksLaundry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] C = {1,1,3};
		int[] D = {3,3,2};
		
		solution(5, C, D);

	}
	
    private static int solution(int K, int[] C, int[] D) {
        // write your code in Java SE 8
        
        int cleanPairs = 0;
        
        List<Integer> unPairedList = new ArrayList<Integer>();
        
        int cLen = C.length;
        
        if(cLen == 1)
        	unPairedList.add(C[0]);
        else {
        	Arrays.sort(C);
        	Arrays.sort(D);
        }
        
        for(int i =0 ; i < cLen-1; i = i+2){
            
            if(C[i] == C[i+1]){
                cleanPairs++;
            }
            else{
                unPairedList.add(C[i]);
                unPairedList.add(C[i+1]);
            }
        }
        if(cLen%2 != 0)
        	unPairedList.add(C[cLen-1]);
        
        int unpairedLength = unPairedList.size();
        
        List<Integer> unmatchedList = Arrays.stream(D).boxed().collect(Collectors.toList());
        
    	for(int i = 0; i < unpairedLength; i++) {
    		
    		int target = unPairedList.get(i);
    		
    		for(int j = 0; j < D.length && K > 0; j++) {
    			if(target == D[j]) {
	    			cleanPairs++;
	    			K--;
	    			unmatchedList.remove(j);
	    			break;
    			}
    		}
    	}
    	if(K > 1) {
    		int[] umatchedArr = unmatchedList.stream().mapToInt(Integer::intValue).toArray();
    		
    		 if(umatchedArr.length == 1)
            	return cleanPairs;
            else {
	            	Arrays.sort(umatchedArr); 
	    	        for(int i =0 ; i < umatchedArr.length-1 && (K > 1); i = i+2){
	    	            if(umatchedArr[i] == umatchedArr[i+1]){
	    	                cleanPairs++;
	    	                K = K-2;
	    	            }
	    	        }   			
            }
    	}
        return cleanPairs;
    }

}
