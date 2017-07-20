package com.mikemyzhao.sort;

public class ShellSort {
	public static int[] shellSort(int[] A,int n){
		for(int steplen=n/2;steplen>=1;steplen/=2){
			sort(A,steplen);
		}
		return A;
	} 
	
	public static void sort(int[] A,int steplen){
		for(int i = steplen; i<A.length-1;i++){
			for(int j=i;j>=steplen;j=j-steplen){
				if(A[j] < A[j-steplen]){
					int temp = A[j];
					A[j] = A[j-steplen];
					A[j-steplen] = temp;
				}
			}
		}
	}
	
}
