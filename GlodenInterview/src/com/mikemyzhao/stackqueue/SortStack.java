package com.mikemyzhao.stackqueue;

import java.util.Stack;

/*
 * 升序排序栈，只能使用一个额外的栈，不得将元素复制到别的数据结构中
 * 支持push/pop/peek/isEmpty
 * 关键：一个tmp保存需要入排序栈的元素，排序栈中的peek大于tmp的话
 * 把排序弹出，压入源栈，插入tmp，然后放
 */
public class SortStack {
	public static Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()){
			int tmp = s.pop();//步骤1
			while(!r.isEmpty() && r.peek() > tmp){
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
	
	
	
}
