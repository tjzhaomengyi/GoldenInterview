package com.mikemyzhao.stackqueue;

import java.util.Stack;

//方法2：利用额外的栈来记录min,这个类就是实现一个类，继承自stack
//保持压栈的值，比当前min栈的栈顶小，弹栈的时候等于的时候min弹出
public class PopPushMinStack2 extends Stack<Integer>{
	Stack<Integer> s2;
	public PopPushMinStack2() {
		s2 = new Stack<Integer>();
	}
	
	public void push(int value){
		if(value <= min()){
			s2.push(value);
		}
		super.push(value);
	}
	
	public Integer pop(){
		int value = super.pop();
		if(value == min()){
			s2.pop();
		}
		return value;
	}
	
	public int min() {
		if(s2.isEmpty()) {
			return Integer.MAX_VALUE;
		}else{
			return s2.peek();
		}
	}
	
}
