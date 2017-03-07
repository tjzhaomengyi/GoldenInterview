package com.mikemyzhao.tree;
//用一个Java泛型
public class TreeNode<T> {
	//数据
	T data;
	TreeNode<T> leftChild;
	TreeNode<T> rightChild;
	
	public T getData(){
		return data;
	}
	
	public void setData(T data){
		this.data = data;
	}
	
	TreeNode() {
		this.data = null;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	TreeNode(T data){
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	public TreeNode(T data,TreeNode<T> leftChild,TreeNode<T> rightChild){
		super();
		this.data=data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	
	public void setLeftChild(TreeNode<T> leftChild){
		this.leftChild = leftChild;
	}
	
	public TreeNode<T> getRightChild(){
		return rightChild;
	}
	
	public void setRightChild(TreeNode<T> rightChild){
		this.rightChild = rightChild;
	}
	
	public boolean isLeaf(){
		if(this.leftChild == null && this.rightChild == null){
			return true;
		}
		return false;
	}
}
