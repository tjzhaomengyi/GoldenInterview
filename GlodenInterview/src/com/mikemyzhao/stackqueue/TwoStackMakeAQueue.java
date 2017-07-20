package com.mikemyzhao.stackqueue;

import java.util.Stack;

//注意使用shiftStacks，只有在队列需要操作的时候，
//第一个栈的元素，转移到出队列的栈中，而且是while(1st不为空),整体转移过去
//然后弹出第二个栈，相当于出队列
public class TwoStackMakeAQueue<T> {
	Stack<T> stackNewest,stackOldest;
	public TwoStackMakeAQueue() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	} 
	
	public int size(){
		return stackNewest.size() + stackOldest.size();
	}
	
	public void add(T value) {
		//压入stackNewest，最终元素始终位于它的顶端
		stackNewest.push(value);
	}
	
	//将元素从stackNewest移至stackOldest，这么做通常是为了要在stackOldest
	//上执行操作
	private void shiftStacks(){
		if(stackOldest.isEmpty()){
			while(!stackNewest.isEmpty()){
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T peek() {
		shiftStacks();//确保stackOldest含有当前元素
		return stackOldest.peek();//取回最旧元素
	}
	
	public T remove(){
		shiftStacks();//确保stackOldest含有当前元素
		return stackOldest.pop();//弹出最旧的元素
	}
	
	public static void main(String[] args){
		TwoStackMakeAQueue myQueue = new TwoStackMakeAQueue();
		for (int i = 0; i<10; i++){
			myQueue.add(i);
		}
		System.out.println(myQueue.peek());
		
	}
}
