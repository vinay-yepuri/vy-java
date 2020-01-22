/**
 * 
 */
package com.vinay.algorithms.codility.zalando;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author VINAY
 * 
 * There are N bulbs numbered from 1 to N, arranged in a row. 
 * The first bulb is plugged into the power socket and each successive bulb is connected to the previous one.
 * (Second bulb to first, third to second) Initially, all the bulbs are turned off. 
 * A moment K (for K from 0 to N-1), the A[K]-th bulb is turned on.
 * A bulbs shines if it is on and all the previous bulbs are turned on too.
 * I need help in framing a method in java that given an Array A of N different integers from 1 to N, 
 * returns the number of moments for which every turned on bulb shines.
 *
 */
public class BuildShine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A= {2,1,3,5,4};
		int num = findMoments(A);
		System.out.println("num : " +num);
	}
	
	/**
	 * @param A
	 * @return
	 */
	private static int findMoments(int[] A)
	{
		Set<Integer> missing = new HashSet<Integer>();
		Set<Integer> store = new HashSet<Integer>();
		int count = 0;
		for(int i =0; i < A.length; i++)
		{
			if( !store.contains(i+1) && (i+1) != A[i])
				missing.add(i+1);
			if( i+1 < A[i])
				store.add(A[i]);
			else
				missing.remove(A[i]);
			
			if(missing.isEmpty())
				count++;
		}
		return count;
	}

	/**
	 * Vinays Solution
	 * 
	 * @param A
	 * @return
	 */
	private static int solution(int[] A)
	{
        int len = A.length;
        int numOfMoments = 0;
        
        if( A == null || A.length == 0)
        	return 0;
        if(len == 1)
            return (A[0] == 1) ? 1 : 0;
        else
        {
            List<Integer> members = new ArrayList<Integer>();
            
            for(int i = 0; i < len; i++)
            {
                if(A[i] == 1)
                    numOfMoments++;
                else
                {
                   int curVal = A[i];
                   int foundMembers = 0;
                   while(curVal > 0)
                   {
                       if( !members.isEmpty() && members.contains(curVal-1)) 
                    	   foundMembers++;
                       curVal--;
                   }
                   if( curVal == 0 && foundMembers == A[i]-1)
                       numOfMoments++; 
                }
                members.add(A[i]);
            }
        }
        return numOfMoments;
	 }
}
