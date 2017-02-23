package com.mikemyzhao.listquestion;

public class LinkedInt25 {
	/*
	 * 给定两个用链表表示的整数，每个节点包含一个位数。
	 * 这些位数是反向存放的，也就是各位排在链表的首部。
	 * 编写函数对这两个整数求和，并用链表形式返回结果
     示例：输入（7->1->6）+(5->9->2)即617+295=912,输出2->1->9
     进阶假设这些数位是正向存放的，请再做一遍
     示例，输入(6->1->7)+(2->9->5)=9->1->2
	 */
	Node addLists(Node l1,Node l2,int carry){
		//两个链表全部为空且进位为0，则函数返回
		if(l1 == null && l2 == null && carry == 0){
			return null;
		}
		Node result = new Node();
		//将value以及l1和l2的data相加
		int value = carry;
		if(l1 != null){
			value += l1.data;
		}
		if(l2 != null){
			value += l2.data;
		}
		result.data = value % 10;
		//递归,这个写法不错
		Node more = addLists(l1 == null?null:l1.next,l2==null?null:l2.next,value>=10?1:0);
		result.next = more;
		return result;
	}
	
	/*
	 *如果是正着排序 
	 * 
	 */
	
	
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.addFirstNode(7);
		l1.add(1, 1);
		l1.add(2, 6);
		
		LinkedList l2 = new LinkedList();
		l2.addFirstNode(5);
		l2.add(1, 9);
		l2.add(2, 2);
		
		LinkedInt25 ln = new LinkedInt25();
		Node res = ln.addLists(l1.head, l2.head, 0);
		LinkedList.displayAllNodes(res);
	}
}
