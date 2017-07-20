package com.mikemyzhao.stackqueue;

import java.util.Stack;

/*
 * 3.2实现一个可以pop push还能找到栈中最小值，三个方法时间复杂度为o(1)
 *注意：stack类的使用
 */
public class PopPushMinStack extends Stack<NodeWithMin>{
/*o(1)复杂度的实现，
 * push(5),min=5;push(6),{6,5},min=5;push(3),{3,6,5},min=3...
 * 只要记录下每种状态的最小值，每个节点记录当前最小值。要找到min，直接看栈顶元素
 * 这个相当于一个入栈的值带一个最小值，所以Stack的泛型是个nodewithmin的类
 */
	public void push(int value){
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value,newMin));
	}
	public int min(){
		if(this.isEmpty()){
			return Integer.MAX_VALUE;//错误值
		}else{
			return peek().min;
		}
	}
	
	

}
