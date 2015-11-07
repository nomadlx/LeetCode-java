package nomadlx.leetcode._07ReverseInteger;

import java.util.Scanner;

public class Solution {
	public static int reverse(int x) {
		int newInt = 0;
		int sign = 1;
		if (x < 0) {
			sign = -1;
			x = -x;
		}
		while (x > 0) {
			if (Integer.MAX_VALUE / 10.0 < newInt) {
				sign = 0;
				break;
			}
			newInt *= 10;
			newInt += x % 10;
			x = x / 10;
		}
		return newInt * sign;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		System.out.println(x);
		System.out.println(reverse(x));
	}

}
