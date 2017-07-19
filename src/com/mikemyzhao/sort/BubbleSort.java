package com.mikemyzhao.sort;

/**
 * 
 * @author mikemyzhao
 *
 *冒泡排序：
 *输入：测试样例[1,2,3,5,2,3],6
 *输出：[1,2,2,3,3,5]
 */
public class BubbleSort {
	public static int[] bubbleSort(int[] a,int n){
		for (int i = 0; i < n-1; i++){//要进行n-1次
			boolean finish = true;//某一次没做交换，说明已整体有序
			for(int j = 0; j < n-i-1; j++){//a[0...n-i-1]做冒泡
				if(a[j] > a[j+1]){
					finish = false;
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			if(finish){
				break;
			}
			
		}
		
		return a;
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,5,2,3};
		int[] b = bubbleSort(a,6);
		for (int i = 0; i < a.length; i++){
			System.out.print(b[i]+",");
		}
	}
}
