package nomadlx.leetcode._05ZigZagConversion;

import java.util.Scanner;

public class Solution {
	
	public static String convert(String s, int numRows) {
		int c = numRows * 2 - 2 == 0 ? 1 : numRows * 2 - 2;
		int OLOC = 0;
		String ns = "";
		for (int i = 0; i < numRows; i++) {
			int LOC = OLOC;
			if (OLOC == 0 || OLOC * 2 == c) {
				while (LOC < s.length()) {
					ns = ns + s.charAt(LOC);
					LOC += c;
				}
			} else {
				while (LOC < s.length()) {
					ns = ns + s.charAt(LOC);
					if (LOC + (c - OLOC - OLOC) < s.length())
						ns = ns + s.charAt(LOC + (c - OLOC - OLOC));
					LOC += c;
				}
			}
			OLOC++;
		}
		return ns;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int numRows = sc.nextInt();
		System.out.println(convert(s, numRows));
	}

}
