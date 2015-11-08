package nomadlx.leetcode._08StringtoInteger_atoi;

import java.util.Scanner;

public class Solution {
	public static int myAtoi(String str) {
		int value = 0;
		int sign = 1;
		int index = 0;
		while (str.length() > index && str.charAt(index) == ' ') {
			index++;
		}
		if (str.length() > index) {
			if (str.charAt(index) == '-') {
				sign = -1;
				index++;
			} else if (str.charAt(index) == '+') {
				index++;
			}
		}
		int ch;
		for (; index < str.length(); index++) {
			ch = str.charAt(index);
			if (ch > '9' || ch < '0') {
				break;
			}
			if(sign==1){
				if (Integer.MAX_VALUE / 10 < value
						|| (Integer.MAX_VALUE / 10 == value && ch > '7')) {		
						return Integer.MAX_VALUE;	
				}
			}else{
				if (Integer.MAX_VALUE/ 10 < value
						|| (Integer.MAX_VALUE / 10 == value && ch > '8')) {		
						return Integer.MIN_VALUE;	
				}
			}
			value *= 10;
			value += ch - '0';
		}
		return value * sign;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(myAtoi(str));
	}

}
