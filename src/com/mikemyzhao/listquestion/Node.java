package com.mikemyzhao.listquestion;

public class Node {
	protected Node next;//指针域
	protected int data;//数据域
	
	public Node(int data){
		this.data = data;
	}
	public Node(){
		
	}
	
	//显示此节点
	public void display(){
		System.out.print(data + " ");
	} 
	
	
}
