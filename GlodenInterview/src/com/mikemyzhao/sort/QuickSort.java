package com.mikemyzhao.sort;

import java.util.Arrays;

public class QuickSort {

	void quickSort(int arr[],int left,int right){
		int index = partition(arr,left,right);
		if(left < index - 1){
			quickSort(arr,left,index-1);
		}if(index < right){
			quickSort(arr,index,right);
		}
	}
	/*
	 *关键在partition这个递归调用，选出基准点pivot，
	 */
	
	int partition(int arr[],int left,int right){
		//int pivot = arr[left];
		int pivot = arr[(left+right)/2];
		//挑出一个基准点
		while(left <= right){
			//找出左边中应被放在右边的元素,注意下这两个while相当于就是left大于pivot和right小于pivot就停了，到if中进行交换去了
			while(arr[left] < pivot){
				left++;
			}
			//找出右边中应被放到左边的元素
			while(arr[right] > pivot){
				right--;
			}
			//交换元素，同时调整左右索引值
			if(left <= right){
				swap(arr,left,right);//交换元素
				left++;
				right--;
			}
				
		}
		return left;
	}
	
	private void swap(int[] arr,int pos,int expos){
		int temp;
		temp = arr[pos];
		arr[pos] = arr[expos];
		arr[expos] = temp;
	}
	
	public static void main(String[] args){
		int[] a = {6,9,5,8,2,1,3,4};
		QuickSort qs = new QuickSort();
		qs.quickSort(a,0,7);
		System.out.println(Arrays.toString(a));
	}
}
