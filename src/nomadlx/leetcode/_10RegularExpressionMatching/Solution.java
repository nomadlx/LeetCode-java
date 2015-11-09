package nomadlx.leetcode._10RegularExpressionMatching;

import java.util.Scanner;

public class Solution {
	public static boolean MatchChar(String s, int i, String p, int j) {
		if (p.length() <= j) {
			if (s.length() <= i && p.length() <= j) {
				return true;
			} else {
				return false;
			}
		}
		boolean start = false;
		boolean match = false;
		// 判断是否带*号
		if (p.length() > j + 1 && p.charAt(j + 1) == '*') {
			start = true;
		}
		// 判断是否匹配
		if (s.length() > i) {
			if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
				match = true;
			}
		}
		if (start && match) {
			return MatchChar(s, i, p, j + 2) || MatchChar(s, i + 1, p, j)
					|| MatchChar(s, i + 1, p, j + 2);
		}
		if (start) {
			return MatchChar(s, i, p, j + 2);
		}
		if (match) {
			return MatchChar(s, i + 1, p, j + 1);
		}
		return false;
	}

	public static boolean isMatch(String s, String p) {
		return MatchChar(s, 0, p, 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String p = sc.nextLine();
		System.out.println(isMatch(s, p));
	}

}
