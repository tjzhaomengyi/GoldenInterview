package com.mikemyzhao.listquestion;

public class NthToLast22 {
	//找到倒数第n个节点，并返回其正数的位置
	
	//法1：递归
	public int nthToLast(Node head, int k){
		if (head == null){
			return 0;
		}
		int i = nthToLast(head.next,k)+1;
		if( i == k){
			System.out.println("Index is"+ i + ",data is "+head.data);
		}
		return i;
	}
	//法2：使用包裹类
	public class IntWrapper{
		public int value = 0;
	}
	Node nthToLast2(Node head,int k,IntWrapper i){
		if (head == null){
			return null;
		}
		Node node = nthToLast2(head.next,k,i);
		i.value = i.value+1;
		if (i.value == k){
			return head;
		}
		return node;
	}
	
	//法3：迭代法，双指针
	Node nthToLast3(Node head,int k){
		if( k <= 0 )
			return null;
		Node p1 = head;
		Node p2 = head;
		for (int i=0; i<k-1; i++){
			if(p2 == null) return null;
			p2 = p2.next;
		}
		if(p2 == null) return null;
		//现在以同样的速度移动p1和p2，当p2抵达链表末尾时，p1刚好指向倒数第k个节点
		while(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		System.out.println("Index is "+k+",data is"+p1.data);
		return p1;
	}
	
	
	public static void main(String[] args){
		LinkedList linkedlist = new LinkedList();
		linkedlist.addFirstNode(0);
		for (int i = 1; i < 10; i++){
			linkedlist.add(i, i);
		}
		NthToLast22 ntl = new NthToLast22();
		linkedlist.displayAllNodes();
		ntl.nthToLast(linkedlist.head, 3);
		Node nthtolastnode = ntl.nthToLast3(linkedlist.head, 10);
	}
}
