package com.mikemyzhao.listquestion;

import java.util.Stack;

public class IsHuiWenPalindrome27 {
	/*
	 * 编写一个函数，检查链表是否为回文,回文定义0-1-2-1-0，正反看都一样
	 */
	/*
	 * 法1：翻转比较，原链表和翻转链表前半部分相同就可
	 */
	/*
	 * 法2：迭代法，利用栈链表长度已知，将前半部分入栈，然后比较，注意奇数
	 * 若长度未知，使用快慢指针访问链表。迭代的每一步将慢速runner的数据入栈。
	 * 在快速runner抵达链表尾部时，慢速runner正好到达链表中间
	 * 接下来，比较当前节点和栈顶元素，完成迭代时，比较结果相同，该链回文
	 */
	boolean isPalindrome(Node head){
		Node fast = head;
		Node slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		/*将链表前半部分入栈，当快速runner移动速度为慢速runner的两倍到达链表尾部，
		*则慢速runner已处在链表中间位置
		*/
		while(fast != null && fast.next != null){
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		//链表有奇数个元素，跳过中间元素
		if(fast != null){
			slow = slow.next;
		}
		while( slow != null){
			int top = stack.pop().intValue();
			//两者不相同，则链表不是回文序列
			if(top != slow.data){
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.addFirstNode(0);
		for(int i=1; i<5; i++){
			l1.add(i, i);
		}
		//LinkedList l2 = new LinkedList();
		//l2.addFirstNode(4);
		for(int j=4;j>=0;j--){
			l1.add(9-j, j);
		}
		l1.displayAllNodes();
		IsHuiWenPalindrome27 hw = new IsHuiWenPalindrome27();
		boolean res = hw.isPalindrome(l1.head);
		System.out.println(res);
	}
	
}
