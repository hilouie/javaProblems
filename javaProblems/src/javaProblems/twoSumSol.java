
/*Given an array of ints, return indices of the two numbers such that
 *they add up to a specific target.
 *
 * Each input would have exactly one solution
 * May not use same element twice
 * 
 */

package javaProblems;

import java.util.HashMap;
import java.util.Map;

public class twoSumSol {
	
	/*Go through the array and check if it adds up to the target*/
	/*Time complexity O(n^2)
	 *Space complexity O(1)
	 */
	public static int[] twoSumBF(int[] nums, int target) {
		int [] result = new int[2];
		for(int i = 0; i < nums.length; i++) {
			for(int j = i+1; j< nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					
					return result;
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	/*
	 * Using hashmap to keep track of elements in array
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	
	public static int[] twoSumHMaps(int[] nums, int target) {
		int [] result = new int[2];
		
		//create a hashmap
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		//loop through array
		for(int i = 0; i < nums.length; i++) {
			//check if the key value and the current number add up to target
			if(map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				return result;
			}
			else {
				//if not put the current number and its index in the hashmap
				map.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 11, 2,  7, 15};
		
		System.out.printf("[%d, %d]\n", twoSumBF(nums, 9)[0], twoSumBF(nums, 9)[1]);
		System.out.printf("[%d, %d]\n", twoSumHMaps(nums, 9)[0], twoSumHMaps(nums, 9)[1]);

	}

}
