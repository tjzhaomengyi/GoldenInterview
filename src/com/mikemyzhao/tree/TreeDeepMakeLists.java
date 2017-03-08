package com.mikemyzhao.tree;

import java.util.ArrayList;
import java.util.LinkedList;

//给定一个二叉树，设计一个算法，创建含有某一深度上所有节点的链表
//若一棵树深度为D，有D个链表
public class TreeDeepMakeLists {
//对前序遍历做个修改，将level+1传到下一个队规，使用深度优先搜索实现
	
	void createLevelLinkedList(TreeNode root,ArrayList<LinkedList<TreeNode>> lists,int level){
		if (root == null)return;
		LinkedList<TreeNode> list = null;
		if(lists.size()==level){
			//该层不在链表中
			list = new LinkedList<TreeNode>();
			//以中序遍历所有层级，因此若这是第一次访问第i层，则表示我们已经访问过0到i-1层
			//因此我们可以安全地将这一层加到链表末端
			lists.add(list);
		}else{
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.leftChild,lists,level+1);
		createLevelLinkedList(root.rightChild,lists,level+1);
	}
	
	ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root,lists,0);
		return lists;
	}
	
	//广度优先搜索
	ArrayList<LinkedList<TreeNode>> createLevelLinkedList2(TreeNode root){
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		//访问根节点
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root != null){
			current.add(root);
		}
		while(current.size()>0){
			result.add(current);//加上上一层
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for(TreeNode parent:parents){
				if(parent.leftChild != null){
					current.add(parent.leftChild);
				}
				if(parent.rightChild != null){
					current.add(parent.rightChild);
				}
				
			}
		}
		return result;
	}
	
}
