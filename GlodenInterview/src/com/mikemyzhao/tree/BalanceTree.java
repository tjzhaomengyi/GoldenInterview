package com.mikemyzhao.tree;
/*
 * 检查二叉树是否平衡，任意一个节点两棵子树的高度差不超过1
 */
public class BalanceTree {

	public static int getHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		return Math.max(getHeight(root.leftChild),getHeight(root.getRightChild()))+1;
	}
	
	public static boolean isBalanced(TreeNode root){
		if(root == null){
			return true;
		}else{
			int heightDiff = getHeight(root.leftChild) - getHeight(root.rightChild);
			if( Math.abs(heightDiff) > 1){
				return false;
			}else{
				return isBalanced(root.leftChild) && isBalanced(root.rightChild);
			}
		}
	}
	
	//优化算法，上面的方法会方法递归访问每个节点的整个子树，时间复杂度为o(nlogn)
	//如果发现子树不平衡直接返回-1，
	//改进过的算法从根节点递归向下检查每棵子树的高度。通过checkHeight方法，递归获取每个节点左右子树的高度
	//若子树是平衡的，则checkHeight返回该子树的实际高度，如果子树不平衡则CheckHeight返回-1
	//需要o(n)的时间和o(h)的空间
	public static int checkHeight(TreeNode root){
		if(root == null){
			return 0;
		}else{
			//检查左子树是否平衡
			int leftHeight = checkHeight(root.leftChild);
			if (leftHeight == -1){
				return -1;
			}
			//检查右子树是否平衡
			int rightHeight = checkHeight(root.rightChild);
			if(rightHeight == -1){
				return -1;//不平衡
			}
			//检查当前节点是否平衡
			int heightDiff = leftHeight - rightHeight;
			if( Math.abs(heightDiff) > 1){
				return -1;//不平衡
			}else{
				//返回高度
				return Math.max(leftHeight, rightHeight) + 1;
			}
		}
	}
	
	public static boolean isBalanced2(TreeNode root){
		if(checkHeight(root) == -1){
			return false;
		}else{
			return true;
		}
	}
}

