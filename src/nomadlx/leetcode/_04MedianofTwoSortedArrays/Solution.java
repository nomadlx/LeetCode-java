package nomadlx.leetcode._04MedianofTwoSortedArrays;

import java.util.Random;

public class Solution {
	/**
	 * 查找两个已排序数组的中间值
	 * 
	 * @param nums1
	 *            已排序数组一
	 * @param nums2
	 *            已排序数组二
	 * @return 中间值
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int start1 = 0, start2 = 0, end1 = nums1.length - 1, end2 = nums2.length - 1;// 起始和终点指针
		int sval = 0, eval = 0;// 记录最近一次去除的最小元素和最大元素
		// 当两个数组里都还有元素的时候
		while (start1 <= end1 && start2 <= end2) {
			// 起始指针后移并记录当前数值
			if (nums1[start1] <= nums2[start2]) {
				sval = nums1[start1];
				start1++;
			} else {
				sval = nums2[start2];
				start2++;
			}
			// 终点指针前移并记录当前值
			if (nums1[end1] >= nums2[end2]) {
				eval = nums1[end1];
				end1--;
			} else {
				eval = nums2[end2];
				end2--;
			}
		}
		// 只有数组一有元素的时候
		while (start1 <= end1) {
			// 起始指针后移并记录当前数值
			sval = nums1[start1];
			start1++;
			// 终点指针前移并记录当前值
			eval = nums1[end1];
			end1--;
		}
		// 只有数组二有元素的时候
		while (start2 <= end2) {
			// 起始指针后移并记录当前数值
			sval = nums2[start2];
			start2++;
			// 终点指针前移并记录当前值
			eval = nums2[end2];
			end2--;
		}
		return (sval + eval) / 2.0;
	}

	/**
	 * 随机生成数字数组
	 * 
	 * @param l
	 *            数组最大长度
	 * @return 生成的数组
	 */
	public static int[] Random(int l) {
		Random random = new Random();
		int n = random.nextInt(l);
		int[] nums = new int[n];
		int pre = 0;
		for (int i = 0; i < n; i++) {
			pre = nums[i] = random.nextInt(3) + pre;
		}
		return nums;
	}

	/**
	 * 转换数字数组到字符串
	 * 
	 * @param nums
	 *            数字数组
	 * @return 字符串
	 */
	public static String toString(int[] nums) {
		String string = "";
		for (int i = 0; i < nums.length; i++) {
			string = string + " " + nums[i];
		}
		return string;
	}

	public static void main(String[] args) {
		int[] nums1 = Random(9), nums2 = Random(12);
		System.out.println(toString(nums1));
		System.out.println(toString(nums2));
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

}
