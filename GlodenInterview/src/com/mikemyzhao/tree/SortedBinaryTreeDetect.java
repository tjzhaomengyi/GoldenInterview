package com.mikemyzhao.tree;

//检查一棵二叉树是否为二叉查找树
public class SortedBinaryTreeDetect {
	//法1.利用中序遍历
	public static int last_printed = Integer.MIN_VALUE;
	public static boolean checkBST(TreeNode n){
		if (n == null) return true;
		if(!checkBST(n.leftChild)) return false;
		//检查当前节点
		if((int)n.data <= last_printed) return false;
		last_printed = (int)n.data;
		//递归检查右子树
		if(!checkBST(n.rightChild)) return false;
		return true;//检查前部完毕
	}
	
	boolean checkBST1(TreeNode n){
		return checkBST1(n,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	boolean checkBST1(TreeNode n,int min,int max){
		if (n == null){
			return true;
		}
		if( (int)n.data < min || (int)n.data >= max){
			return false;
		}
		if(!checkBST1(n.leftChild,min,(int)n.data)||(!checkBST1(n.rightChild,(int)n.data,max))){
			return false;
		}
	}
}
