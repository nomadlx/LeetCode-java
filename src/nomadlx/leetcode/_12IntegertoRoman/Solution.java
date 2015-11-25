package nomadlx.leetcode._12IntegertoRoman;

public class Solution {
	private static String[][] romanSet = {
			{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
			{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
			{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
			{ "", "M", "MM", "MMM" } };

	public static String intToRoman(int num) {
		StringBuilder str = new StringBuilder(16);
		String numStr = String.valueOf(num);
		int length = numStr.length();
		int d;
		for (int i = 0; i < length; i++) {
			d = numStr.charAt(i) - '0';
			str.append(romanSet[length - 1 - i][d]);
		}
		return str.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(10));
	}

}
