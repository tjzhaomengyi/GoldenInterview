package com.mikemyzhao.tree;
/*
 * 实现设计算法，找到二叉树中某两个节点的第一个共同祖先
 */
public class FindTwoNodeParent {
//不包含指向父节点的链接
//顺着p和q同在一边的链子，p和q都在某节点的左边，就在左子树中查找
//若都在右边，在右子树中查找共同祖先
//要是p和q不在同一边，表示已经找到同一个共同祖先
	
	//若p为root的子孙，则返回true
	boolean covers(TreeNode root,TreeNode p){
		if(root == null){
			return false;
		}
		if( root == p) return true;
		return covers(root.leftChild,p) || covers(root.rightChild,p);
	}
	
	TreeNode commonAncestorHelper(TreeNode root,TreeNode p,TreeNode q){
		if(root == null) return null;
		if(root == p || root == q) return root;
		boolean is_p_on_left = covers(root.leftChild,p);
		boolean is_q_on_left = covers(root.leftChild,q);
		//若p和q不在同一边，则返回root
		if(is_p_on_left != is_q_on_left) return root;
		//否则就在同一边，遍访那一边
		TreeNode child_side = is_p_on_left ? root.leftChild:root.rightChild;
		return commonAncestorHelper(child_side,p,q);
	}
	
	TreeNode commonAncestor(TreeNode root,TreeNode p,TreeNode q){
		if(!covers(root,p) || !covers(root,q)){
			return null;
		}
		return commonAncestorHelper(root,p,q);
	}
}
