package com.mikemyzhao.sort;

import java.util.Arrays;

/*
 * merge方法会将目标数组的所有元素拷贝到临时数组helper中，并记下数组左右两半的起始位置(helperLeft和helperRight)
 * 然后，迭代访问helper数组，将左右两半较小的元素，复制到目标数组中。最后，再讲余下所有元素复制到目标数组
 * 
 */
public class MergeSort {
	void mergesort(int[] array, int low, int high){
		if(low < high){
			int middle = (low + high) / 2;
			mergesort(array,low,middle);//排序左半部分
			mergesort(array,middle+1,high);//排序右半部分
			merge(array,low,middle,high);
		}
	}
	////将两个数组进行合并排序
	void merge(int[] array,int low,int middle,int high){
		int[] helper = new int[array.length];
		//将数组左右两半拷贝到helper数组中
		for(int i = low; i <= high; i++){
			helper[i] = array[i];
		}
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		//迭代访问helper数组。比较左右两半的元素，并将较小的元素复制到原先的数组中。
		while(helperLeft <= middle && helperRight <= high){
			if(helper[helperLeft] <= helper[helperRight]){
				array[current] = helper[helperLeft];
				helperLeft++;
			} else { //如果右边元素小于左边元素
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		//将数组左半部分剩余元素复制到目标数组中
		int remaining = middle -helperLeft;
		for(int i = 0; i <= remaining;i++){
			array[current+i] = helper[helperLeft+i];
		}
	}
	public void mergeSort(int[] array){
		mergesort(array,0,array.length-1);
		
	}
	
	
	public static void main(String[] args){
		int[] array = {4,2,6,9,8};
		
		MergeSort ms = new MergeSort();
		ms.mergeSort(array);
		System.out.println(Arrays.toString(array));
		
	}
}
