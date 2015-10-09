package nomadlx.leetcode._02AddTwoNumbers;
import java.util.Random;
public class Solution {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			ListNode p = this;
			String string = "";
			while (p != null) {
				string += p.val + "  ";
				p = p.next;
			}
			return string;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode a, b, c, listNode = new ListNode(0);
		ListNode p = listNode, q = null;
		int nocarry = 0, carry = 0;
		a = l1;
		b = l2;
		while (a != null && b != null) {
			// 共长链部分操作
			int value = a.val + b.val + carry;
			nocarry = value % 10;
			carry = value / 10;
			p.val = nocarry;
			p.next = new ListNode(0);
			q = p;
			p = p.next;
			a = a.next;
			b = b.next;
		}
		c = a == null ? b : a;
		while (c != null) {
			// 非共长链部分操作
			int value = c.val + carry;
			nocarry = value % 10;
			carry = value / 10;
			p.val = nocarry;
			p.next = new ListNode(0);
			q = p;
			p = p.next;
			c = c.next;
		}
		// 处理最后进位部分
		if (carry != 0) {
			p.val = carry;
			p.next = null;
		} else {
			q.next = null;
		}
		return listNode;
	}

	public static ListNode Random() {
		ListNode listNode = new ListNode(0);
		ListNode p = listNode, q = null;
		Random random = new Random();
		int n = random.nextInt(9) + 1;
		System.out.println("n:" + n);
		for (int i = 0; i < n; i++) {
			p.val = random.nextInt(10);
			p.next = new ListNode(0);
			q = p;
			p = p.next;
		}
		q.next = null;
		return listNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = Random();
		System.out.println(a);
		ListNode b = Random();
		System.out.println(b);
		System.out.println(addTwoNumbers(a, b));
	}

}
