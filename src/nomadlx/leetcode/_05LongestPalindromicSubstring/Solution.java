package nomadlx.leetcode._05LongestPalindromicSubstring;

import java.util.Scanner;

public class Solution {
	public static String longestPalindrome(String s) {
		// 反转字符串
		String ns = new StringBuffer(s).reverse().toString();
		int offset = 0;
		String longestPalindrome = getPalindrome(s, ns, offset);
		offset++;
		String temp;
		while (longestPalindrome.length() < s.length() - offset) {
			temp = getPalindrome(s, ns, offset);
			if (temp.length() > longestPalindrome.length()) {
				longestPalindrome = temp;
			}
			temp = getPalindrome(ns, s, offset);
			if (temp.length() > longestPalindrome.length()) {
				longestPalindrome = temp;
			}
			offset++;
		}
		return longestPalindrome;
	}

	public static String getPalindrome(String s, String ns, int offset) {
		int length = s.length() - offset;
		String Palindrome = "";
		int index = (length) / 2;
		int c = 0;
		for (; index + c + offset < s.length(); c++) {
			if (s.charAt(index + c) != ns.charAt(index + c + offset)) {
				break;
			}
		}
		c--;
		if (c != -1) {
			if (length % 2 != 0) {
				Palindrome = s.substring(index - c, index + c + 1);
			} else {
				Palindrome = s.substring(index - c - 1, index + c + 1);
			}
		}
		return Palindrome;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(longestPalindrome(sc.nextLine()));
	}

}
