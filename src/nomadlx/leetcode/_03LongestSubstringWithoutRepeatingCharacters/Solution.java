package nomadlx.leetcode._03LongestSubstringWithoutRepeatingCharacters;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Solution {
	/**
	 * 获取最长的子字符串的长度
	 * 
	 * @param s
	 *            源字符串
	 * @return 最长的子字符串长度
	 */
	public static int lengthOfLongestSubstring(String s) {
		Queue<Character> queue = new LinkedList<Character>();// 子字符串存储队列
		int max = 0;// 存储最长长度
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			// 遇到重复字符，子字符串出队列直到不重复
			if (queue.contains(ch)) {
				if (max < queue.size()) {
					max = queue.size();
				}
				while (queue.contains(ch)) {
					queue.poll();
				}
			}
			queue.offer(ch);
		}
		// 最后形成的子字符串长度判断
		if (max < queue.size()) {
			max = queue.size();
		}
		return max;
	}

	/**
	 * 随机生成包含abc的字符串
	 * 
	 * @param l
	 *            最长长度
	 * @return 生成的字符串
	 */
	public static String random(int l) {
		Random random = new Random();
		int n = random.nextInt(l);
		String string = "";
		for (int i = 0; i < n; i++) {
			string += (char) (97 + random.nextInt(3));
		}
		return string;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = random(20);
		System.out.println(string);
		System.out.println(lengthOfLongestSubstring(string));
	}

}
