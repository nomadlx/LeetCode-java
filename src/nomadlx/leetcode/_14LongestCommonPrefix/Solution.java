package nomadlx.leetcode._14LongestCommonPrefix;

public class Solution {
	public static String longestCommonPrefix(String[] strs) {
		int length = Integer.MAX_VALUE;

		if (strs.length == 0) {
			length = 0;
		} else {
			for (int i = 0; i < strs.length; i++) {
				if (length > strs[i].length()) {
					length = strs[i].length();
				}
			}
		}

		StringBuilder stringBuilder = new StringBuilder(length);
		char ch = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < strs.length; j++) {
				if (j == 0 || strs[j].charAt(i) == ch) {
					ch = strs[j].charAt(i);
				} else {
					return stringBuilder.toString();
				}
			}
			stringBuilder.append(ch);
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {};
		System.out.println(longestCommonPrefix(strs));
	}
}
