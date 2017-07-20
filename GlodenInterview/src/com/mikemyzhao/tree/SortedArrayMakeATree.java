package com.mikemyzhao.tree;
//给定一个有序数组，元素各不相同，按照升序排列，创建一棵高度最小的二叉查找树

public class SortedArrayMakeATree {
//从数组中间位置，递归生成树！
//高度最小就是让中间节点成为根节点，数组的每一段的中间元素成为子树的根节点
//递归方法运用createMnimalBST方法，传入数组的一个区段，并返回最小树的根节点

	TreeNode createMinimalBST(int arr[],int start, int end){
		if(end < start){
			return null;
		}
		int mid = (start + end)/2;
		TreeNode n = new TreeNode(arr[mid]);
		n.leftChild = createMinimalBST(arr,start,mid-1);
		n.rightChild = createMinimalBST(arr,mid+1,end);
		return n;
	}
	
	TreeNode createMinimalBST(int array[]){
		return createMinimalBST(array,0,array.length-1);
	}
}
