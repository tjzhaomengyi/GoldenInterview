package com.mikemyzhao.listquestion;

//删除链表某个节点，但只能访问该节点,尾节点就不行了
public class DelNode {
	//直接将后继节点的数据复制到当前节点
	public static boolean deleteNode(Node n){
		if(n == null || n.next == null)
			return false;
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
}
