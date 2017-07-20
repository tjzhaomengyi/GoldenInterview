package com.mikemyzhao.sort;

public class HeapSort {

	public int[] heapSort(int[] A,int n){
		BUILD_MAX_HEAP(A);
		SORT_HEAP(A);
		return A;
	}
	
	/**
	 * 堆排序
	 * 
	 */
	private void SORT_HEAP(int[] A){
		for(int i = A.length-1;i>=0;i--){
			swap(A,0,i);//将堆尾和堆顶交换
			//0~length(A)-1的堆，重新建堆
			MAX_HEAPIFY(A,0,i-1);
		}
	}
	
	/**
	 * 建堆
	 */
	private void BUILD_MAX_HEAP(int[] A){
		for(int i = A.length/2-1;i>=0;i--){
			MAX_HEAPIFY(A,i,A.length-1);
		}
		
	}
	
	private void MAX_HEAPIFY(int[] A,int i,int end){
		int l = LEFT(i);
		int r = RIGHT(i);
		int largest;
		if(l<=end && A[l] > A[i]){
			largest = l;
		}else{
			largest = i;
		}
		if(r < end && A[r] > A[largest]){
			largest = r;
		}
		if(largest != i){
			swap(A,i,largest);
			MAX_HEAPIFY(A,largest,end);
		}
	}
	
	private int LEFT(int i){
		return 2*i +1;
	}
	
	private int RIGHT(int i){
		return 2*i +2;
	}
	
	private void swap(int[] A,int a,int b){
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
		
	}
	
	
}
