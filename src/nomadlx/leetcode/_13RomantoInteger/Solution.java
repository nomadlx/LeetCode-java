package nomadlx.leetcode._13RomantoInteger;

import java.util.HashMap;

public class Solution {
	private static HashMap<Character, Integer> romanIntMap = new HashMap<Character, Integer>();
	static {
		romanIntMap.put('I', 1);
		romanIntMap.put('V', 5);
		romanIntMap.put('X', 10);
		romanIntMap.put('L', 50);
		romanIntMap.put('C', 100);
		romanIntMap.put('D', 500);
		romanIntMap.put('M', 1000);
	}

	public static int romanToInt(String s) {
		int value = 0;
		int preInt = 0, nowInt;
		for (int i = s.length() - 1; i >= 0; i--) {
			nowInt = romanIntMap.get(s.charAt(i));
			if (nowInt >= preInt) {
				value += nowInt;
			} else {
				value -= nowInt;
			}
			preInt = nowInt;
		}
		return value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("DCXXI"));
	}

}
