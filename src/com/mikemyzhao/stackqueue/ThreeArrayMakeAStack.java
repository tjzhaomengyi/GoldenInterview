package com.mikemyzhao.stackqueue;

/*
 * 3.1用一个数组实现三个栈
 * 
 */
public class ThreeArrayMakeAStack {
//方法1：固定分割，将整个数组三等分，[0,n/3),[n/3,2n/3),[2n/3,n)
	int stackSize = 100;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = {-1,-1,-1};//用于追踪栈顶元素
	void push(int stackNum, int value) throws Exception {
		//检查有无空闲空间
		if(stackPointer[stackNum] + 1 >= stackSize){
			//最后一个元素
			throw new Exception("Out of space");
		}
		//栈指针自增，然后更新栈顶元素的值
		stackPointer[stackNum]++;
		bu
	}	
		
	
	
}
