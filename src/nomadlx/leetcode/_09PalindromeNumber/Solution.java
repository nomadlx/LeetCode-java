package nomadlx.leetcode._09PalindromeNumber;

import java.util.Scanner;

public class Solution {
	public static boolean isPalindrome(int x) {
		boolean tag = true;
		if (x < 0) {
			tag = false;
		}
		int digit = 0;
		int temp = x;
		while (temp > 0) {
			temp = temp / 10;
			digit++;
		}
		while (digit > 1) {
			int right = x % 10;
			int left = (int) (x / (Math.pow(10, digit - 1)));
			if (right != left) {
				tag = false;
				break;
			}
			x = (int) (x - left * Math.pow(10, digit - 1))/10;
			digit -= 2;
		}
		return tag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(isPalindrome(sc.nextInt()));
	}

}
