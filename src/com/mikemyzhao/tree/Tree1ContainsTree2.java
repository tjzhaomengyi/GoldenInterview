package com.mikemyzhao.tree;

//树1是否包含树2
public class Tree1ContainsTree2 {
	boolean containsTree(TreeNode t1,TreeNode t2){
		if(t2 == null){
			return true;
		}
		return subTree(t1,t2);
	}
	
	boolean subTree(TreeNode r1,TreeNode r2){
		if(r1 == null){
			return false;//大的树已经空了，还未找到子树
		}
		if(r1.data == r2.data) {
			if(matchTree(r1,r2)){
				return true;
			}
		}
		return (subTree(r1.leftChild,r2) || subTree(r1.rightChild,r2));
	}
	
	boolean matchTree(TreeNode r1,TreeNode r2){
		if(r2 == null && r1 == null)//两者都为空
			return true;//子树已经无节点
		//若其中之一为空，但并同时为空
		if(r1 == null || r2 == null){
			return false;
		}
		
		if (r1.data != r2.data){
			return false;//节点数据不匹配
		}
		return (matchTree(r1.leftChild,r2.leftChild) && matchTree(r1.rightChild,r2.rightChild));
	}
	
}
