package com.mikemyzhao.listquestion;

public class CircleList26 {
/*
 * 判断链表是否含有环
 * 方法：快慢指针
 * 1、创建两个指针FastPointer和SlowPointer
 * 2、SlowPointer走一步，FastPointer走两步
 * 3、当两者碰在一起时，将SlowPointer指向LinkedList.head，FastPointer保持不变
 * 4、以相同速度移动移动SlowPointer和FastPointer，一次一步，然后返回新的碰撞处
 */
	
	public Node findCircleBeginning(Node head){
		Node slow = head;
		Node fast = head;
		//找出碰撞处，将处于链表中loop_size-k步位置
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				//发生碰撞
				System.out.println("Collision is" + fast.data);
				break;
			}
		}
		//错误检查，没有发生碰撞，说明没有环路
		if(fast == null || fast.next == null){
			return null;
		}
		//将slow指向首部，fast指向碰撞处，两者距离环路起始处k步，若以相同速度则必定会在环路起始处碰在一起
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		//此处两者均指向环路起始处
		return fast;
		
	}
	public static void main(String[] args){
		LinkedList linkedlist = new LinkedList();
		linkedlist.addFirstNode(0);
		for (int i = 1; i < 10; i++){
			linkedlist.add(i, i);
		}
		//构建一个成环的链表
		Node tail = linkedlist.getTail();
		Node circlebegin = linkedlist.findByPost(3);
		tail.next = circlebegin;
		System.out.println("I set circle begin "+circlebegin.data);
		CircleList26 cl = new CircleList26();
		System.out.println(linkedlist.head.data);
		Node node = cl.findCircleBeginning(linkedlist.head);
		System.out.println("Circle Start Point is " + node.data);
	}
}
