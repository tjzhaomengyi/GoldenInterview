package com.mikemyzhao.listquestion;

public class SeperateListByX24 {
	/*
	 * 以值x为基准将链表分割成两部分，小于x的节点排在大于或等于x的节点之前
	 * 
	 */
	//针对链表，我们不必移动和交换元素，可以直接创建两个链表：一个链表存放小于x的元素，另一个链表存放大于或等于x的元素
	public Node partition(Node node,int x){
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		//分割表
		while(node != null){
			//把node的下一位进行缓存
			Node next = node.next;
			//把元素取出来置空
			node.next = null;
			if (node.data < x){
				//将节点插入before链表
				if(beforeStart == null){
					beforeStart = node;
					beforeEnd = beforeStart;
				}else{
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				//将节点插入after链表
				if(afterStart == null){
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		if(beforeStart == null){
			return afterStart;
		}
		//合并before和after链表
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	//结点不再追加至before和after链表的末端，而是插入这两个链表的前端
	public Node partition2(Node node,int x){
		Node beforeStart = null;
		Node afterStart = null;
		
		//分割链表
		while(node != null){
			Node next = node.next;
			if(node.data < x){
				//将结点插入before链表的前端
				node.next = beforeStart;
				beforeStart = node;
			}else{
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}
		if(beforeStart == null){
			return afterStart;
		}
		//定位值before链表末尾，合并两个链表
		Node head = beforeStart;
		while(beforeStart.next != null){
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;
		return head;
	}
	public static void main(String[] args){
		LinkedList linkedlist = new LinkedList();
		linkedlist.addFirstNode(0);
		for (int i = 1; i < 10; i++){
			linkedlist.add(i, 10-i);
		}
		SeperateListByX24 s = new SeperateListByX24();
		Node partitionhead = s.partition(linkedlist.head, 5);
		LinkedList.displayAllNodes(partitionhead);
	}
	
}
