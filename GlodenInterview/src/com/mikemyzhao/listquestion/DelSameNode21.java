package com.mikemyzhao.listquestion;

import java.util.Hashtable;

/*
 * 排除未排序链表中的重复结点，进阶：如果不适用临时缓冲区怎么解决
 */
public class DelSameNode21 {

	//使用散列表，直接迭代访问整个链表，将每个节点加入散列表。
	//若发现有重复元素，将该节点从链表中移除，然后继续迭代
	//注意：两个指针，一个是n表示当前移动的节点，previos保证删除的时候指向n的下一位，不删除和n保持同步
	public void deleteDups(Node n){
		Hashtable table = new Hashtable();
		Node previos = null;
		while (n != null){
			if(table.containsKey(n.data)){
				previos.next = n.next;
				System.out.println(previos.data);
			}else{
				table.put(n.data, true);
				previos = n;
			}
			n = n.next;
		}
	}
	
	//如果不使用缓存，用两个指针迭代：current迭代访问整个链表，runner检查后续节点是否重复
	public void deleteDups2(Node head){
		if(head == null) return;
		
		Node current = head;
		while(current != null){
			//移除后续值相同的节点
			Node runner = current;
			if(runner.next.data == current.data){
				runner.next = runner.next.next;
			}else{
				runner = runner.next;
			}
			current = current.next;
		}			
	}
	
	
	public static void main(String[] args){
		LinkedList linkedlist = new LinkedList();
		linkedlist.addFirstNode(0);
		for (int i = 1; i < 10; i++){
			linkedlist.add(i, i);
			
		}
		for (int i = 10; i < 20; i++){
			linkedlist.add(i, 4);
			
		}
		linkedlist.displayAllNodes();
		System.out.println();
		DelSameNode21 dsn = new DelSameNode21();
		dsn.deleteDups(linkedlist.head);
		linkedlist.displayAllNodes();
		System.out.println();
		
		LinkedList linkedlist1 = new LinkedList();
		linkedlist1.addFirstNode(0);
		for (int i = 1; i < 10; i++){
			linkedlist1.add(i, i);
			
		}
		for (int i = 10; i < 20; i++){
			linkedlist1.add(i, 4);
			
		}
		dsn.deleteDups(linkedlist1.head);
		linkedlist1.displayAllNodes();
	}
		
}
