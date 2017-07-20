package com.mikemyzhao.stackqueue;

import java.util.ArrayList;
import java.util.Stack;

//多个stack组成一个栈，如果这个栈太大，用另一个栈继续实现，pop和push效果和一个栈一样
public class SetOfStack {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	private static final int STACK_MAX = 30;
	//push对栈数组的最后一个栈进行push，若一个栈满了，需要新建一个栈
	public void push(int v){
		Stack last = getLastStack();
	
		if(last != null && !isFull(last)){
			last.push(v);
		}else{
			Stack stack = new Stack();
			stack.push(v);
			stacks.add(stack);			
		}
	}
	
	//从最后一个栈弹栈
	public int pop(){
		Stack last = getLastStack();
		int v = (int) last.pop();
		if(last.size() == 0){
			stacks.remove(stacks.size()-1);
		}
		return v;
	}
	
	private Stack getLastStack(){
		if(stacks.isEmpty()){
			return null;
		}else{
			return stacks.get(stacks.size()-1);
		}
	
	}
	
	private boolean isFull(Stack stack){
		if(stack.size() > STACK_MAX){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		SetOfStack sos = new SetOfStack();
		for(int i=0; i<100; i++){
			sos.push(i);
		}
		System.out.println("Stacks size is "+sos.stacks.size());
	}
	
}
