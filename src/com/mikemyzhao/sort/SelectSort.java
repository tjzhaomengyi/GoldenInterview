package com.mikemyzhao.sort;

/**
 * 
 * @author mikemyzhao 选择排序： 输入：[1,2,3,5,2,3],6 输出:[1,2,2,3,3,5] 数组中找出最小放在最前面
 */

public class SelectSort {
	public static int[] selectSort(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {// n-1次
			int min = Integer.MAX_VALUE;
			int indexOfMin = -1;
			// 从a[i...n-1]中找出最小值，与a[i]交换
			for (int j = i; j < n; j++) {
				if (a[j] < min) {
					min = a[j];
					indexOfMin = j;
				}
			}
			int temp = a[i];
			a[i] = a[indexOfMin];
			a[indexOfMin] = temp;
		}
		return a;
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,5,2,3};
		int[] b = selectSort(a,6);
		for (int i = 0; i < a.length; i++){
			System.out.print(b[i]+",");
		}
	}

}
